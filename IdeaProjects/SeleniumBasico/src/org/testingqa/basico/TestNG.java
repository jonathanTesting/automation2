package org.testingqa.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG {

    String baseURL = "http://newtours.demoaut.com";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chomePath = "./drivers/chromedriver";

    //Craear metodos
    @BeforeTest
    public  void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @BeforeMethod
    public void verifyHomePageTitle(){ ///En este metodo creado validamos antes de ejecutar los test que el titulo del HOME PAGE sea el indicado.
        expectedResult="W8elcome: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals");// aquie se hace un Assert que permite valiadar si es igual o no, y si no se genera un mensage

    }

    @AfterMethod
    public void goBackToHomePage(){ //Metodo para ir a HOME
        driver.findElement(By.linkText("Home")).click();
    }


    @AfterTest
    public void tearDown(){// metodo para cerrar los navegadores despues de la ejecucion
        driver.quit();
    }

    @Test (priority = 1)
    public void register() throws InterruptedException {
        driver.findElement(By.linkText("REGISTER")).click();
        expectedResult = "Regis8ter: Mercury Tours";
        actualResult = driver.getTitle();
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");
    }

    @Test (priority = 0)
    public void support()throws InterruptedException{
        driver.findElement(By.linkText("SUPPORT")).click();
        expectedResult="Under Construction: Mercury Tours";
        actualResult =driver.getTitle();
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");


    }




}
