(ns component
  (:require
   [taoensso.timbre :as timbre :refer-macros [trace debug debugf info warn error]]
   [clojure.string]
   [reagent.core :as r]
   [cljs-uuid-utils.core :as uuid]))

(defn component [{:keys [start stop update style config]
                  :or {style {:width "100%" :height "100%"}}}]
  (let [id (uuid/uuid-string (uuid/make-random-uuid))
        c (r/atom nil)]
    (r/create-class
     {:display-name  "component"
      :reagent-render
      (fn [_]
        [:div {:id id
               :style style}])
      :component-did-mount (fn [this]
                             (info "component started. id: " id " props: " (r/argv this))
                             (reset! c (start id config)))

      :component-will-unmount (fn [this]
                                (info "component stopped.")
                                (when stop
                                  (stop @c id)))

      ;:component-will-receive-props (fn [this new-argv]
      ;                                (println "receive props: " new-argv))

      :component-did-update (fn [this [_ prev-props prev-more]]
                              (let [[_ new-config] (r/argv this)]
                                (info "component updated " new-config)
                                (when update
                                  (update @c id new-config))))})))
