(ns pinkgorilla.repl.goldly.core
  (:require
   [taoensso.timbre :as timbre :refer [info warn error]]
   [goldly.sci.bindings :refer [add-cljs-namespace add-cljs-bindings generate-bindings]]))


; cljs functions


(add-cljs-namespace [ajax.core]) ; http library
(add-cljs-namespace [pinkgorilla.repl.goldly.core])
(add-cljs-namespace [pinkie.default-setup]) ; pinkie

(add-cljs-bindings {; pinkie
                    'pinkie-render pinkie.pinkie-render/pinkie-render
                    'text pinkie.text/text
                    ; webly
                    'nav ui.goldly.fun/nav
                    'modal ui.goldly.fun/modal
                    ; goldly
                    'set-system-state ui.goldly.fun/set-system-state
                    ;
                    'clipboard-set ui.goldly.fun/clipboard-set
                    'clipboard-pop ui.goldly.fun/clipboard-pop
                    'parse-float ui.goldly.fun/parse-float
                    'timeout ui.goldly.fun/timeout
                    'alert ui.goldly.fun/alert
                    'evt-val ui.goldly.fun/evt-val})

(add-cljs-bindings {; logging
                    'println println
                    'info ui.goldly.fun/info
                    'warn ui.goldly.fun/warn
                    'error ui.goldly.fun/error
                    ; math
                    'sin ui.goldly.fun/sin ; test bindings
                    ; http
                    'GET ajax.core/GET
                    'POST ajax.core/POST
                ;
                    })