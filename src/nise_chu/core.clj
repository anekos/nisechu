(ns nise-chu.core
  (:require [clojure.pprint :as pp]
            [nise-chu.config :as conf]
            [twitter.api.restful :as api]))


(defn say [creds text]
  (api/statuses-update :oauth-creds creds :params {:status text}))


(defn shell [{creds :creds}]
  (loop []
    (print "偽中 > ")
    (flush)
    (let [line (read-line)]
      (say creds line)
      (pp/pprint line)
      (when line (recur)))))

(defn -main [& args]
  (let [config (conf/get-config)]
    (shell config)))
