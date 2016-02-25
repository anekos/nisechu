(ns nise-chu.core
  (:use nise-chu.han)
  (:require [clojure.pprint :as pp]
            [nise-chu.config :as conf]
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
    (shell
      (if (= sub "test")
        nil
        (conf/get-config)))))
