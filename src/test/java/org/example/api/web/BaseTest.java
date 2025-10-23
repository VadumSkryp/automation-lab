package org.example.api.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest implements IAbstractTest {

    @BeforeClass
    public void setUpDriver() {
        getDriver();
    }


    @BeforeSuite
    public void setUp() {
        R.CONFIG.put("capabilities.browserName", "chrome", true);
    }

}
