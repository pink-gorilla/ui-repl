



[goog.string :as gstring]
    [goog.string.format]))

(str "$" (gstring/format "%.2f" 2.5))

 (:require [cljs.pprint :as pprint]))

(pprint/cl-format nil  "~,2f" 1.2345) ; => returns "1.23"
(pprint/cl-format true "~,2f" 1.2345) ; => prints "1.23", returns nil

ns client.ui
  (:require
   [goog.i18n.NumberFormat.Format])
  (:import
   (goog.i18n NumberFormat)
   (goog.i18n.NumberFormat Format)))

(def nff
  (NumberFormat. Format/DECIMAL))

(defn- nf
  [num]
  (.format nff (str num))




(defn date-format [date fmt & [tz]]
  (let [formatter (goog.i18n.DateTimeFormat. fmt)]
    (if tz
      (.format formatter date tz)
      (.format formatter date))))

(defn format
  "Formats a string using goog.string.format.
   e.g: (format \"Cost: %.2f\" 10.0234)"
8  [fmt & args]
  (apply gstring/format fmt args))

  [clojure.string :as s]
    [goog.string :as gstring]
    [goog.string.format]
    [goog.i18n.DateTimeFormat :as dtf]

