(ns keg-plygrnd.core
  (:require [powderkeg.core :as keg]
            [net.cgrand.xforms :as x]))

(keg/connect! "spark://macbook-pro.home:7077")

(def rdd (.textFile keg/*sc* "s3://lorthos-emr/*.csv"))

(into []
      (rdd (filter #(.contains % "spark"))))
