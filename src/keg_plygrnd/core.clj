(ns keg-plygrnd.core
  (:gen-class))

(defn -main []
  (println "does nothing"))


(comment
  spark-submit --master yarn-client --class powderkeg.repl target/keg-plygrnd-0.1.0-SNAPSHOT-standalone.jar


  (require '[powderkeg.core :as keg])
  (require '[net.cgrand.xforms :as x])

  (keg/connect! "yarn-client")

  (.textFile keg/*sc* "s3://lorthos-emr/*.csv")

  (into [] (filter #(.contains % "math"))
        (.textFile keg/*sc* "s3://lorthos-emr/*.csv"))
  )