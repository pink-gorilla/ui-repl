{:state 42
 :html  [:div

         [:input {:type "button"
                  :value "Click me"
                  :on-click #(alert "booom")
                  }
         ]
  
         ]
 :fns {:incr (fn [_ s] (inc s))}}


