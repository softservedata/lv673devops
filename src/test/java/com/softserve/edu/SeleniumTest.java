package com.softserve.edu;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
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

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    //@BeforeClass
    public static void beforeClassHtmlUnitDriver() {
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        //
        driver = new HtmlUnitDriver(true);
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
    public void testSearch() {
        //
        // Choose Curency
        System.out.println("Choose Curency");
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.cssSelector("button[name='USD']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Steps
        System.out.println("Steps");
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
        presentationSleep(); // For Presentation ONLY
        //
        // Search Button Click
        System.out.println("Search Button Click");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        System.out.println("Check");
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        presentationSleep(); // For Presentation ONLY
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", price);
        presentationSleep(); // For Presentation ONLY
        Assert.assertTrue(price.getText().contains("$602.00"));
        System.out.println("***contains: " + price.getText());
        presentationSleep(); // For Presentation ONLY
        //
    }
}
