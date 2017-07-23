# keg-plygrnd

Playground for Powderkeg & EMR

## Usage

        lein uberjar
        spark-submit --master yarn-client --class powderkeg.repl target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar


## Remote Nrepl over Http

        spark-submit --master yarn-client --class keg.core target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar
        lein repl :connect  http://HOST:5555/nrepl

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
