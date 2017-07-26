(ns keg.core
  (:require [keg.repl :as nrepl]
            [gorilla-repl.core :as g]
            [clojure.pprint :as pp])
  (:gen-class))

;; This is the leiningen task. It needs no arguments, and can run outside a project (assuming you've got the plugin
;; installed in your profile).
(defn gorilla
  [& opts]
  (let [opts-map (apply hash-map opts)
        port (read-string (or (get opts-map ":port") "0"))
        ip (or (get opts-map ":ip") "0.0.0.0")
        nrepl-port (read-string (or (get opts-map ":nrepl-port") "0"))
        ;; inject the gorilla-repl dependency into the target project
        gorilla-options {}]
    (g/run-gorilla-server {:port port
                              :ip ip
                              :nrepl-port nrepl-port
                              :version "0.4.0"
                              :project "keg-plygrnd"
                              :gorilla-options gorilla-options})
        ))

(defn -main []
  (println "starting nrepl")
  (nrepl/start-nrepl! 5555)
  (gorilla))


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
