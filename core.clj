(ns to-do-clojure.core
  (:gen-class))

(def to-dos (atom []))      ; atom allows this empty vector to be mutable

(defn add-to-do [input]
  (reset! to-dos (conj (deref to-dos) input)))

(defn -main [& args]        ;& sign allows the main function to take as many arguments as you want
  (println "Type a to-do an hit enter. To exit, type 'q'.")
  (loop []
    (let [input (read-line)]
      (when (not= input "q")
        (add-to-do input)
        (recur))))
  (println (deref to-dos)))
