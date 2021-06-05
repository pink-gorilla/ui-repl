(ns pinkgorilla.repl
  "important stuff that will be needed by notebook users.
   it should be easy to find this functions, so they in one namespace."
  (:require
   ;[cemerick.pomegranate :as pg]
   ;[clojure.tools.deps.alpha.repl :refer [add-libs]]
   [clojure.java.io :as io])
  (:import (java.io PushbackReader)))

(def default-requires-atom (atom []))

(defn add-require [r]
  (swap! default-requires-atom conj r))

(defmacro require-default []
  (let [rs @default-requires-atom]
    (concat (list 'do) (map (fn [r] (list 'require `(quote ~r))) rs))))

(comment
  (add-require '[clojure.string :as str])
  (add-require '[clojure.pprint :as pprint])
  (add-require '[clojure.pprint :as pprint :refer [print-table]])
  @default-requires-atom

  (macroexpand '(default-requires))
  (default-requires)
  (str/join ["a" "b"])
  (pprint/print-table [{:a 1 :b 2} {:a "s" :b 45545}])
  (print-table [{:a 1 :b 2} {:a "s" :b 45545}])
 ; 
  )



; tools.deps add-lib dynamic
;(require '[clojure.tools.deps.alpha.repl :refer [add-lib]])
;(add-libs {'domain/library {:mvn/version "RELEASE"}})


(defn load-edn- [resource]
  (when resource
    (try
      (-> resource
          (io/reader)
          (PushbackReader.)
          (read))
      (catch Exception _
        (throw (Exception. (str "Error parsing edn resource " resource)))))))

(defn load-edn-resource
  "libraries can dynamically add resources.
   to easily load a resource from a library, we add this as a helper function"
  [name]
  (let [;resource (io/file name)
        resource (io/resource name)]
    (if resource
      (load-edn- resource)
      (println "resource not found: " name))))

(defn info []
  {:java (-> (System/getProperties) (get "java.version"))
   :clojure (clojure-version)
   :notebook (System/getProperty "projectname.version")})

#_(defn get-setting [path]
    (pinkgorilla.notebook-app.system/get-setting path))

(defonce secrets-atom (atom {}))

(defn secrets []
  @secrets-atom)

(defn secret [k]
  (k @secrets-atom))

#_(defn secret
    "loads a secret (for example an api token or ssh key)
   currently expects ./test/creds.edn file

   In future will allow to access secrets that are in web browser 
   so that user can set his credentials securely.

   Note that this is a file, not a resource, as the user has to set it."
    [k]
    (let [resource (io/file "./test/creds.edn")
        ;resource (load-edn- (io/resource "creds.edn") 
          ]
      (if resource
        (k (load-edn- resource))
        (println "secret has not found creds.edn"))))
