(ns brank-webapp.handler.second
    (:require [compojure.core :refer [defroutes context GET POST]]
      [brank-webapp.util.response :as res]))

(def items
  [{:title "楽しい"}
   {:title "疲れた"}
   {:title "眠い"}])

(defn second-page-view [req]
      `("<h1>ページ遷移できた</h1>"
         "<ul>"
         ~@(for [{:keys [title]} items]
                (str "<li>" title "</li>"))
         "</ul>"))

(defn second-page [req]
      (-> (second-page-view req)
          res/response
          res/html))

(defroutes second-routes
           (GET "/second" _ second-page))
