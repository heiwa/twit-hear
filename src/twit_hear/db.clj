(ns twit-hear.db
    (:require [clojure.java.jdbc :as jdbc]
              [environ.core :refer [env]]))

; 値のセットはちゃんとしてね。
(def db-spec
  (:db env))

(defn migrate []
      (jdbc/db-do-commands
        db-spec
        (jdbc/create-table-ddl :tablename [:id :serial] [:title :varchar])))

