; Exercise 1.12
; A work in progress.  Right now it only calculates rows in Pascal's
; Trianangle.  Need to clean up and make it get back the actual 
; triangle
(defn moving-sum2 [coll]
 (let [helper (fn [i res]
               (if (< i (dec (count coll)))
                    (recur (inc i) 
                           (cons (+ (nth coll i)
                                    (nth coll (inc i))) 
                                 res))
                    (cons 1 res)))]
  (helper 0 [1])))

(defn pascals-triangle-row [n]
 (let [helper (fn [previous-row i]
               (println previous-row)
               (if (< i n)
                    (recur (moving-sum2 previous-row) (inc i))
                    (moving-sum2 previous-row)))]
  (if (= n 0) 
        (println '(1))
      (helper '(1) 1))))

(do println (pascals-triangle-row 50))

