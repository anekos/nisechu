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
        ;(say creds chinized)
        (pp/pprint chinized)
        (recur)))))

(defn -main [& args]
  (let [config (conf/get-config)]
    (shell config)))
