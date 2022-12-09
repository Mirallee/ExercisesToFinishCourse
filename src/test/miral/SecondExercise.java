import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SecondExercise {
    public static void main(String[] args) {
        ChromeDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.cssSelector("input[name='name']:nth-child(2)")).sendKeys("Patryk");
        driver.findElement(By.cssSelector("input[name='email']:nth-child(2)")).sendKeys("ZiomalWbija@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123123");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        WebElement staticDropDown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(1);
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("11032022");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        WebElement messageAfterSubmit = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
        Assert.assertTrue(messageAfterSubmit.isDisplayed());


    }
}