(ns brank-webapp.core
    (:require [compojure.core :refer [routes]]
      [ring.adapter.jetty :as server]
      [brank-webapp.handler.main :refer [main-routes]]
      [brank-webapp.handler.second :refer [second-routes]]))

(defonce server (atom nil))

(def app
  (routes
    second-routes
    main-routes))

(defn start-server []
      (when-not @server
                (reset! server (server/run-jetty #'app {:port 3000 :join? false}))))

(defn stop-server []
      (when @server
            (.stop @server)
            (reset! server nil)))

(defn restart-server []
      (when @server
            (stop-server)
            (start-server)))
