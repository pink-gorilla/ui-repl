(ns demo.notebook.tick
  (:require
   [tick.core :as t]
   [tick.goldly :refer [dt-format]]))

(dt-format "YYYYMMdd HH:mm:ss" (t/now))