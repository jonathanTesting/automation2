package org.testingqa.basico;

import org.omg.CORBA.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ParameterByMethod {
    WebDriver driver;

    @BeforeTest

    public void setup() {

        String chomePath = "./drivers/chromedriver";
        String baseURL = "http://google.com";
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest

    public void tearDown(){
        driver.quit();

    }

     @Test (dataProvider = "SearchProvider", dataProviderClass =ParameterByMethodClass.class )//Aqui llamamos la "clase ParameterByMethodClass"
     public void testMethodA(String tester, String search)throws InterruptedException {// Los dos parametrso de Busqueda
         WebElement searchText = driver.findElement(By.name("q"));
         searchText.sendKeys(search);//Escribir lo que hay en la variable Search
         System.out.println("Welcome ->"+ tester + "Your search word is ->" + search);
         Thread.sleep(2000);

         //Cuando se requiera extraer un texto de combo box se debera ser con un "Value"
         String tesValue = searchText.getAttribute("value");
         System.out.println("Test Values is -> "+ tesValue +"And is equels to" + search);//Aqui imprimimos la comparamos los textos
         searchText.clear(); // para limpiar los textbox

         Assert.assertTrue(tesValue.equalsIgnoreCase(search));
    }

    @Test (dataProvider = "SearchProvider", dataProviderClass =ParameterByMethodClass.class)
    public void testMethodB(String search)throws InterruptedException {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        Thread.sleep(2000);

        String tesValue = searchText.getAttribute("value");
        System.out.println("Test Values is -> "+ tesValue +"And is equels to" + search);
        searchText.clear();

        //Verify if the values in google serach box is correct
        Assert.assertTrue(tesValue.equalsIgnoreCase(search));
    }





}




