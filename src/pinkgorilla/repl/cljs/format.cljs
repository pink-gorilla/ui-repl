(ns pinkgorilla.repl.cljs.format
  (:require
   [goog.string :as gstring]
   [goog.string.format]
   [goog.i18n.NumberFormat.Format]
   [goog.i18n.DateTimeFormat :as dtf]
   [tick.core :as t]
   [tick.locale-en-us] ; a locale is needed for date formatting
   )
  (:import
   (goog.i18n NumberFormat)
   (goog.i18n.NumberFormat Format)))

(defn to-fixed [nr digits]
  (.toFixed nr digits))

(defn format
  "Formats a string using goog.string.format.
   e.g: (format \"Cost: %.2f\" 10.0234)"
  [fmt & args]
  (apply gstring/format fmt args))

;(def nff
;  (NumberFormat. Format/DECIMAL))

;(defn nf
;  [num]
;  (.format nff (str num)))

;(defn date-format [date fmt & [tz]]
;  (let [formatter (goog.i18n.DateTimeFormat. fmt)]
;    (if tz
;      (.format formatter date tz)
;      (.format formatter date))))

; (:require [cljs.pprint :as pprint]))
; (pprint/cl-format nil  "~,2f" 1.2345) ; => returns "1.23"
; (pprint/cl-format true "~,2f" 1.2345) ; => prints "1.23", returns nil

(defn dt-format [fmt dt]
  (let [dtz (t/zoned-date-time dt)]
    (t/format (t/formatter fmt) dtz)))

; https://github.com/thi-ng/strf/







