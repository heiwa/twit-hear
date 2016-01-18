(ns brank-webapp.view.main
    (:require [brank-webapp.view.layout :as layout]))

(defn home-view [req]
      (->> [:section.card
            [:h2 "ホーム画面"]
            [:a {:href "second"} "ページ遷移"]]
          (layout/common req)))

