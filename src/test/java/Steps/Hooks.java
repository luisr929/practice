package Steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void start() {

        openBrowserAndNavigateToUrl();
    }

    @After
    public void end(Scenario scenario) {
        //we need this variable because my screenshot method returns array of bytes
        byte[] pic;
        //here we are going to capture the screenshot and attaching it to the report
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        //attach this screenshot in the report


        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }


}


