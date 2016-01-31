(ns twit-hear.handler.second
    (:require [compojure.core :refer [defroutes context GET POST]]
      [twit-hear.util.response :as res]
      [twit-hear.view.second :as view]))

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
