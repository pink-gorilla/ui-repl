(ns pinkgorilla.repl.goldly.core
  (:require
   [taoensso.timbre :as timbre :refer [info warn error]]
   [goldly.sci.bindings :refer [add-cljs-namespace add-cljs-bindings generate-bindings]]))


; cljs functions
(add-cljs-namespace [ajax.core]) ; http library
(add-cljs-namespace [pinkgorilla.repl.goldly.core])
(add-cljs-namespace [pinkie.default-setup]) ; pinkie

(add-cljs-bindings
 {; pinkie
  'pinkie-render pinkie.pinkie-render/pinkie-render
  'text pinkie.text/text
  ; webly
  'nav pinkgorilla.repl.fun/nav
  'modal pinkgorilla.repl.fun/modal
  ; goldly
  'set-system-state pinkgorilla.repl.fun/set-system-state
  ;
  'clipboard-set pinkgorilla.repl.clipboard/clipboard-set
  'clipboard-pop pinkgorilla.repl.clipboard/clipboard-pop
  'parse-float pinkgorilla.repl.fun/parse-float
  'timeout pinkgorilla.repl.fun/timeout
  'alert pinkgorilla.repl.fun/alert
  'evt-val pinkgorilla.repl.fun/evt-val})

(add-cljs-bindings
 {; logging
  'println println
  'info pinkgorilla.repl.log/info
  'warn pinkgorilla.repl.log/warn
  'error pinkgorilla.repl.log/error})

(add-cljs-bindings
 {; http
  'GET ajax.core/GET
  'POST ajax.core/POST})

(add-cljs-bindings
 {; math
  'sin pinkgorilla.repl.fun/sin ; test bindings
  })
