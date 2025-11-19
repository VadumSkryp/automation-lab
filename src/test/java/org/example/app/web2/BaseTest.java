package org.example.app.web2;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseTest implements IAbstractTest {

    @BeforeClass
    public void setupDriver() {
        getDriver();
    }

    @BeforeSuite
    public void setupSuite() {
        R.CONFIG.put("capabilities.browserName", "chrome", true);
    }



}
