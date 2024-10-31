(ns demo.page.main
  (:require
   [frontend.routes :refer [goto!]]))

(defn my-dialog []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Hello modal!"])

(defn page [{:keys [_route-params _query-params _handler] :as _route}]
  [:div
 
   [:h2 "nav "]
  ;nav
   [:input.m-2 {:type "button"
                :value "goto http demo"
                :on-click #(goto! 'demo.page.http/page)}]
   [:input.m-2 {:type "button"
                :value "goto load-js"
                :on-click #(goto! 'demo.page.jsloader/page)}]
   [:input.m-2 {:type "button"
                :value "goto format"
                :on-click #(goto! 'demo.page.format/page)}]
   
   [:input.m-2 {:type "button"
                :value "goto tick demo"
                :on-click #(goto! 'demo.page.tick/page)}]
   
   
   ])





