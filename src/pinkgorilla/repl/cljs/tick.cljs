(ns pinkgorilla.repl.cljs.tick
  (:require
   [tick.core :as t]
   [tick.locale-en-us] ; a locale is needed for date formatting
   ))

(defn dt-format [fmt dt]
  (let [dtz (t/zoned-date-time dt)]
    (t/format (t/formatter fmt) dtz)))