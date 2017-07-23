(ns keg.repl
  "repl over http"
  (:require
    [cemerick.drawbridge :as drawbridge]
    [ring.middleware.params :as params]
    [ring.middleware.keyword-params :as keyword-params]
    [ring.middleware.nested-params :as nested-params]
    [ring.middleware.session :as session]
    [ring.adapter.jetty :as jetty]
    [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]))


(def drawbridge-handler
  (-> (cemerick.drawbridge/ring-handler)
      (keyword-params/wrap-keyword-params)
      (nested-params/wrap-nested-params)
      (params/wrap-params)
      (session/wrap-session)))

(defroutes app
           (GET ["/ping"] req
             "pong")
           (ANY ["/nrepl"] req
             (drawbridge-handler req)))


(defn start-nrepl! [& [port]]
  (jetty/run-jetty app
                   {:port port :join? false})
  )