package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeachTest {
    private static final String BASE_URL = "https://speak-ukrainian.org.ua/dev/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static WebDriver driver;

    private static void presentationSleep() {
        presentationSleep(1);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takeScreenShot() throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
    }
    
    //@BeforeClass
    public static void beforeClassFirefox() {
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        //driver = new FirefoxDriver();
        //
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        //
        // driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\yharasym\\.cache\\selenium\\chromedriver\\win32\\99.0.4844.51\\chromedriver.exe");
        // driver = new ChromeDriver();
        //
        // https://peter.sh/experiments/chromium-command-line-switches/
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        //options.setBinary("C:\\Windows\\system32\\calc.exe"); // Binary file
        options.addArguments("--headless"); // Chrome Without UI
        driver = new ChromeDriver(options);
        //
        // driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    //@BeforeClass
    public static void beforeClassHtmlUnitDriver() {
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        //
        driver = new HtmlUnitDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    // Download from http://phantomjs.org/download.html
    // Download from phantomjsdriver-1.4.4.jar
    //@BeforeClass
    public static void beforeClasssPhantomJs() {
        //WebDriverManager.phantomjs().setup();
        System.setProperty("phantomjs.binary.path", "C:\\Users\\yharasym\\.cache\\selenium\\phantomjs\\win64\\2.1.1\\phantomjs.exe");
        // driver = new ChromeDriver();
        //
        driver = new PhantomJSDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        driver.quit(); // Close browser and stop server
    }

    @Before
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @Test
    public void testSearch() throws IOException {
        //
        System.out.println("***Start test");
        //presentationSleep(); // For Presentation ONLY
        //takeScreenShot();
        //
        // City Click
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.cssSelector("span.anticon.anticon-caret-down")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        List<WebElement> cities = driver.findElements(By.cssSelector("li.ant-dropdown-menu-item.ant-dropdown-menu-item-only-child"));
        presentationSleep(); // For Presentation ONLY
        presentationSleep(); // For Presentation ONLY
        Assert.assertTrue(cities.get(1).getText().contains("Харків"));
        System.out.println("***Size = " + cities.size());
        System.out.println("***contains: " + cities.get(1).getText());
        System.out.println("driver = " + driver.toString());
        takeScreenShot();
        presentationSleep(); // For Presentation ONLY
        //
    }
}
