(ns gaeclj.test.fixtures
(:import [com.google.appengine.tools.development.testing 
          LocalServiceTestConfig 
          LocalServiceTestHelper
          LocalFileServiceTestConfig 
          LocalDatastoreServiceTestConfig
          LocalTaskQueueTestConfig
          LocalAppIdentityServiceTestConfig
          LocalBlobstoreServiceTestConfig])
(:require [clojure.java.io :as io])
(:use clojure.test))

(defn- app-identity-config []
  (doto
      (LocalAppIdentityServiceTestConfig.)
    (.setDefaultGcsBucketName "default-bucket")))

(defn- create-local-test-helper []
  (LocalServiceTestHelper. (into-array LocalServiceTestConfig [(app-identity-config)])))

(defn setup-local-service-test-helper [f] 
  (let [helper (create-local-test-helper)]
    (try 
      (.setUp helper)
      (f)
      (finally 
        (.tearDown helper)))))

