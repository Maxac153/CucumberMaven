package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class AfterStepHooks {
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        Selenide.screenshot(System.currentTimeMillis() + "steps");
    }
}
