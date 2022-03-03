(ns pinkgorilla.repl.cljs.webly
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]
   [frontend.routes :as wr]
   [frontend.notifications.core :refer [add-notification]]))

; this is a clojurescript namespace
; functions that should be available to all goldly systems

(defn nav [& args]
  (rf/dispatch (into [] (concat [:bidi/goto] args))))

(defn current-route []
  @wr/current)

(defn dialog [f & [size]]
  (if size
    (rf/dispatch [:modal/open f :small])
    (rf/dispatch [:modal/open f])))

(defn notify [& args]
  (apply add-notification args))





