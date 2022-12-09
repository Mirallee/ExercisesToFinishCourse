import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FifthExercise {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        System.out.println(driver.findElement(By.cssSelector("#content")).getText());

    }
}