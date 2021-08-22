package com.hendisantika.adminlte.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
    @FindBy(xpath = "//body/div[1]/div[2]/form[1]/div[1]/input[1]")
    private WebElement usernameInput;
    @FindBy(xpath = "//body/div[1]/div[2]/form[1]/div[2]/input[1]")
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

    public void typingInPasswordInput(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(Keys.chord(username));
    }

    public void clickingOnLoginButton() {
        loginButton.click();
    }
}
