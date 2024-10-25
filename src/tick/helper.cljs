(ns tick.helper
  (:require
   [tick.core :as t]
   [tick.locale-en-us] ; a locale is needed for date formatting
   ))

(defn dt-format [fmt dt]
  ;; note: this implicitly converts to local time!!
  ;; quanta.studio has a UTC version.
  (let [dtz (t/zoned-date-time dt)]
    (t/format (t/formatter fmt) dtz)))