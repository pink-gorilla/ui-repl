(defn my-dialog []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Hello modal!"])

(defn dialog-page [{:keys [route-params query-params handler] :as route}]
  [:div

  ; alert   
   [:h2 "alert "]
   [:input.m-2 {:type "button"
                :value "Raise Alert"
                :on-click #(alert "booom")}]

   ;dialog
   [:h2 "dialog "]
   [:button.bg-blue-300
    {:title "Click to show dialog!"
     :on-click #(dialog (my-dialog))}
    "default-size dialog!"]

   [:input.m-2 {:type "button"
                :value "show dialog"
                :on-click #(dialog [:h1.bg-blue-300.p-5 "dummy dialog"])}]

  ;nav
   [:input.m-2 {:type "button"
                :value "goto devtools"
                :on-click #(nav :devtools)}]])

(add-page dialog-page :demo-dialog)



