(ns brank-webapp.core
    (:require [compojure.core :refer [routes]]
      [ring.adapter.jetty :as server]
      [ring.middleware.resource :as resource]
      [brank-webapp.handler.main :refer [main-routes]]
      [brank-webapp.handler.second :refer [second-routes]]
      [brank-webapp.middleware :refer [wrap-dev]]
      [environ.core :refer [env]]))

(defn- wrap [handler middleware opt]
       (if (true? opt)
         (middleware handler)
         (if opt
           (middleware handler opt)
           handler)))
(def app
  (-> (routes
      second-routes
      main-routes)
      (wrap wrap-dev (:dev env))
      (wrap resource/wrap-resource "public")))

(defonce server (atom nil))

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
