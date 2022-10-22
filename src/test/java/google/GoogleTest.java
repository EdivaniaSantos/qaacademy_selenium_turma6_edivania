package google;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleTest {
    WebDriver driver;

    @Test
    public void testgoogle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Bolsonaro");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[1]/div/div[2]/div[1]/span")).click();
        String texto = driver.findElement(By.xpath("//*[@id=\"eer-masthead\"]/div[2]")).getText();
        Assert.assertEquals("Texto invalido","Resultados das eleições presidenciais de 2022: Brasil",texto);

    }
    @After
    public void fecharBrowser(){
        driver.quit();
    }


}
