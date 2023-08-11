package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHooks {
    @Before
    public void setUpDriverBeforeScenario(){
        WebDriverManager.chromedriver().setup();
    }
}
