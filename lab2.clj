(ns lab2)

;;; Collections ;;;
(defn add-values-for-keys [hm keys]
  "takes a hash map and a set of keys, reutrns the sum of all values bound to those keys"
  (reduce + (filter identity (map hm keys))))

(= (add-values-for-keys {:a 2 :b true :c "apple" :d 5} #{:a :d}) 7)

;;; Recursion ;;;
    ;;; Task 1 ;;;
(defn min1 [coll]
  "takes a non-empty collection of numbers, returns the minimum element in the collection"
  (loop [c coll m (first coll)] ; m cannot be initialized as nil
    (if (empty? (rest c))
      (min m (first c))
      (recur (rest c) (min m (first c))))))

    ;;; Task 2 ;;;
(defn take1 [num coll]
  "takes a number and a collection, returns the first n elements in the same order"
  (loop [c coll n num t []]
    (if (or (< n 1) (empty? c))
      t
      (recur (rest c) (- n 1) (conj t (first c))))))

(= (take1 5 (range 100)) [0 1 2 3 4])
(= (take1 5 (range)) [0 1 2 3 4])
(= (take1 0 [1 2 3]) [])
(= (take1 -1 [1 2 3]) [])
(= (take1 6 [1 2 3]) [1 2 3])

;;; Macros ;;;
    ;;; Task 1 ;;;
(defmacro safe-nth [coll num]
  "takes a collection and a number, returns the n-th element of the list if it exists, nil if not"
  `(if (and (> ~num 0) (<= ~num (count ~coll))) (nth ~coll ~num)))

(= (safe-nth [1 2 3 4 5] 7) nil)
(= (safe-nth [1 2 3 4 5] 2) 3)
(= (safe-nth [1 2 3 4 5] -1) nil)

    ;;; Task 2 ;;;
