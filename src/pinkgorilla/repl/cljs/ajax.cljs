(ns pinkgorilla.repl.cljs.ajax
  (:require
   [promesa.core :as p]
   [clojure.edn :as edn]
   [ajax.core :refer [GET POST PUT]]
   [clojure.string :as str]))

(defn- make-promise [AJAX-TYPE]
  ([url]
   (make-promise url {}))
  ([url params]
   (p/create
    (fn [resolve reject]
      (AJAX-TYPE url
                 (merge params
                        {:handler (fn [response]
                                    (resolve response))
                         :error-handler (fn [error]
                                          (reject error))}))))))

(def http-get (make-promise GET))
(def http-post (make-promise POST))
(def http-put (make-promise PUT))




