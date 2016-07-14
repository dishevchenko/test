# test
A simple maven template with purpose to test UI of uptake.com website, using WebDriver.

_**testng.xml**_ - has a suite of all tests, where:

   - _TestHomePage_ - test for the Uptake.com home page, verifies that it has some basic content
   - _TestSolutionsPage_ - test for another page (Solutions) of same website, also verifies a basic content
    + executes a negative test (verifies alert is present if try to submit an empty form for email)
   - _TestPageNavigation_- test which verifies that navigation between Home and Solution pages works correctly

## used technics:
 - TestNG - test framework
 - log4j - logging service
 - Hamcrest - library that assists tests to have better assertion matchers. If test failed, it's easy to understand the output

## prerequisities:
 Browser Firefox should be installed on computer, where test will be run.
     Also the full path to installed directory should be set in system environment variable PATH