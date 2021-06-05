(ns pinkgorilla.repl.clj.pomegranate
  (:require
   [cemerick.pomegranate :as pg]))

(defn add-dependencies
  "Use Pomegranate to add dependencies 
   with Maven Central and Clojars as default repositories.
   Same Syntax as clojupyter
   stolen from: https://github.com/clojupyter/clojupyter/blob/40c6d47ec9c9e4634c8e28fca3209b5c3ac8430c/src/clojupyter/misc/helper.clj

   "
  [dependencies & {:keys [repositories]
                   :or {repositories {"central" "https://repo1.maven.org/maven2/"
                                      "clojars" "https://clojars.org/repo"}}}]
  (let [first-item (first dependencies)]
    (if (vector? first-item)
      ; [ [dep1] [dep2]]
      (pg/add-dependencies :coordinates `~dependencies
                           :repositories repositories)
      ; [dep1]
      (pg/add-dependencies :coordinates `[~dependencies]
                           :repositories repositories))))