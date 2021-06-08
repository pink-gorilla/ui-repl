(ns pinkgorilla.repl.goldly.core
  (:require
   [taoensso.timbre :as timbre :refer [info warn error]]
   [pinkgorilla.repl :refer [add-require]]
   [goldly.sci.bindings :refer [add-cljs-namespace add-cljs-bindings generate-bindings]]))


; clj 

;(add-require '[clojure.tools.deps.alpha.repl :refer [add-libs libs find-lib]])


(add-require '[clojure.pprint :as pprint :refer [print-table]])



; cljs functions


(add-cljs-namespace [pinkgorilla.repl.goldly.core])
(add-cljs-namespace [pinkie.default-setup]) ; pinkie

(add-cljs-bindings
 {; webly
  'nav pinkgorilla.repl.cljs.webly/nav
  'notify pinkgorilla.repl.cljs.webly/notify
  'dialog pinkgorilla.repl.cljs.webly/dialog})

(add-cljs-bindings
 {; goldly
  'set-system-state pinkgorilla.repl.cljs.goldly/set-system-state
  'clipboard-set pinkgorilla.repl.clipboard/clipboard-set  ; missing .cljs because used in goldly
  'clipboard-pop pinkgorilla.repl.clipboard/clipboard-pop
  ;'bindings pinkgorilla.repl.cljs.goldly/bindings
  })

(add-cljs-bindings
 {; pinkie
  'pinkie-render pinkie.pinkie-render/pinkie-render
  'text pinkie.text/text})

(add-cljs-bindings
 {; logging
  'println println
  'info pinkgorilla.repl.cljs.log/info
  'warn pinkgorilla.repl.cljs.log/warn
  'error pinkgorilla.repl.cljs.log/error})

(add-cljs-bindings
 {; http
  'get-str pinkgorilla.repl.cljs.http/get-str
  'get-edn pinkgorilla.repl.cljs.http/get-edn
  'get-json pinkgorilla.repl.cljs.http/get-json})

(add-cljs-bindings
 {'parse-float pinkgorilla.repl.cljs.js/parse-float
  'timeout pinkgorilla.repl.cljs.js/timeout
  'alert pinkgorilla.repl.cljs.js/alert
  'evt-val pinkgorilla.repl.cljs.js/evt-val
  ; math
  'sin pinkgorilla.repl.cljs.js/sin ; test bindings
  })
