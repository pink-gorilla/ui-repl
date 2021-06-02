(ns pinkgorilla.repl.fun
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]
   [pinkie.pinkie :refer-macros [register-component]]))

; this is a clojurescript namespace
; functions that should be available to all goldly systems


(defn nav [& args]
  (rf/dispatch (into [] (concat [:bidi/goto] args))))

(defn set-system-state [system-id result where]
  (rf/dispatch [:goldly/set-system-state {:system-id system-id
                                          :result result
                                          :where where}]))

(defn modal [f & [size]]
  (if size
    (rf/dispatch [:modal/open [f] :small])
    (rf/dispatch [:modal/open [f]])))

(defn timeout [f ms]
  (js/setTimeout f ms))

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


