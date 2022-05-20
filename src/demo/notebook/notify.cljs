(ns demo.notebook.notify
  (:require
   [user :refer [notify]]))

(notify :info [:span.bg-blue-300.inline "the sky is blue!"] 1000)

(notify :warning "shipping fee charged is below cost!")

(notify :error
        [:span "its " [:span.bg-red-300 "raining"] "in Panama!"]
        0)