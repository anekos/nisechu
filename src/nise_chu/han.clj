(ns nise-chu.han
  (:import java.lang.Character$UnicodeBlock)
  (:require [clojure.string :as string]))


(defn- han? [c]
  (=
    (Character$UnicodeBlock/of c)
    Character$UnicodeBlock/CJK_UNIFIED_IDEOGRAPHS))

(defn- han-han [text]
  (apply
    str
    (filter han? text)))

(def cha-han-table
  [["私" "我"]
   ["大変" "非常"]])

(defn cha-han [text]
  (reduce
    (fn [acc [from to]]
      (string/replace acc from to))
    text
    cha-han-table))

(defn chinize [text]
  (-> text
    han-han
    cha-han))
