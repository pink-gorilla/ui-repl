(ns tick.editor
  (:require
   [tick.core :as t]
   [tick.protocols :refer [parse]]
   [tick.helper :refer [dt-format]]
   [tick.locale-en-us] ; a locale is needed for date formatting
   [cljc.java-time.instant :as i]
   [cljc.java-time.local-date-time :as ldt]))

; "YYYY-MM-DDTHH:MM"
;"2018-06-12T19:30"

(defn parse-str [v]
  (let [l (ldt/parse v)
        zdt (-> l
                (t/in "UTC"))]
    (t/instant zdt)))

(defn instant-editor [{:keys [instant-a] :as opts}]
  [:input
   (merge (dissoc opts :instant-a)
          {:type "datetime-local"
           :value (dt-format :iso-local-date-time @instant-a)
           :timeformat "24h"
           :on-change (fn [e]
                        (let [v (-> e .-target .-value)
                              i (parse-str v)]
                          (println "new value: " v " parsed: " i)
                          (reset! instant-a i)))})])