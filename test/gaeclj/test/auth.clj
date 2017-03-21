(ns gaeclj.test.auth
    (:require [clojure.test :refer :all]
              [gaeclj.test.fixtures :as fixtures]
              [gaeclj.auth :refer :all]))

(use-fixtures :once fixtures/setup-local-service-test-helper)

(deftest user-test
  (is (= "/_ah/login?continue=%2Ffff" (create-login-url "/fff")))
  (is (= "/_ah/logout?continue=%2Ffff" (create-logout-url "/fff"))))

