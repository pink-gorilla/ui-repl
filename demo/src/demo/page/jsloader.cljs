(ns demo.page.jsloader
  (:require
   [js-loader :refer [with-js browser-defined? load-always]]
   [component :refer [component]]
   ))

(defn page [{:keys [_route-params _query-params _handler] :as _route}]
  [:div
   [:div.bg-yellow-500
    "load a simple file"]
   [with-js {load-always "/r/repl/test1.js"}
    [:p.text-blue-500 "The test.js file was loaded (you can see it in the browser console)"]]

   [:div.bg-yellow-500
    "load a file that defines a symbol (prohibit reloading of already loaded javascript module)"
    "test2 should load exacly ONCE!"]
   [with-js {(browser-defined? "add5") "/r/repl/test2.js"}
    [:p.text-blue-500 "The test.js file was loaded (you can see it in the browser console)"]]

   [:div.bg-red-500
    [:p "the next one should fail:"]
    [with-js {load-always "/r/repl/test-bad.js"}
     [:p.text-red-500 "The test-bad.js file was loaded (you can see it in the browser console)"]]]

   [with-js {(browser-defined? "add5") "/r/repl/test1.js"
             load-always "/r/repl/test2.js"}
    [:p.text-blue-500 "The test1.js and test2.js were loaded (you can see it in the browser console)"]]

   [with-js {(browser-defined? "add5") "/r/repl/test2.js"}
    [component {:start #(js/bongoshow %1 %2)
                :config "complex bongo ui (added to dom node dynamically :-)"}]]

;
   ])

