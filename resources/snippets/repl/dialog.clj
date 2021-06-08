{:state 42
 :html  [:div

         [:input.m-2 {:type "button"
                  :value "Click me"
                  :on-click #(notify "booom")
         }]

         [:input.m-2 {:type "button"
                  :value "show dialog"
                  :on-click #(dialog [:h1.bg-blue-300.p-5 "dummy dialog"])}]
  
         [:input.m-2 {:type "button"
                  :value "goto main"
                  :on-click #(nav :goldly/about)}]

         ]
 :fns {}}


