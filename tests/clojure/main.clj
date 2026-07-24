(defn -main [& args]
  (let [n (Integer/parseInt (nth args 0))
        m (Integer/parseInt (nth args 1))]
    (loop [i 1 counter 1]
      (if (< i n)
        (loop [j 1 counter2 counter]
          (if (< j m)
            (recur (inc j) (+ counter2 (* i j)))
            (recur (inc i) counter2)))
        (println counter)))))

(-main *command-line-args*)