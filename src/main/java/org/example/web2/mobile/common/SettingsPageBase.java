package org.example.web2.mobile.common;


import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingsPageBase extends AbstractPage {
    public SettingsPageBase(WebDriver driver) { super(driver); }

    public abstract boolean isSettingsTitleVisible();
    public abstract void toggleOption(String optionName);
}