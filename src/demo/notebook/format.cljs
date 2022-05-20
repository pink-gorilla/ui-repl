(ns demo.notebook.format
  (:require
   [t]
   [user :refer [format dt-format]]
   [pprint :refer [print-table]]))

(format "hello %s !" "mr X.")

(to-fixed 2.511 3)
(to-fixed  2.511 2)
(to-fixed  2.511 0)

(format "%.3f" 2.511)
(format "%.2f" 2.511)
(format "%.0f"  2.511)
(format "%d" 134.44)
(format "%s %s %s" 2021 11 13)

(dt-format "YYYYMMdd HH:mm:ss" (t/now))

(print-table {:name "Harry" :age "?"
              :name "Dumbeldor" :age "old"})