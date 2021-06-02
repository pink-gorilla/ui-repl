(ns pinkgorilla.repl.goldly.snippets
  (:require
   [systems.snippet-registry :refer [add-snippet]]))

; examples are separate,
; because we want to be able to not load editor snippets 
; in normal goldly configurations.

(add-snippet {:type :goldly
              :category :repl
              :id :template
              :filename "snippets/repl/template.clj"})
