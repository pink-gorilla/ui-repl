(ns demo.notebook.load-js
  (:require
   [pinkgorilla.repl.cljs.jsloader :refer [load-js]]))

; demonstrates loading a js file.

(load-js "/r/repl/test2.js")

