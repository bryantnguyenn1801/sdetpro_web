# Lumirental Automation Project

This project contains automated tests for the Lumirental web application using Selenium, JUnit, WebDriverManager, and ReportPortal.

## Setup

### Prerequisites

* JDK 11 or higher installed
* Maven 3.6.x or higher installed
* Chrome browser installed

### Dependencies

* Selenium Java 4.21.0
* JUnit 4.13.2
* WebDriverManager 5.5.3
* Gson 2.11.0
* Log4j 2.23.1
* JUnit Jupiter 5.8.1 (for JUnit 5 support)
* ReportPortal Agent 5.0.0

### Setting Up the Project

1. #### Clone the repository:
`git clone https://github.com/your/repository.git`

`cd lumirental-automation`

2. #### Install dependencies:
This project uses Maven for dependency management. Run the following command to install dependencies:
`mvn clean install`

### Running Tests
To run the automated tests, execute the following Maven command: `mvn test`
This will trigger the execution of all test classes ending with Test.java under the src/test/java directory.

### Project Structure
* **src/main/java:** Contains main Java source files (not shown in this example, typically for application code).

* **src/test/java:** Contains test automation code.
  * **tests:** Package for test classes
* **pom.xml:** Maven configuration file specifying project dependencies and build settings.

### Notes

Ensure ChromeDriver is available at `user_dir/downloadFile/chromedriver` as specified in **WebAppDriverManager**.
Adjust paths and configurations as per your local environment setup.

## Contributors
Bryant Nguyen