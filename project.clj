(defproject twit-hear "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring "1.4.0"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [environ "1.0.1"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [org.twitter4j/twitter4j-core "3.0.5"]]
  :plugins [[lein-environ "1.0.1"]
            [lein-ring "0.8.11"]]
  :ring {:handler twit-hear.core/app
         :uberwar-name "twit-hear-clj.war"}
  :war-resource-path "resources"
  ;:uberjar-name "twit-hear-clj.jar"
  :profiles
  {:dev {:dependencies [[prone "0.8.2"]]
         :env          {:dev true
                        :db  {:dbtype "mysql" :dbname "dbname" :host "localhost" :port 5432 :user "username" :password "password"}}}
   ; :uberjar
   ; {:aot  :all
   ;:main twit-hear.main
   ; }
   }

  :min-lein-version "2.5.3")
