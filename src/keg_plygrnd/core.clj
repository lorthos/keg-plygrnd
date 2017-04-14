(ns keg-plygrnd.core
  (:require [powderkeg.core :as keg]
            [net.cgrand.xforms :as x]))

(defn get-rdd []
  (.textFile keg/*sc* "s3://bucketr/*.csv"))

(defn -main []
  (let [
        ;conn (keg/connect! "yarn-client")

        courses (into []
                      (filter #(.contains % "spark")) (get-rdd))]
    (println courses)
    )
  )
