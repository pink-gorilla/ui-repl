(ns demo.notebook.applied-science-jsinterop
  (:require
   [applied-science.js-interop]))

(def o #js {"a" 44})

;; Read
(applied-science.js-interop/get user/o :x)
(applied-science.js-interop/get user/o "a")

(applied-science.js-interop/get-in user/o [:a])
(applied-science.js-interop/select-keys user/o [:a :b :c])

; this does not work:
(applied-science.js-interop/get user/o .-x "fallback-value")