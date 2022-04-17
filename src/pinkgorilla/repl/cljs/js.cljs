(ns pinkgorilla.repl.cljs.js
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]
   [goog.string :as gstring]
   [goog.string.format]
   [goog.object]))

; this is a clojurescript namespace
; functions that should be available to all goldly systems
(defn timeout [f ms]
  (js/setTimeout f ms))

(defn interval [f ms]
  (js/setInterval f ms))

#_(defn repeat [f ms]
    (.setTimeout
     js/window
     (fn []
       (f)
       (repeat f ms))
     ms))

(defn parse-float [s]
  (js/parseFloat s))

(defn alert [s]
  (js/alert s))

(defn evt-val [e]
  (.. e -target -value))

(defn sin [x]
  (.sin js/Math x))

;; js object -> cljs map
;; https://stackoverflow.com/questions/32467299/clojurescript-convert-arbitrary-javascript-object-to-clojure-script-map

#_(defn obj->clj
    [obj]
    (-> (fn [result key]
          (let [v (goog.object/get obj key)]
            (if (= "function" (goog/typeOf v))
              result
              (assoc result key v))))
        (reduce {} (.getKeys goog/object obj))))

#_(defn obj->clj
    [obj]
    (if (goog.isObject obj)
      (-> (fn [result key]
            (let [v (goog.object/get obj key)]
              (if (= "function" (goog/typeOf v))
                result
                (assoc result key (obj->clj v)))))
          (reduce {} (.getKeys goog/object obj)))
      obj))

(defn jsx->clj
  [x]
  (into {} (for [k (.keys js/Object x)] [k (goog.object/get x k)])))