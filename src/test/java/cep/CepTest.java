package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CepTest {
    WebDriver driver;

    @Test
    public void testcep() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.findElement(By.name("endereco")).sendKeys("06717625");
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"tipoCEP\"]")));
        select.selectByVisibleText("Localidade/Logradouro");
        driver.findElement(By.name("btn_pesquisar")).click();
        String texto = driver.findElement((By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]"))).getText();
        Assert.assertEquals("Texto invalido","Rua dos Alpes",texto);


    }
    @After
    public void fecharBrowser(){
        driver.quit();
    }

}