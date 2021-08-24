package com.hendisantika.adminlte.end2end.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Login extends PageObject {
    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void typingInUsernameInput(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(Keys.chord(username));
    }

    public void typingInPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(Keys.chord(password));
    }

    public void clickingOnLoginButton() {
        loginButton.click();
    }
}
