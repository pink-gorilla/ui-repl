(ns pinkgorilla.repl.cljs.http
  (:require
   [clojure.edn :as edn]
   ;[ajax.core]
   [cljs.core.async :refer [<! >! chan close!] :refer-macros [go]]
   [cljs-http.client :as http]
   [cemerick.url :as url]
   [clojure.string :as str]))

(defn- make-get [process]
  (fn [url a path & [opts]]
    (let [opts (or opts {:with-credentials? false  ; true blocks remote api with corsrequests
                         })]
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

(defn application-url
  "gets the current url, as a map"
  []
  (url/url (-> js/window .-location .-href)))

(defn ws-origin
  "useful to get a websocket to a path on the same server as the website is loaded from"
  [path]
  (let [app-url (application-url)
        proto (if (= (:protocol app-url) "http") "ws" "wss")
        port-postfix  (let [port (:port app-url)]
                        (if (< 0 port)
                          (str ":" port)
                          ""))]
    (str proto ":" (:host app-url) port-postfix (str/replace (:path app-url) #"[^/]+$" path))))