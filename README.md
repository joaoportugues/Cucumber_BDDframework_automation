Cucumber BDD Framework Automation Project

# E-Commerce Test Automation Framework
A robust and scalable Behavior Driven Development (BDD) test automation framework built with Cucumber, Selenium WebDriver, and Java for testing the TutorialsNinja Demo e-commerce application.

# Project Overview:
This project demonstrates a comprehensive test automation framework for an e-commerce application using BDD methodology. The framework is designed to test critical user journeys on the TutorialsNinja Demo site, ensuring functionality, reliability, and user experience quality.
Application Under Test: TutorialsNinja Demo E-Commerce Site
Framework Type: Behavior Driven Development (BDD)
Design Pattern: Page Object Model (POM)

# Framework Architecture:
The framework follows industry-standard design patterns and best practices:

BDD Approach: Test scenarios written in Gherkin language for better collaboration between technical and non-technical stakeholders
Page Object Model: Separation of test logic from page elements for maintainability and reusability
Data-Driven Testing: Externalized test data through configuration files
Modular Structure: Clear separation of concerns with dedicated packages for pages, steps, runners, and utilities

# Technologies & Tools
Java:                          Programming Language
Selenium WebDriver:            Browser Automation
Cucumber:                      BDD Framework
TestNG:                        Test Execution & Management
Maven:                         Build & Dependency Management
Gherkin:                       Writing Test Scenarios
Eclipse IDE:                   Development Environment
Git & GitHub:                  Version Control

# Key features
- Cucumber (Gherkin) feature files for readable scenarios, living documentation of            application behaviour.
- Reusable Components- Page Object Model for maintainable code, centrlized element locators.
- Step definitions organized by feature/domain
- Test runners (TestNG) configured to run Cucumber suites
- Utilities for WebDriver management, configuration, and reporting

# Prerequisites
Before running this project, ensure you have the following installed:

- Java JDK (version 8 or higher)
- Maven (version 3.6 or higher)
- Eclipse IDE or any Java IDE
- Google Chrome Browser
- ChromeDriver (managed via WebDriverManager or manually)
- Git

# Quick setup
1. Clone the repo:
   git clone https://github.com/VenusAgrawal/Cucumber_BDDframework_automation.git
2. Change into the project folder:
   cd Cucumber_BDDframework_automation
3. Install dependencies and build (Maven example):
   mvn clean install

# Running tests
- Run the full test suite (Maven):
  mvn test

- Run tests with Cucumber tags (example):
  mvn test -Dcucumber.options="--tags @smoke"

Adjust the commands if you use Gradle or a different test runner.

# Project structure (typical)
- src/test/resources/features  - .feature files (Gherkin)
- src/test/java               - Step definitions, runners, hooks, factory
- src/main/java               - Pages, Utils
- pom.xml                     - Build configuration
- target/CucumbeReports/      - Generated test reports (HTML/XML/Json)

# Adding a new scenario
1. Create a new .feature file under src/test/resources/features
2. Add step definitions in the corresponding package under src/test/java/stepDefinitions
3. Create or update a runner class to include the new feature or tag
4. Run the suite and confirm the scenario passes

# Reporting
This project can be configured to generate Cucumber reports. Update the build configuration or runner to enable the report plugin you prefer. Reports can also be uploaded on cloud through reportin.io.

# Contact
Repository owner: @VenusAgrawal

