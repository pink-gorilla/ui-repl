(ns pinkgorilla.repl.cljs.js
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]))

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


