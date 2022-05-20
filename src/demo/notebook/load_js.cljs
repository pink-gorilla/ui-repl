(ns demo.notebook.load-js
  (:require
   [http]
   [pprint]
   [user :refer [load-js]]))

; demonstrates loading a js file.

(load-js "/r/repl/test2.js")

(http/application-url)

(http/ws-origin "/test")

(def movies [{:name "Matrix"}
             {:name "Terminator"}
             {:name "Dr. Strange"}])

(->> (pprint/print-table movies)
     (.log js/console))

; doc is a macro. this does not work...
;(doc http/api-url)