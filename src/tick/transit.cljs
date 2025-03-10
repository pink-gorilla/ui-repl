(ns tick.transit
  (:require
   [transit.type.tick :refer [add-tick-handlers!]]))

(defn add-tick-transit-encoding []
  (println "adding tick transit encoding..")
  (add-tick-handlers!))


; this is the side effect that we wnat to happen.
(add-tick-transit-encoding)