(ns pinkgorilla.repl.cljs.jsloader
  (:require
   [reagent.core :as r]
   [applied-science.js-interop :as j]
   [goog.object :as g]
   [goog.net.jsloader :as jsl]
   [goog.html.legacyconversions :as conv]))

(defn filter-loaded [scripts]
  (reduce (fn [acc [loaded? src]]
            (if (loaded?) acc (conj acc src)))
          []
          scripts))

(defn js-loader
  "Load a supplied list of Javascript files and render a component
   during loading and another component as soon as every script is
   loaded.

   Arg map: {:scripts {loaded-test-fn src}
             :loading component
             :loaded component}"
  [scripts show-once-loaded show-loading show-error]
  (let [status (r/atom false)]
    (r/create-class
     {:component-did-mount (fn [_]
                             (let [not-loaded (filter-loaded scripts)
                                   not-loaded-safe (clj->js (map conv/trustedResourceUrlFromString
                                                                 (clj->js not-loaded)))
                                   p (jsl/safeLoadMany not-loaded-safe)]
                               (.log js/console (str "loading js: " not-loaded))
                               (.then p
                                      (fn [& args]
                                            ;(js/console.info "Loaded:" not-loaded)
                                        (reset! status true))
                                      (fn [& args]
                                        (reset! status :error)))))
      :reagent-render (fn [scripts show-once-loaded show-loading show-error]
                        (case @status
                          true show-once-loaded
                          :error show-error
                          show-loading))})))

(defn load-always []
  false)

(defn browser-defined? [s]
  (fn []
    (let [defined? (g/get js/window s)]
      (.log js/console "symbol " s  (if defined? " is defined" " is NOT DEFINED!"))
      defined?)))

(defn with-js
  [scripts show-once-loaded]
  [js-loader scripts show-once-loaded
   [:p "loading js .."]
   [:p "load-js error!"]])

(defn host-name []
  (let [hostname js/window.location.hostname]
    hostname))

(defn value-of
  "Safe access to a value at key a js object.
   Returns `'forbidden` if reading the property would result in a `SecurityError`.
   https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy"
  [obj k]
  (try
    (let [v (j/get obj k)]
      (.-constructor v) ;; test for SecurityError
      v)
    (catch js/Error ^js _
      'forbidden)))

(defn obj->clj [x]
  (-> (fn [result key]
        (let [v (aget x key)]
          (if (= "function" (goog/typeOf v))
            result
            (assoc result key v))))
      (reduce {} (goog.object/getKeys x))))