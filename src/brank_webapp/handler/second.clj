(ns brank-webapp.handler.second
    (:require [compojure.core :refer [defroutes context GET POST]]
      [brank-webapp.util.response :as res]
      [brank-webapp.view.second :as view]))

(def items
  [{:title "楽しい"}
   {:title "疲れた"}
   {:title "眠い"}
   {:title "追加した"}])

(defn second-page [req]
      (-> (view/second-page-view req items)
          res/response
          res/html))

(defroutes second-routes
           (GET "/second" _ second-page))
