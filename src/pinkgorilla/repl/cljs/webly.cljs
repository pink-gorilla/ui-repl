(ns pinkgorilla.repl.cljs.webly
  (:require
   [re-frame.core :as rf]
   [frontend.notifications.core :refer [add-notification]]))

; this is a clojurescript namespace
; functions that should be available to all goldly systems

(defn dialog [f & [size]]
  (if size
    (rf/dispatch [:modal/open f :small])
    (rf/dispatch [:modal/open f])))

(defn notify [& args]
  (apply add-notification args))





