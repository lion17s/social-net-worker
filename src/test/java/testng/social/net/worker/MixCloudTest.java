package testng.social.net.worker;

import social.net.worker.ui.pages.MixCloudPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseUITest;

import java.util.Random;

public class MixCloudTest extends BaseUITest {

    @DataProvider(parallel = true)
    private static Object[][] showProvider() {
        return new Object[][]{
                {"/progressive-mix-13/"}
        };
    }

    @Test(groups = "ui.test.example", dataProvider = "showProvider")
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public void verifyCanListenToShow(String showUrl) throws InterruptedException {
        MixCloudPage
                .openShowPage(showUrl)
                .playShow()
                .keepListeningFor(new Random().ints(1, 60).findFirst().getAsInt());
    }

}
