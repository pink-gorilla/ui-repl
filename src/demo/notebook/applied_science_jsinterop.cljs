(ns demo.notebook.applied-science-jsinterop
  (:require
   [applied-science.js-interop]))

(def o #js {"a" 44})

;; Read
(applied-science.js-interop/get o :x)
(applied-science.js-interop/get o "a")

(applied-science.js-interop/get-in o [:a])
(applied-science.js-interop/select-keys o [:a :b :c])

; this does not work:
(applied-science.js-interop/get o .-x "fallback-value")