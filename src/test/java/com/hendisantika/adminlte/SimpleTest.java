package com.hendisantika.adminlte;


import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumExtension.class)
final class SimpleTest {
    private static String baseUrl;

    @BeforeAll
    static void setUp() {
        baseUrl = "https://www.imd.ufrn.br/portal/";
    }

    @Test
    void acessingIMDPage(@Arguments("--headless") ChromeDriver driver) {
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
        final String titlePage = driver.getTitle();
        final String expectedTitlePage = "IMD | Instituto Metrópole Digital";
        assertThat(titlePage).isEqualTo(expectedTitlePage);
    }
}

