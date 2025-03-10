(ns demo.page.http
  (:require
   [reagent.core :as r]
   [promesa.core :as p]
   [ajax.core :refer [GET]]))

(defn ajax-get [state url]
  (let [rp (GET url)]
    (p/then rp (fn [data]
       (swap! state assoc :ajax data)          
              ))))

(defn page [{:keys [_route-params _query-params _handler] :as _route}]
  (let [state (r/atom {:edn nil
                       :txt nil
                       :json nil})]
    (fn [{:keys [_route-params _query-params _handler] :as _route}]
      [:div
       [:input.m-2 {:type "button"
                    :value "get text (via ajax GET)"
                    :on-click #(ajax-get state "/r/repl/bongo.txt")}]
       [:p "state: " (pr-str @state)]])))
