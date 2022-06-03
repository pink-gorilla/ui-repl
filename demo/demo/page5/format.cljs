(ns demo.page5.format
  (:require
   [goldly.page :as page]
   [goog.string]
   [tick.core :as t]
   [tick.goldly]
   [goldly.js :refer [parse-float to-fixed]]))

(parse-float "34")

(defn to-fixed-nr [n d]
  [:p "to-fixed digits: " d " result: " 
   (to-fixed n d)
   ;n
   
   ])

(defn format-nr [n f]
  [:p "format string: " [:span.text-blue-300 f] " result: " (goog.string/format f n)])

;(defn fmt-yyyymmdd [dt]
;  (when dt
;    (dt-format "YYYYMMdd" dt)))

(defn format-page [{:keys [_route-params _query-params _handler] :as _route}]
  [:div

   [:h1 "to-fixed"]
   [to-fixed-nr  2.511 3]
   [to-fixed-nr  2.511 2]
   [to-fixed-nr  2.511 0]

   [:h1 "format (formats a number or multiple numbers)"]
   [format-nr  2.511 "%.3f"]
   [format-nr  2.511 "%.2f"]
   [format-nr  2.511 "%.0f"]
   [format-nr 1 "%d"]
   [:p "date (format with 3 numbers): " (goog.string/format "%s %s %s" 2021 11 13)]

   [:h1 "dt-format"]
   [:p "date (instant) format: " (tick.goldly/dt-format "YYYYMMdd HH:mm:ss" (tick.core/now))]
   ])

(page/add format-page :demo-format)