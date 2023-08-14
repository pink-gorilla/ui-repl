(ns demo.page5.dialog
  (:require
   [goldly.page :as page]
   [goldly.nav :refer [nav]]
   [goldly.js :refer [alert]]
   [ui.webly :refer [dialog notify]]))

(defn my-dialog []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Hello modal!"])

; (defn nav [url]  url)

(defn dialog-page [{:keys [_route-params _query-params _handler] :as _route}]
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

   [:h2 "notification "]

   [:input.m-2 {:type "button"
                :value "info notification"
                :on-click #(notify :info [:span.bg-blue-300.inline "the sky is blue!"] 1000)}]

   [:input.m-2 {:type "button"
                :value "warning notification"
                :on-click #(notify :warning "shipping fee charged is below cost!")}]

   [:input.m-2 {:type "button"
                :value "error notification"
                :on-click #(notify :error
                                   [:span "its " [:span.bg-red-300 "raining"] "in Panama!"]
                                   0)}]

   [:h2 "nav "]
  ;nav
   [:input.m-2 {:type "button"
                :value "goto http demo"
                :on-click #(nav :demo-http-get)}]
   [:input.m-2 {:type "button"
                :value "goto load-js"
                :on-click #(nav :demo-loadjs)}]
   [:input.m-2 {:type "button"
                :value "goto format"
                :on-click #(nav :demo-format)}]
   
   [:input.m-2 {:type "button"
                :value "goto goldly devtools"
                :on-click #(nav :devtools)}]
   
   
   ])

(page/add dialog-page :demo-dialog)



