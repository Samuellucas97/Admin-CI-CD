package com.hendisantika.adminlte.end2end;


import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class Base {
    @Autowired
    protected WebDriver driver;

    @Value("${host}")
    protected String host;
}
