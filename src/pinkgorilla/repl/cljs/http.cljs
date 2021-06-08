(ns pinkgorilla.repl.cljs.http
  (:require
   [clojure.edn :as edn]
   ;[ajax.core]
   [cljs.core.async :refer [<! >! chan close!] :refer-macros [go]]
   [cljs-http.client :as http]))

(defn- make-get [process]
  (fn [url a path & [opts]]
    (let [opts (or opts {})]
      (go (let [response (<! (http/get url opts))
                body (:body response)
                _ (println "body: " body "type: " (type body))
                data (-> body process)]
            (swap! a assoc-in path data)
            nil)))))

(def get-str (make-get identity))

(def get-edn (make-get identity)) ; edn/read-string

(defn parse-json [s]
  (-> s js/JSON.parse js->clj))

;(def get-json (make-get parse-json))

(def get-json (make-get identity))

; {:with-credentials? false
;   :query-params {"since" 135}}