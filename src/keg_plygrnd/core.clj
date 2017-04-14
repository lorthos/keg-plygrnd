(ns keg-plygrnd.core
  (:require [powderkeg.core :as keg]
            [net.cgrand.xforms :as x])
  :gen-class)

(defn -main []
  (let [
        ;conn (keg/connect! "yarn-cluster")
        rdd (.textFile keg/*sc* "s3://lorthos-emr/*.csv")
        courses (into []
                      (rdd (filter #(.contains % "spark"))))]
    (println courses)
    )
  )
