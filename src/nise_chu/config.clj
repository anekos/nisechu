(ns nise-chu.config
  (:require [clojure.pprint :as pp]
            [clojure.java.io :as io]
            [nise-chu.oauth :as oauth]))


(def config-file
  (io/file (System/getProperty "user.home") ".nise-chu.clj"))

(defn- write-object-to-file [file object]
  (with-open [w (io/writer file)]
    (pp/write object
              :stream w)))

(defn- make-config-file []
  (let [token (oauth/get-access-token)]
    (write-object-to-file config-file token)
    token))

(defn get-config []
  (let [config
        (if (.exists config-file)
          (load-file (.getPath config-file))
          (make-config-file))]
    (into config {:creds (oauth/make-creds config)})))
