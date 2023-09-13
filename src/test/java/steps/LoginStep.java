package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class LoginStep {
    String ADMIN_EMAIL = "manager@mail.ru";
    String ADMIN_PASSWORD = "1";

    private final SelenideElement BUTTON_LOGIN = $x("//span[text()='Войти']");

    private final SelenideElement INPUT_EMAIL_AUT = $x("//input[@name='login']");
    private final SelenideElement INPUT_PASSWORD_AUT = $x("//input[@name='password']");
    private final SelenideElement BUTTON_USER_AUT = $x("//input[@value='Авторизоваться']");

    private final SelenideElement INPUT_NAME_REG = $x("//input[@required=''][@name='name']");
    private final SelenideElement INPUT_EMAIL_REG = $x("//input[@required=''][@name='email']");
    private final SelenideElement INPUT_PASSWORD_REG = $x("//input[@name='password'][@required='']");
    private final SelenideElement BUTTON_REGISTRATION = $x("//input[@value='Зарегистрироваться']");

    private final SelenideElement BUTTON_ICON = $x("//a[@class='dropdown-toggle']");
    private final SelenideElement BUTTON_LOGOUT = $x("//a[@href='/user/logout.html']");

    private final SelenideElement INPUT_NAME_OR_EMAIL = $x("//input[@placeholder='Введите email или имя']");
    private final SelenideElement BUTTON_SEARCH = $x("//button[@class='btn btn-submit']");
    private final SelenideElement BUTTON_DELETE = $x("//a[text()='Удалить']");

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

    @Then("Проверяем что пользователь {string} зарегистрирован успешно {string}")
    public void checkAuthorization(String userName, String extendedResult) {
        String result = WebDriverRunner.url();
        if (result.equals("http://users.bugred.ru/")) {
            BUTTON_ICON.click();
            BUTTON_LOGOUT.click();

            BUTTON_LOGIN.click();
            INPUT_EMAIL_AUT.sendKeys(ADMIN_EMAIL);
            INPUT_PASSWORD_AUT.sendKeys(ADMIN_PASSWORD);
            BUTTON_USER_AUT.click();

            INPUT_NAME_OR_EMAIL.sendKeys(userName);
            BUTTON_SEARCH.click();
            BUTTON_DELETE.click();

            BUTTON_ICON.click();
            BUTTON_LOGOUT.click();
        }
        Assert.assertEquals(extendedResult, result);
    }
}
