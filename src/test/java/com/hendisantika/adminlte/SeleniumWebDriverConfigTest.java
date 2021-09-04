package com.hendisantika.adminlte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SeleniumWebDriverConfigTest {
    @Value("${headless}")
    private Boolean headless;

    @Bean
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        options.setHeadless(headless);
        return new ChromeDriver(options);
    }
}
