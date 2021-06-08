{:state 42
 :html  [:div
         [:input.m-2 {:type "button"
                  :value "Click me"
                  :on-click #(alert "booom")}]
         [:input.m-2 {:type "button"
                  :value "log to browser console"
                  :on-click #(info "booom")}]]
 :fns {}}


