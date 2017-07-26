# keg-plygrnd

Easy to run Clojure (Powderkeg) REPL on Spark

## Usage

### Build jar

        lein uberjar

### Run on Spark

        spark-submit --master yarn-client --class powderkeg.repl target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar

### Run on EMR with Step API



## repl on Cluster Over HTTP
        lein repl :connect  http://HOST:5555/nrepl

## Gorilla Repl On Cluster
        lein repl :connect  http://HOST:5555/nrepl



## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
