package social.net.worker.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ta.core.driver.DriverFactory;
import ta.core.ui.BaseUIElement;

@Log4j2
public class MixCloudPage extends BaseUIElement {

    @FindBy(title = "Play")
    private WebElement playButton;

    @Step
    public static MixCloudPage openShowPage(String showUrl) {
        DriverFactory.getDriver().get("https://www.mixcloud.com/lion17s" + showUrl);
        return new MixCloudPage();
    }

    @Step
    public MixCloudPage playShow() {
        playButton.click();
        return this;
    }

    @Step
    public void keepListeningFor(long minutes) throws InterruptedException {
        log.debug("Keep listening for {}", minutes);
        Thread.sleep(minutes * 60 * 1000);
    }

}
