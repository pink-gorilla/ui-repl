(ns pinkgorilla.repl.goldly.snippets
  (:require
   [systems.snippet-registry :refer [add-snippet]]))

; examples are separate,
; because we want to be able to not load editor snippets 
; in normal goldly configurations.

(add-snippet {:type :goldly
              :category :repl
              :id :alert
              :filename "snippets/repl/alert.clj"})

(add-snippet {:type :goldly
              :category :repl
              :id :http
              :filename "snippets/repl/http.clj"})

(add-snippet {:type :goldly
              :category :repl
              :id :dialog
              :filename "snippets/repl/dialog.clj"})
