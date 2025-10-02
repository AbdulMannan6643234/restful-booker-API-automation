# Restful-Booker-API-Automation
Automation framework using Rest-Assured, Java and TestNG for the **Restful-Booker** mock API. Covers **CRUD** operations with data-driven tests and response validation.
## Tech Stack
- **Language:** Java
- **Framework:** TestNG
- **API Automation:** Rest Assured
- **Build & Dependency Management:** Maven
- **Reporting:** TestNG Reports
## Features
- **Organised test groups:** Smoke, Regression, KnownBugs
- **Data-driven tests:** with dynamic payloads
- **Reusable utilities:** for API calls and validation
- Clear **response validation** for all CRUD endpoints
- **Execution screenshots:** Consolidated results for each test group
## Getting Started
### 1. Clone the repo:
```bash
git clone https://github.com/AbdulMannan6643234/restful-booker-API-automation.git
```
### 2. Navigate to the project:
```bash
cd restful-booker-API-automation
```
### 3. Install dependencies:
```bash
mvn clean install
```
### 4. Run tests:
```bash
mvn test -DsuiteXmlFile=testng.xml
```
 **5. View reports**: target/surefire-reports/index.html

 ## Test Results
**Smoke Tests:** 19/19 Passed
 ![Smoke Tests](/screenshots/SmokeTests.png)
 
**Regression Tests:** 5/5 Passed
 ![Regression Tests](/screenshots/RegressionTests.png)
 
**KnownBug Tests:** 8/8 Passed
 ![KnownBug Tests](/screenshots/knownBugTests.png)

 ## Project Structure
 ```text
restful-booker-API-automation/
└── src/test/java/
     ├── utils/         # Reusable methods, DataProviders
     ├── tests/         # grouped tests (Smoke, Regression, KnownBug)
     ├── models/        # POJOs for serialization/deserialization
     └── services/      # reusable classes to interact with API endpoints       
├── pom.xml             # Maven dependencies
├── testng.xml          # Defines test groups, suite execution, and configuration
├── screenshots         # Screenshots of successful test results
```

## Future Improvements
- CI/CD integration with GitHub Actions
- Advanced reporting with Allure or ExtentReports
- Parallel execution support
  
## Important Note
Some API inputs in Restful-Booker are not fully validated. Test cases targeting these are grouped under Known Bugs. These tests are intentional and do not indicate failures in the framework.
