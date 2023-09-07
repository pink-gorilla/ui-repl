(ns pinkgorilla.repl.cljs.ajax
  (:require
   [promesa.core :as p]
   [clojure.edn :as edn]
   [ajax.core :refer [GET POST PUT DELETE]]
   [clojure.string :as str]))

(defn wrap-promise
  [AJAX-TYPE url params]
  (p/create
   (fn [resolve reject]
     (AJAX-TYPE url
                (merge params
                       {:handler (fn [response]
                                   (resolve response))
                        :error-handler (fn [error]
                                         (reject error))})))))

(defn http-get
  ([url] (http-get url {}))
  ([url params] (wrap-promise GET url params)))

(defn http-post
  ([url] (http-post url {}))
  ([url params] (wrap-promise POST url params)))

(defn http-put
  ([url] (http-put url {}))
  ([url params] (wrap-promise PUT url params)))

(defn http-delete
  ([url] (http-delete url {}))
  ([url params] (wrap-promise DELETE url params)))




