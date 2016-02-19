(ns nise-chu.oauth
  (:require [twitter.oauth :as toa]
             [oauth.client :as oa]))

(def consumer-key "C6GWpl4gSq1YRNt4txsaaV5NT")
(def consumer-key-secret "20EbDYDHFOZBsUE9MvGDCQsExfNMsBoj5JLNDshF1KmGqsUnrW")

(def consumer (oa/make-consumer consumer-key
                                consumer-key-secret
                                "https://api.twitter.com/oauth/request_token"
                                "https://api.twitter.com/oauth/access_token"
                                "https://api.twitter.com/oauth/authorize"
                                :hmac-sha1))

(def request-token (oa/request-token consumer nil))

(defn get-access-token []
  (println "See:" (oa/user-approval-uri consumer (:oauth_token request-token)))
  (print "and Please input PIN number: ")
  (flush)
  (let [verifier (read-line)]
    (oa/access-token consumer request-token verifier)))

(defn make-creds [config]
  (toa/make-oauth-creds consumer-key
                        consumer-key-secret
                        (:oauth_token config)
                        (:oauth_token_secret config)))
