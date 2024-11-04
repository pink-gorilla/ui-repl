(ns tick.helper
  (:require
   [tick.core :as t]
   [tick.locale-en-us] ; a locale is needed for date formatting
   ))
(defn dt-format
  "formats a date 
   fmt can be keyword
     :iso-local-date-time
   or a js-joda format string"
  [fmt dt]
  (let [zdt (-> dt
                (t/in "UTC"))]
    (t/format (t/formatter fmt) zdt)))