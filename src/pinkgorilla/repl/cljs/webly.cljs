(ns pinkgorilla.repl.cljs.webly
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]
   [webly.user.notifications.core :refer [add-notification]]))

; this is a clojurescript namespace
; functions that should be available to all goldly systems

(defn nav [& args]
  (rf/dispatch (into [] (concat [:bidi/goto] args))))

(defn dialog [f & [size]]
  (if size
    (rf/dispatch [:modal/open f :small])
    (rf/dispatch [:modal/open f])))

(defn notify [s]
  (add-notification s))


