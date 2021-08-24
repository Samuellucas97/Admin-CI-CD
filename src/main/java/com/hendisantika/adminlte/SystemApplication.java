package com.hendisantika.adminlte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

	@Bean
	public WebDriver webDriver() {
		WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
		return new ChromeDriver(options);
	}
}
