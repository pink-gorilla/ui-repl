(ns pinkgorilla.repl.clj.sci
  (:require
   [goldly.sci.bindings :refer [goldly-ns-bindings]]))

(defn bindings []
  @goldly-ns-bindings)

