import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EighthExercise {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }

    }
}
