PROJECT=powderkeg-on-emr

clean:
	@lein clean

clean_s3:
	@aws s3 rm --only-show-errors s3://${S3_DEPLOY_BUCKET}/keg.jar

build: clean
	@lein compile
	@lein uberjar

deploy_s3:
	@aws s3 cp ./target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar s3://${S3_DEPLOY_BUCKET}/keg.jar

start_emr:
	@aws emr create-cluster --name "Powderkeg" --release-label emr-5.7.0  \
	--applications Name=Hadoop Name=Spark  Name=Ganglia  --instance-groups InstanceGroupType=MASTER,InstanceCount=1,InstanceType=c4.xlarge,BidPrice=0.1 \
	InstanceGroupType=CORE,InstanceCount=1,InstanceType=c4.2xlarge,BidPrice=0.12 --ec2-attributes ${EC2_ATTRIBUTES}

submit_step:
	@aws emr add-steps --cluster-id ${CLUSTER_ID} \
    --steps Type=Spark,Name="Spark Program",ActionOnFailure=CONTINUE,Args=["--deploy-mode","cluster","--class","keg.patch","s3://${S3_DEPLOY_BUCKET}/keg.jar"]
