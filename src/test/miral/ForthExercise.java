import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ForthExercise {
    public static void main(String[] args) {

// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
        driver.findElement(By.cssSelector(".example")).getText();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.findElement(By.cssSelector("div[class='example'] h3")).getText();


    }
}