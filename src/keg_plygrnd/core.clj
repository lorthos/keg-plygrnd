(ns keg-plygrnd.core
  (:require [powderkeg.core :as keg]
            [net.cgrand.xforms :as x]))

(defn -main []
  )


(comment
  (require '[powderkeg.core :as keg])
  (require '[net.cgrand.xforms :as x])

  (keg/connect! "yarn-client")

  (.textFile keg/*sc* "s3://lorthos-emr/*.csv")

  (into [] (filter #(.contains % "math"))
        (.textFile keg/*sc* "s3://lorthos-emr/*.csv"))
  )