(ns pinkgorilla.repl.cljs.format
  (:require
   [goog.string :as gstring]
   [goog.string.format]
   [goog.i18n.NumberFormat.Format]
   [goog.i18n.DateTimeFormat :as dtf])
  (:import
   (goog.i18n NumberFormat)
   (goog.i18n.NumberFormat Format)))

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

; https://github.com/thi-ng/strf/







