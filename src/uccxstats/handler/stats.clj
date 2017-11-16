(ns uccxstats.handler.stats
  (:require
            [ataraxy.response :as response]
            [uccxstats.boundary.rtstats :as rtstats]
            [integrant.core :as ig]))

(defmethod ig/init-key ::icd [_ {:keys [db]}]
  (fn [_] [::response/ok (rtstats/fetch-icd db)]))

(defmethod ig/init-key ::csq [_ {:keys [db]}]
  (fn [_] [::response/ok (rtstats/fetch-csq db)]))
