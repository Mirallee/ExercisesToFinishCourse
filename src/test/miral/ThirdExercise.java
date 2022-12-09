import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ThirdExercise {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        int j = 0;
        String[] itemsNeeded = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};


        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//label[2]//span[2]")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5) );
        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#okayBtn")));
        driver.findElement(By.cssSelector("#okayBtn")).click();

        WebElement staticDropDown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));


        List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(name)) {
                j++;
                driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

    }
}
