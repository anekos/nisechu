(defproject nise-chu "0.1.0-SNAPSHOT"
  :description "偽中国語"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[enlive "1.1.6"]
                 [org.slf4j/slf4j-simple "1.7.18"]
                 [org.clojure/clojure "1.7.0"]
                 [clj-oauth "1.5.4"]
                 [twitter-api "0.7.8"]
                 [ring "1.4.0"]
                 [compojure "1.4.0"]]
  :main nise-chu.core
  :bin {:name "nise-chu"
        :bootclasspath true}
  :aot [nise-chu.core]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler nise-chu.web.core/app})
