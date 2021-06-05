(ns add-lib-demo
  (:require 
   [pinkgorilla.repl :refer [require-default]])
  (:gen-class)
  )

(defn -main []
  (require-default)
  (eval '(print-table [{:a 1 :b 2}
              {:a 999 :b 777}])))

