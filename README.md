# 🤖 Android UI Automation Test

![License](https://img.shields.io/badge/license-MIT-blue)
![Java](https://img.shields.io/badge/java-11%2B-blue)
![Maven](https://img.shields.io/badge/build-maven-blue)
![Appium](https://img.shields.io/badge/test-Appium%2BTestNG-brightgreen)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![PRs](https://img.shields.io/badge/PRs-welcome-brightgreen)
![CI](https://github.com/yudadananjaya/bitsof-android-ui-automation-test/actions/workflows/android-ui-test.yml/badge.svg)

Automated UI testing framework for Android applications using **Java**, **Appium**, **TestNG**, and **Maven**.

---

## 📁 Project Structure

```
bitsof-android-ui-automation-test/
├── apk/                        # APK files (gitignored)
│   └── staging-v2.0.0-202504221.apk
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/bitsof/
│   │           ├── base/
│   │           ├── config/
│   │           ├── function/
│   │           ├── model/
│   │           ├── modules/
│   │           ├── service/
│   │           └── utils/
│   └── test/
│       ├── java/
│       │   └── com/bitsof/tests/
│       │       ├── login/
│       │       └── requisition/
│       ├── resources/
│       │   ├── login-test-data.properties
│       │   └── testng.xml
│       └── suites/
│           └── login-suite.xml
├── run_android_ui_tests.sh     # Script: start emulator, Appium, run tests
├── stop_android_ui_tests.sh    # Script: stop Appium, emulator, clean env
├── get_app_info.sh             # Script: extract/display APK info
├── .gitignore
├── pom.xml
├── README.md
└── appium.log                  # Appium server log (gitignored)
```

---

## 🛠️ Technology Stack

- **Java 11+**
- **Appium Java Client**
- **TestNG**
- **Maven**
- **Android Emulator/Device**
- **PostgreSQL (for test data, optional)**

---

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```sh
   git clone https://github.com/yourusername/bitsof-android-ui-automation-test.git
   cd bitsof-android-ui-automation-test
   ```

2. **Install Java, Maven, Android SDK, and Appium**
   - Make sure you have Java 11+, Maven, Android SDK, and Appium installed.
   - Check with:
     ```sh
     java -version
     mvn -version
     adb version
     appium -v
     ```

3. **Configure test data**
   - Edit `src/test/resources/login-test-data.properties` as needed for your environment.
   - If you use database-driven tests, configure your DB connection in `.env.production` or `.env.development` and see `src/main/java/com/bitsof/config/DBConfig.java`.

4. **Set your APK path and emulator/device name**
   - Update `BaseTest.java` or `Config.java` with your APK path and emulator/device details.

---

## 🚦 How to Run Tests

### 1. Run All Tests (with emulator and Appium auto-start)
```sh
chmod +x run_android_ui_tests.sh
./run_android_ui_tests.sh
```

### 2. Stop Appium, emulator, and clean environment
```sh
chmod +x stop_android_ui_tests.sh
./stop_android_ui_tests.sh
```

### 3. Run Maven tests only (Appium and emulator must be running)
```sh
mvn clean test
```

### 4. Run a Specific TestNG Suite
```sh
mvn test -Dsurefire.suiteXmlFiles=src/test/suites/login-suite.xml
```

---

## 📄 Reporting

- Test reports are generated in `target/surefire-reports/` after each run.
- Open `target/surefire-reports/index.html` in your browser to view the results.

---

## 🛠️ Utility Scripts

- **run_android_ui_tests.sh**: Starts the emulator, Appium server, and runs all tests in one command.
- **stop_android_ui_tests.sh**: Stops Appium, closes the emulator, and cleans the Maven environment.
- **get_app_info.sh**: Use this to extract or display APK/app information as needed for your workflow.

**Before using any script, make it executable:**
```sh
chmod +x run_android_ui_tests.sh stop_android_ui_tests.sh get_app_info.sh
```

---

## 📝 Notes

- The `apk/` directory and all `.apk` files are gitignored by default.
- Make sure your emulator/device and Appium server are running before executing tests (unless using the provided scripts).
- Update device and APK details in `BaseTest.java` or `Config.java` as needed for your environment.
- For DB-driven tests, configure `.env.production` or `.env.development` and see `DBConfig.java`.
- For troubleshooting, check the Appium logs (`appium.log`) and Maven output.
