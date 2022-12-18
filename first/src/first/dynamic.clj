(ns first.dynamic
  (:require [quil.core :as q]))

(require '[euclidean.math.vector :as v])

(def DIM 500)
(def BOID_SIZE 20)
(def MAX_VEL 20)
(def MIN_VEL -20)

(defn make-boid []
  {:pos [(q/random 0 DIM) (q/random 0 DIM)]
   ;; :vel [(q/random MIN_VEL MAX_VEL) (q/random MIN_VEL MAX_VEL)]})
   :vel [(q/random MIN_VEL MAX_VEL) 0]})


(defn update-boid [boid]
  (let [wrap-pos
        (fn [p]
          (let [[x y] (:pos boid)
                [vx vy] (:vel boid)]
            [(mod DIM (+ vx x)) (mod DIM (+ vy y))]))]
    (update-in boid [:pos] wrap-pos)))

(defn draw-boid [boid]
  (q/stroke 0)
  (q/stroke-weight 3)
  (q/fill 0 120)
  (let [[x y] (:pos boid)]
    (q/ellipse x y BOID_SIZE BOID_SIZE)))

;; create the state
(defn setup []
  (q/smooth)
  (q/frame-rate 30)
  (q/background 200)
  ;; starting with one lonely boid
  (make-boid))

;; rn this does nothing
(defn update [state]
  (update-boid state))

(defn draw [state]
  (q/background 200)
  (draw-boid state)
  (comment (for [boid (:boids state)]
             (draw-boid boid))))

