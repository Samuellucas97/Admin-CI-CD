package com.hendisantika.adminlte.end2end;

import com.hendisantika.adminlte.end2end.pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AuthenticatingInLoginPage {
    @Autowired
    private WebDriver driver;
    @Autowired
    private Login loginPage;
    @LocalServerPort
    private int port;

    @After  // This annotation is from Cucumber, not JUnit. It's executed as the final step
    public void tearDown() {
        driver.quit();
    }
    @Given("User accesses the login page at {string}")
    public void user_accesses_the_login_page(String url) {
        driver.get("http://localhost:"+port+url);
    }
    @When("input {string} as username")
    public void input_as_username(String username) {
        loginPage.typingInUsernameInput(username);
    }
    @When("input {string} as password")
    public void input_as_password(String password) {
        loginPage.typingInPasswordInput(password);
    }
    @When("Press the login button")
    public void press_the_login_button() {
        loginPage.clickingOnLoginButton();
    }
    @Then("Check if the title is {string}")
    public void check_if_the_title_is(String expectedTitle) {
        final String title = driver.getTitle();
        assertThat(title).isEqualTo(expectedTitle);
    }
}
