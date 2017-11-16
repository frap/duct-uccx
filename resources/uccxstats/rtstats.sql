-- :name get-icdstats :? :*
-- :doc select all the UCCX resources
SELECT *
FROM RtICDStatistics

-- :name get-loggedinagents :? :*
-- :doc select all loggedinagents
SELECT loggedinagents AS agents
FROM RtICDStatistics

-- :name get-csqs-active :? :*
select CSQNAME from contactservicequeue where active = 'T' and queuetype = 0

-- :name get-csqstats :? :*
-- :doc select all data from real time queues
select *,(callshandled + callsdequeued) as callsHanDeq,(callsabandoned - callsdequeued) as callsAbDeq
FROM RtCSQsSummary

