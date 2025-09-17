package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriversFactory {

    public static WebDriver createDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://buger-eats.vercel.app/deliver");
        return driver;
    }
}
