(ns pinkgorilla.repl.clipboard
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]))

(defonce clipboard (atom nil))

(defn clipboard-set [val]
  (info "clipboard-set: " val)
  (reset! clipboard val))

(defn clipboard-pop []
  (let [val @clipboard]
    (info "clipboard-pop: " val)
    (reset! clipboard nil)
    val))