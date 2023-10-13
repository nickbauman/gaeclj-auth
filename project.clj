(def appengine-version "1.9.48")

(defproject gaeclj-auth "0.1.0"
  :description "gaeclj-auth provides clojure helpers for auth API in Google App Engine"
  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/data.json "0.2.6"]
                 [ch.qos.logback/logback-classic "1.1.8"]
                 [com.google.guava/guava "20.0"]
                 [com.google.appengine/appengine-api-1.0-sdk ~appengine-version]
                 [org.apache.httpcomponents/httpclient "4.5.2"]       
                 [com.google.api-client/google-api-client-appengine "1.22.0"
                  :exclusions [com.google.guava/guava-jdk5]]
                 [com.google.oauth-client/google-oauth-client-appengine "1.22.0"
                  :exclusions [com.google.guava/guava-jdk5]]       
                 [com.google.http-client/google-http-client-appengine "1.22.0"
                  :exclusions [com.google.guava/guava-jdk5]]]
  :java-source-paths ["src-java"]
  :aot :all
  :profiles
  {:dev
   {:dependencies [[com.google.appengine/appengine-testing ~appengine-version]
                   [com.google.appengine/appengine-api-labs ~appengine-version]
                   [com.google.appengine/appengine-api-stubs ~appengine-version]
                   [com.google.appengine/appengine-tools-sdk ~appengine-version]]}})
