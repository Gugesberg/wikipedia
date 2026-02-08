import org.slf4j.helpers.Util.report

plugins {
    id ("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "org.wikipedia"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

allure {
    report {
        version.set("2.17.3") //версия Allure Report (https://github.com/allure-framework/allure2)
    }
    adapter {
        aspectjWeaver.set(true) // обработка аннотации @Step
        frameworks {
            junit5 {
                adapterVersion.set("2.17.3") //версия Allure JUnit5 (https://github.com/allure-framework/allure-java)
            }
        }
    }
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.14.0")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("io.qameta.allure:allure-selenide:2.17.3")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("ch.qos.logback:logback-classic:1.5.18")
    testImplementation("org.slf4j:jul-to-slf4j:2.0.16")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")



}


tasks.test {
    useJUnitPlatform()

    //  WebDriverManager — АВТОМАТИЧЕСКИ скачает ChromeDriver
    systemProperty("webdriver.chrome.driver", "")
    systemProperty("webdriver.manager.enabled", "true")

    //  Headless Chrome для Jenkins
    systemProperty("selenide.headless", "true")
    systemProperty("selenide.browser", "chrome")
    systemProperty("selenide.timeout", "15000")

    //  Критические аргументы Linux CI
    systemProperty("selenide.chromeOptionsArgs",
        "--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--disable-extensions,--window-size=1920,1080")

    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED,
            TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
    }
}

