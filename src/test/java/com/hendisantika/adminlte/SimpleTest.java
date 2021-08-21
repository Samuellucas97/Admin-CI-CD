package com.hendisantika.adminlte;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

final class SimpleTest {
    private static String baseUrl;
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        baseUrl = "https://www.imd.ufrn.br/portal/";

        System.setProperty("webdriver.chrome.driver",
                "/home/samuel/Documents/spring-boot-adminlte/drivers/chrome/93/chromedriver"
        );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void acessingIMDPage() {
        driver.get(baseUrl);
        final String titlePage = driver.getTitle();
        final String expectedTitlePage = "IMD | Instituto Metrópole Digital";
        assertThat(titlePage).isEqualTo(expectedTitlePage);
    }
}
