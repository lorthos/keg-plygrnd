(ns keg.core
  (:require [keg.repl :as nrepl]
            [gorilla-repl.core :as g]
            [clojure.pprint :as pp])
  (:gen-class))



(defn -main []
  (println "starting gorilla repl...")
  (g/run-gorilla-server {:port            5556
                         :ip              "0.0.0.0"
                         :nrepl-port      5557
                         :version         "0.4.0"
                         :project         "keg-plygrnd"
                         :gorilla-options {}})
  (println "starting nrepl ...")
  ;(nrepl/start-nrepl! 5555)
  )


(comment
  spark-submit --master yarn-client --class powderkeg.repl target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar


  (require '[powderkeg.core :as keg])
  (require '[net.cgrand.xforms :as x])

  (keg/connect! "yarn-client")

  (.textFile keg/*sc* "s3://lorthos-emr/*.csv")

  (into [] (filter #(.contains % "math"))
        (.textFile keg/*sc* "s3://lorthos-emr/*.csv"))
  )


;remote repl
; spark-submit --master yarn-client --class keg.core target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar
