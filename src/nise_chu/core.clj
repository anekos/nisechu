(ns nise-chu.core
  (:require [nise-chu.han :refer [chinize]]
            [ring.adapter.jetty :refer [run-jetty]]
            [clojure.pprint :as pp]
            [nise-chu.config :as conf]
            [nise-chu.web.core :refer [app]]
            [twitter.api.restful :as api])
  (:gen-class))


(defn say [creds text]
  (api/statuses-update :oauth-creds creds :params {:status text}))

(defn shell [{creds :creds}]
  (loop []
    (print "偽中 > ")
    (flush)
    (when-let [line (read-line)]
      (let [chinized (chinize line)]
        (when creds
          (say creds chinized))
        (println chinized)
        (recur)))))

(defn -main [& args]
  (let [[sub] args]
    (cond
      (= sub "test") (shell nil)
      (= sub "twitter") (shell (conf/get-config))
      (= sub "web") (run-jetty app {:port 3000}))))
