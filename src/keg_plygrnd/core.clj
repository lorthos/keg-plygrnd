(ns keg-plygrnd.core
  (:require [powderkeg.core :as keg]
            [net.cgrand.xforms :as x]))

(defn -main []
  (let [
        ;conn (keg/connect! "yarn-cluster")
        rdd (.textFile keg/*sc* "s3://lorthos-emr/*.csv")
        courses (into []
                      (rdd (filter #(.contains % "spark"))))]
    (println courses)
    )
  )
