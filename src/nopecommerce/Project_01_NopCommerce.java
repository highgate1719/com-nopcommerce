package nopecommerce;

/**
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Project_01_NopCommerce {

    static String browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
        // formula declaration for multi browser

        if (browser.equalsIgnoreCase("Chrome")) {

            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);


        //1 - 2 set up Chrome browser and open url

        String baseUrl = "https://demo.nopcommerce.com/";

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        // Maximise the Browser
        driver.manage().window().maximize();


        // 3 Print title of the page
        String title = driver.getTitle();
        System.out.println("Page title is : " + title);


        // 4 Print Current Url
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //5 Print the page source
        System.out.println("Page source : " + driver.getPageSource());

        //Give implicit time to wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //6 find login link element and click on it
        String login = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.get(login);

        // 7 Print current url
        System.out.println("Currrent URL : " + driver.getCurrentUrl());

        // 8 navigate back to  home page
        driver.navigate().back();
        System.out.println("Navigate back to home page : " + driver.getCurrentUrl());

        //9 navigate to the login page
        Thread.sleep(5000);
        driver.navigate().forward();
        System.out.println("Navigate to the login page : " + driver.getCurrentUrl());

        //10 print current url
        System.out.println("Current  URL : " + driver.getCurrentUrl());

        // 11 refresh
        driver.navigate().refresh();

        ////Give implicit time to wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //12 enter the e-mail and password
        WebElement emailfield = driver.findElement(By.id("Email"));
        WebElement passwordfield = driver.findElement(By.name("Password"));

        emailfield.sendKeys("test123@gmail.com");
        passwordfield.sendKeys("abc123");

        // 13 login option

        WebElement loginlink = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));

        // 14 click on log in

        loginlink.click();

        //Close the browser
        driver.quit();

    }

}
