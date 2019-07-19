package com.knolx.demo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class FeaturesTest {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Redmi 5A");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("udid", "37e96ea27ce5"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("appPackage", "com.Slack");
        caps.setCapability("appActivity", "com.Slack.ui.HomeActivity");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 100000);
    }

    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    @Description("Test Description: Knoldus Logo Button Scenario")
    @Story("Demo Test")
    @Step("Launch the APP ,Go to knoldus logo and explore channels...")
    @Feature("Services Test")
    @Test(priority = 1, description = "slack App Test.")
    public void SlackTest() {
        System.out.println("<=========Slack App Test===========>");
        String avatarButtonId = "com.Slack:id/avatar_button";
        String searchButtonId = "com.Slack:id/search_button";
        String knoldusWorkspace = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]";
        String abhishekXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[11]";
        String messageBoxId = "com.Slack:id/message_input_field";
        boolean isSlackButton = !driver.findElementsById(avatarButtonId).isEmpty();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(avatarButtonId))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(searchButtonId))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(knoldusWorkspace))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(avatarButtonId))).click();
        verticalSwipeByPercentages(0.6, 0.6, 0.1);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(abhishekXpath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(messageBoxId))).sendKeys("Hello");
        Assert.assertTrue(isSlackButton);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
