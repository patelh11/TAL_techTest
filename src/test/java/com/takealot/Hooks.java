package com.takealot;

import com.cucumber.listener.Reporter;
import com.takealot.drivermanager.ManageDriver;
import com.takealot.propertyreader.PropertyReader;
import com.takealot.utilities.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {
    @Before
    public void setUP() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Himali");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotPath = Utility.getScreenshot(ManageDriver.driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       closeBrowser();
    }
}
