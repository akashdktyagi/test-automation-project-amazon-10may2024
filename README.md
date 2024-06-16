## Test Automation Framework using Cucumber, Selenium, Java
#### Features: Selenium Grid, Docker, Gitlab, CI CD Pipeline

### Note: 

---

This project is divided in to two modules. Module 1 named as: ```code-which-just-works``` will always have working code.
This is the place I always make sure the correct working code is available. 
Module 2 named as: ```during-session``` will have the code which is not working or need refactoring. which I create during the sessions.
So always refer to the ```code-which-just-works``` module for the correct working code.

---

### Topics Covered: I intend to cover below topics during these sessions
*  Basic Skeleton of the Framework ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
  * Dependencies ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Lombok, AssertJ ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Selenium, Cucumber, TestNG ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Cucumber ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Feature file ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Cucumber Hooks concept ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Runner File ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Dependency Injection with Picocontainer ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Step Definitions ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
    *  Page Object Model ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
      *  Xpaths ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
      *  Xpaths axis advanced concept ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
         * XPath Reference:
            * https://www.w3schools.com/xml/xpath_syntax.asp
            * Examples:
              * ```//div[contains(text(),'Google offered in:')]```
              * ```//input[last() and contains(@value,'Feeling')]```
              * ```//textarea[@name='q']/sibling::div```
              * ```//span[@class='a-size-base a-color-base' and text()='%s']/preceding-sibling::div/label/i"```
      * Properties File Configuration ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
      * WebDriver manager Browser factory multi browser support ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`

----

* Selenium Concepts:
  * WebElements List of Web Elements, iterate over them ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`

* Cucumber Concepts:
  * Cucumber Tags ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) Pending
  * Runner File Cucumber Options  ![#05ef1e](https://via.placeholder.com/15/05ef1e/000000?text=+) `Completed`
  * Cucumber Hooks Before after and how to use them to capture screen shots for failures  ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`
* Extent Report  ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`
  
* Logging with Log 4j ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`
* Selenium Grid with Docker ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`
  * If you are on windows and facing the error: 
    * ```
        Error response from daemon: Ports are not available: exposing port TCP 0.0.0.0:4442 -> 0.0.0.0:0: listen tcp 0.0.0.0:4442: bind: An attempt was made to access a socket in a way forbidden by its access permissions.
      ```
    * then do this: https://superuser.com/questions/1604199/find-who-excluded-port-range
      * Summarizing the steps: Run below. Make sure you open the powershell with admin rights else you will get access denied error.
        *   ```shell
            net stop winnat
            net start winnat
            ```
    * For Docker Compose run : ```docker-compose up --scale chrome=5``` .
    * This will open 5 chrome instances. Navigate to: http://localhost:4444
* Git-hub CI Pipeline and how to integrate the test pack with it ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`
   * Use these links to know more:
       * https://www.testmo.com/guides/github-actions-selenium
       * https://docs.github.com/en/actions/using-containerized-services/about-service-containers 
* How to create a reusable maven library and use it in the project ![#1600f9](https://via.placeholder.com/15/1600f9/000000?text=+) `Yet to Demonstrate`


