# Test Automation Project

This project is built with **Java 11**, **Cucumber**, and **Rest Assured** to automate API testing.

---

## Prerequisites

- **Java 11** (Make sure to have it installed and set in your PATH)
- **Maven** (optional if your IDE handles Maven, but recommended)

---

## Running Tests

### Run Single Scenarios or Entire Feature Files
- **From your IDE** (e.g., IntelliJ, Eclipse):  
  - You can **right-click** on a single scenario or an entire `.feature` file and select **Run**.
- **From the command line** using Maven or just executing the class:  
  ```bash
  mvn test -Dcucumber.options="src/test/resources/features/YourFeature.feature"
