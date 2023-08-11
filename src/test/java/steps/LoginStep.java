package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoginStep {
    private final SelenideElement BUTTON_LOGIN = $x("//span[text()='Войти']");
    private final SelenideElement INPUT_NAME_REG = $x("//input[@name='name']");
    private final SelenideElement INPUT_EMAIL_REG = $x("//input[@name='email']");
    private final SelenideElement INPUT_PASSWORD_REG = $$x("//input[@name='password']").get(1);
    private final SelenideElement BUTTON_REGISTRATION = $x("//input[@value='Зарегистрироваться']");
    private final SelenideElement LOGO_AUTHORIZATION = $x("//a[@class='dropdown-toggle']");

    @Given("Открываем сайт {string}")
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    @When("Нажать на кнопку Войти")
    public void clickLogin() {
        BUTTON_LOGIN.click();
    }

    @And("Ввести имя пользователя {string}")
    public void inputUserName(String userName) {
        INPUT_NAME_REG.sendKeys(userName);
    }

    @And("Ввести Email пользователя {string}")
    public void inputUserEmail(String userEmail) {
        INPUT_EMAIL_REG.sendKeys(userEmail);
    }

    @And("Ввести Пароль пользователя {string}")
    public void inputUserPassword(String userPassword) {
        INPUT_PASSWORD_REG.sendKeys(userPassword);
    }

    @And("Нажать кнопку Зарегистрироваться")
    public void clickRegistration() {
        BUTTON_REGISTRATION.click();
    }

    @Then("Проверяем что пользователь зарегистрирован успешно {string}")
    public void checkAuthorization(String extendedResult) {
        String result = LOGO_AUTHORIZATION.getText();
        Assert.assertEquals(extendedResult, result);
    }
}
