(ns demo.notebook.page-nav
  (:require
   [rf]
   [user :refer [nav current-route]]))

(nav :demo-format)

(nav :devtools)

(rf/dispatch [:bidi/goto :devtools])

(current-route)


