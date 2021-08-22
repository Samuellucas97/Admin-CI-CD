package com.hendisantika.adminlte;

import com.hendisantika.adminlte.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumExtension.class)
public class AuthenticatingInLoginPage {
    private WebDriver driver;
    private Login loginPage;

    @Given("User accesses the login page at {string}")
    public void user_accesses_the_login_page(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        loginPage = new Login(driver);
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
