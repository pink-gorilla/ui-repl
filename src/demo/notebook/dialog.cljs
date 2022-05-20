(ns demo.notebook.dialog
  (:require
   [user :refer [dialog]]))

(str *ns*)

; dialogs can be closed with ESC

(dialog [:h1.bg-blue-300.p-5 "dummy dialog"])

(defn my-dialog []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Hello modal!"])

(dialog (my-dialog))