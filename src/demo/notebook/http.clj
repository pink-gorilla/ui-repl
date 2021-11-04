{:state {:data nil
         :quote ""
         :json nil}
 :html  [:div
         [:input.m-2 {:type "button"
                      :value "get edn"
                      :on-click #(get-edn "/r/repl/bongo.edn" state [:data])}]
         [:input.m-2 {:type "button"
                      :value "get text"
                      :on-click #(get-str "/r/repl/bongo.txt" state [:quote])}]
         [:input.m-2 {:type "button"
                      :value "get json"
                      :on-click #(get-json "/r/repl/bongo.json" state [:json])}]

         [:p "state: " (pr-str @state)]]
 :fns {}}


