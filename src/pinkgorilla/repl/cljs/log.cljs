(ns pinkgorilla.repl.cljs.log
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]))

; timbre macros name info gets later replaced by info function.

(defn info [& args]
  (info args))

(defn warn [& args]
  (warn args))

(defn error [& args]
  (error args))