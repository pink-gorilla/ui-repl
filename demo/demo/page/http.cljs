



(defn http-get-page [{:keys [route-params query-params handler] :as route}]
  (let [state (r/atom {:edn nil
                       :txt nil
                       :json nil})]
    (fn [{:keys [route-params query-params handler] :as route}]
      [:div
       [:input.m-2 {:type "button"
                    :value "get edn"
                    :on-click #(get-edn "/r/repl/bongo.edn" state [:edn])}]
       [:input.m-2 {:type "button"
                    :value "get text"
                    :on-click #(get-str "/r/repl/bongo.txt" state [:txt])}]
       [:input.m-2 {:type "button"
                    :value "get json"
                    :on-click #(get-json "/r/repl/bongo.json" state [:json])}]
       [:p "state: " (pr-str @state)]])))

(add-page http-get-page :demo-http-get)