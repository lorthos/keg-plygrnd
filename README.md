# keg-plygrnd

Easy to run Clojure (Powderkeg) REPL on Spark

## Usage

### Build jar

        lein uberjar

### Run on Spark

        spark-submit --master yarn-client --class keg.core target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar

### Run on EMR with Step API

        (copy uberjar to s3)
        aws s3 cp target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar s3://lorthos-emr/keg.jar
        aws emr add-steps --cluster-id j-XXX \
        --steps Type=CUSTOM_JAR,Name="Spark Program",Jar="command-runner.jar",ActionOnFailure=CONTINUE,Args=["spark-submit",--master,yarn-client,--class,keg.core,s3://lorthos-emr/keg.jar]


## repl on Cluster Over HTTP
        lein repl :connect  http://HOST:5555/nrepl

## Gorilla Repl On Cluster
        http://HOST:5556/worksheet.html



## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
