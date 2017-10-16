# keg-plygrnd

Easy to run Clojure (Powderkeg) REPL on Spark

## Usage

### Build jar

        lein uberjar

### Run on Spark

        spark-submit --master yarn-client --class keg.patch target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar

### Exports to use makefile

		export S3_DEPLOY_BUCKET = <BUCKET_NAME>
		export EC2_ATTRIBUTES = <subnet, keyname etc..>
		export CLUSTER_ID = <cluster id>

### Run on EMR with Step API

        make build
        make deploy_s3
        make submit_step


## repl on Cluster Over HTTP
        lein repl :connect  http://HOST:5555/nrepl

## Gorilla Repl On Cluster
        http://HOST:5556/worksheet.html



## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
