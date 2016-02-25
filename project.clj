(defproject nise-chu "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-oauth "1.5.4"]
                 [twitter-api "0.7.8"]]
  :main nise-chu.core
  :bin {:name "nise-chu"
        :bootclasspath true}
  :aot [nise-chu.core])
