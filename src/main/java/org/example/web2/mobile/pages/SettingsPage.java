package org.example.web2.mobile.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.web2.mobile.common.SettingsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private ExtendedWebElement settingsTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
    private ExtendedWebElement notificationsOption;

    public SettingsPage(WebDriver driver) { super(driver); }

    @Override
    public boolean isSettingsTitleVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(settingsTitle)));
        return settingsTitle.isVisible();
    }


    @Override
    public void toggleOption(String optionName) {
        if(optionName.equals("Notifications")) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(notificationsOption)));
            notificationsOption.click();
        }

    }
}
