; Exercise 2.34
(use 'clojure.test)

(defn accumulate [op initial sq]
 (if (empty? sq)
     initial
     (op (first sq)
         (accumulate op initial (rest sq)))))

(defn horner-eval [x coefficent-sequence]
 (accumulate (fn [this-coeff higher-terms] (+ this-coeff (* x higher-terms)) )
             0
             coefficent-sequence))

(deftest test-horner-eval
 (is (= 79 (horner-eval 2 (list 1 3 0 5 0 1)))))

(run-tests)
