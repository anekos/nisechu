(ns nise-chu.web.core
  (:require [nise-chu.han :refer [chinize]]
            [ring.util.response :refer [charset]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [nise-chu.web.html :as html]))


(defn gen-html [snippet & args]
  (reduce str (apply snippet args)))

(defroutes router
  (GET "/" []
       (gen-html html/index))
  (GET "/translate" {{jpn "jpn"} :params}
       (chinize jpn))
  (GET "/translate/:jpn" [jpn]
       (chinize jpn))
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (wrap-params router))
