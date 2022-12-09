import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SixthExercise {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        WebElement footerDriver = driver.findElement(By.cssSelector(".block.large-row-spacer:nth-child(3)"));
        WebElement checkboxDriver = footerDriver.findElement(By.cssSelector("#checkbox-example"));
        checkboxDriver.findElement(By.cssSelector("label[for='benz']")).click();

        //3
        String s = driver.findElement(By.cssSelector("label[for='benz']")).getText();
        System.out.println(s);
        WebElement staticDropDown = footerDriver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByVisibleText(s);
        //4
        WebElement switchDriver = driver.findElement(By.cssSelector("body > div:nth-child(4)"));
        WebElement columnDriver = switchDriver.findElement(By.cssSelector(".pull-right"));
        WebElement enterYourName = columnDriver.findElement(By.cssSelector("#name"));
        enterYourName.sendKeys(s);
        //5
        columnDriver.findElement(By.cssSelector("#alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();

    }
}
