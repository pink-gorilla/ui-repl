{:state 42
 :html  [:div
         [:button.bg-blue-300.m-2 {:on-click #(rf/dispatch [:bidi/goto :goldly/about])}
          "goto main"]

         "app db: "
         [:p.bg-blue-300
          (pr-str (app-db))]]
 :fns {}}


