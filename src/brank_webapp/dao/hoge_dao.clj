(ns brank-webapp.dao.hoge-dao
    (:require [clojure.java.jdbc :as jdbc]
      [brank-webapp.db :as db]))

(defn save-item [title]
      (jdbc/insert! db/db-spec :tablename {:title title}))

(defn find-all []
      (jdbc/query db/db-spec "select * from tablename"))

