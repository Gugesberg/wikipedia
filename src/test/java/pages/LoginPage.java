package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userNameLocator = $("#wpName1"),
    passwordLocator = $("#wpPassword1"),
    submitButtonLocator = $("#wpLoginAttempt"),
    stayInSystemCheckBoxLocator = $("#wpRemember");

    public LoginPage setUserName(){
        userNameLocator.setValue("AlexIvanov1994");
        return this;
    }

    public LoginPage setPassword(){
        passwordLocator.setValue("38265421");
        return this;
    }
}
