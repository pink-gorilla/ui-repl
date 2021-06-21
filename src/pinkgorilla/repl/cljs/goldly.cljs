(ns pinkgorilla.repl.cljs.goldly
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [re-frame.core :as rf]
   ;[goldly-bindings-generated]
   ))

; this is a clojurescript namespace
; functions that should be available to all goldly systems

(defn set-system-state [system-id result where]
  (rf/dispatch [:goldly/set-system-state {:system-id system-id
                                          :result result
                                          :where where}]))

#_(defn bindings []
    (-> goldly-bindings-generated/bindings-generated
        keys))





