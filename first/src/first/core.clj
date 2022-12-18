(ns first.core
  (:require [quil.core :as q]
            [quil.middleware :as m])
  (:require [first.dynamic :as dynamic]))

(q/defsketch example
  :title "boid gang"
  :setup dynamic/setup
  :draw dynamic/draw
  :update dynamic/update
  :middleware [m/fun-mode]
  :size [dynamic/DIM dynamic/DIM])

(comment 
  ;; restart
  (use 'first.core :reload))
