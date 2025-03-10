(ns pinkgorilla.repl.cljs.http
  (:require
   [clojure.edn :as edn]
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [cljs.core.async :refer [<!] :refer-macros [go]]
   [cljs-http.client :as http]
   [cemerick.url :as url]
   [clojure.string :as str]))

;; this needs to go. core.async cannot be used in sci clojurescript. 580 stars
;; clj-ajax has 670 stars 

;; used in:
;; pink-gorilla/reval/reval-ui/src/reval/helper/url_loader.cljs
;; --> so it is clear that reval needs to be rewriten first.
;; pink-gorilla/webly/demo/src/demo/page/help.cljs
;; pink-gorilla/demo/src/page/leaflet_iss.cljs

(defn- make-get [process]
  (fn [url a path & [opts]]
    (let [opts (or opts {:with-credentials? false  ; true blocks remote api with corsrequests
                         })]
      (go (let [response (<! (http/get url opts))
                body (:body response)
                _ (info "body: " body "type: " (type body))
                data (-> body process)]
            (swap! a assoc-in path data)
            nil)))))

(def get-str (make-get identity))

(defn parse-edn [s]
  (if (string? s)
    (edn/read-string s)
    s))

(def get-edn (make-get parse-edn))

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