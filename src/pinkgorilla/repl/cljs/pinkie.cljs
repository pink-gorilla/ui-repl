(ns pinkgorilla.repl.cljs.pinkie
  (:require
   [pinkie.default-setup]
   [pinkie.pinkie]
   [pinkie.error]
   [pinkie.text]))

(defn register-tag
  "DEPRECIATED: please use register-component macro instead.
   registers a reagent component in the pinkie registry."
  [pinkie-tag func]
  (swap! pinkie.pinkie/component-registry assoc pinkie-tag {:meta {}
                                                            :tag pinkie-tag
                                                            :fun func})
  (keys @pinkie.pinkie/component-registry))

