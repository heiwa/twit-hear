(ns twit-hear.view.second
    (:require [twit-hear.view.layout :as layout]))

(defn second-page-view [req items]
      (->> `([:h1 "ページ遷移できた"]
            [:ul
             ~@(for [{:keys [title]} items]
              [:li title])])
          (layout/common req)))
