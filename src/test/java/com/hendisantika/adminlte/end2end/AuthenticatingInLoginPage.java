package com.hendisantika.adminlte.end2end;

import com.hendisantika.adminlte.end2end.pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticatingInLoginPage {
    private WebDriver driver;
    private Login loginPage;

    @Before // This annotation is from Cucumber, not JUnit. It's executed as the first step
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        loginPage = new Login(driver);
    }
    @After  // This annotation is from Cucumber, not JUnit. It's executed as the final step
    public void tearDown() {
        driver.quit();
    }

    @Given("User accesses the login page at {string}")
    public void user_accesses_the_login_page(String url) {
        driver.get(url);
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
