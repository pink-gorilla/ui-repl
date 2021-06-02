{:state 42
 :html  [:div

         [:input {:type "button"
                  :value "Click me"
                  :on-click #(alert "booom")
         }]

         [:input {:type "button"
                  :value "log to browser console"
                  :on-click #(info "booom")}]
  
         ]
 :fns {:incr (fn [_ s] (inc s))}}


