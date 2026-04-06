# Cucumber-JUnit-Runner

BDD test automation framework with Cucumber, JUnit & Selenium WebDriver.

**Tech Stack:** Java 17 | Maven | Cucumber 7 | Selenium 4 | Extent Reports

**Features:**
- Page Object Model (POM) design pattern
- Explicit waits for reliable test execution
- Parallel test execution
- Extent Reports integration with screenshots on failure
- Multi-browser support (Chrome/Firefox/Edge)
- Automatic WebDriver management
- Environment variable configuration

## Prerequisites

- **Java 17+** installed
- **Maven 3.6+** installed
- **Chrome/Firefox/Edge** browser installed

## Setup

1. Clone the repository
2. Navigate to project directory
3. Install dependencies:
   ```bash
   mvn clean install
   ```

## Running Tests

**Run all tests:**
```bash
mvn clean test
```

**Run with specific browser:**
```bash
mvn clean test -Dbrowser=Chrome
mvn clean test -Dbrowser=Firefox
mvn clean test -Dbrowser=Edge
```

**Run with specific tag:**
```bash
mvn clean test -Dcucumber.filter.tags="@CheckOut"
mvn clean test -Dcucumber.filter.tags="@SearchProduct1"
```

**Run with environment variables:**
```bash
export BASE_URL=https://example.com
export BROWSER=Chrome
mvn clean test
```

(Windows CMD: use `set` instead of `export`)

## Project Structure

```
src/
├── test/
│   ├── java/
│   │   ├── pages/           # Page Object Model
│   │   ├── runner/          # JUnit Runner
│   │   ├── stepDefinition/  # Cucumber Steps
│   │   └── utils/           # Utilities
│   └── resources/
│       ├── features/        # Feature files
│       ├── extent.properties # Report config
│       └── global.properties # Test config
```

## Reports

- **HTML Report:** `target/cucumber-reports/cucumber-rep.html`
- **JSON Report:** `target/cucumber-reports/cucumber-rep.json`
- **Extent Report:** `test-output/SparkReport/`

## License

[MIT](https://choosealicense.com/licenses/mit/)
