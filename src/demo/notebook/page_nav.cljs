(ns demo.notebook.page-nav
  (:require
   [re-frame.core :as rf]
   [goldly.nav :refer [nav current-route]]))

(nav :demo-format)

(nav :devtools)

(rf/dispatch [:bidi/goto :devtools])

(current-route)


