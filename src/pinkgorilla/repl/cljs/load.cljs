(ns pinkgorilla.repl.cljs.load
  (:require
   [promesa.core :as p]
   [clojure.edn :as edn]
   [ajax.core :refer [GET POST]]
   [clojure.string :as str]))

(defn http-get
  ([url]
   (http-get url {}))
  ([url params]
   (p/create
    (fn [resolve reject]
      (GET url (merge
                params
                {:handler (fn [response]
                            (resolve response))
                 :error-handler (fn [error]
                                  (reject error))}))))))




