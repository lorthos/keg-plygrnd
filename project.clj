(defproject keg-plygrnd "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [hcadatalab/powderkeg "0.5.1"]

                 ;repl
                 [com.cemerick/drawbridge "0.0.7"]

                 [org.clojure/tools.nrepl "0.2.10"]
                 [compojure "1.6.0"]
                 [ring/ring-jetty-adapter "1.6.0"]
                 [ring/ring-core "1.6.0"]

                 [gorilla-repl "0.4.0"]
                 ]

  :profiles {:provided
             {:dependencies
              [
               [org.apache.spark/spark-core_2.11 "2.1.0"]
               [org.apache.spark/spark-streaming_2.11 "2.1.0"]
               ]}}

  :repl-options {
                 :host "0.0.0.0"
                 :port 4002
                 }

  :main keg.core
  :aot [keg.core]

  )


