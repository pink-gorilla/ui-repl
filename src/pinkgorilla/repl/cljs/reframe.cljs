(ns pinkgorilla.repl.cljs.reframe
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :goldly/app-db
 (fn [db _]
   db))

(defn app-db []
  (let [db (rf/subscribe [:goldly/app-db])]
    @db))

