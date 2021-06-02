(ns pinkgorilla.repl.log)

(defn log! [l & args]
   ;(timbre/log! l :p args {:?line 77})
  (println l args))

(defn info [& args]
  (apply log! :info args))

(defn warn  [& args]
  (apply log! :warn args))

(defn error  [& args]
  (apply log! :error args))