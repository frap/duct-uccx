(ns uccxstats.boundary.rtstats
  (:require [hugsql.core :as hugsql]
            [duct.database.sql]))


;; The path is relative to the classpath (not proj dir!),
;; so "src" is not included in the path.
;; The same would apply if the sql was under "resources/..."
;; Also, notice the under_scored path compliant with
;; Clojure file paths for hyphenated namespaces
(hugsql/def-db-fns "uccxstats/rtstats.sql")


(defprotocol RtStats
  (fetch-icd  [db])
  (fetch-csq  [db]))


(extend-protocol RtStats
  duct.database.sql.Boundary
  (fetch-icd [{db :spec}]
    (first get-icdstats) )
  (fetch-csq [{db :spec}]
    (first get-csqstats)))
