(ns demo.notebook.format
  (:require
   [t]
   [tick.goldly :refer [dt-format]]
   [goldly.js :refer [to-fixed]]
   [goog.string :refer [format]]))

(dt-format "YYYYMMdd HH:mm:ss" (t/now))

(format "hello %s !" "mr X.")

(to-fixed 2.511 3)
(to-fixed  2.511 2)
(to-fixed  2.511 0)

(format "%.3f" 2.511)
(format "%.2f" 2.511)
(format "%.0f"  2.511)
(format "%d" 134.44)
(format "%s %s %s" 2021 11 13)

