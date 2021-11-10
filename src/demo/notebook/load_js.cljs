


; demonstrates loading a js file.

(load-js "/r/repl/test2.js")

(http/application-url)

(http/api-url "/api/test")

(http/ws-origin "/test" (http/application-url))

(def movies [{:name "Matrix"}
             {:name "Terminator"}
             {:name "Dr. Strange"}])

(->> (pprint/print-table movies)
     (.log js/console))

(doc http/api-url)