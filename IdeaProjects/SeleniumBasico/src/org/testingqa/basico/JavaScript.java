package org.testingqa.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScript {

    private WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    String baseUrl= "http://newtours.demoaut.com/";
    private JavascriptExecutor js; ///Valiable de tipo JAVAScrip
    String pageLoadStatus="";// para ver el estatus de mi pagina




    // se crea un metodo para hacer "HighLight" sobre los objetos
    private boolean highLight(WebElement element) {
        js = (JavascriptExecutor)driver;

        for (int iCnt = 0; iCnt < 3; iCnt++){ //hacemos un ciclo for para hacer el higlight
            try {
                //Modificacion de background pintarlo de color ROJO
                js.executeScript("arguments[0].setAttribute('style','background:red')",element);
                Thread.sleep(1000);
                js.executeScript("arguments[0].setAttribute('style','background:')",element);
                System.out.println("Pinta de red el background");

            }catch (Exception e){
                System.err.println("JavaScript | Method: highLight | Exception desc: " + e.getMessage());
                return false;


            }

        }
        return true;

    }

    //Metodo Para realizar scrollWindow
    private boolean scrollWindow(){
        try {
            js =(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,250)");// Si se quiere hacer un Scroll up (0,-250)/down(0,250)
        }catch (Exception e){
            System.err.println("JavaScript | Mathod: scrollWindow | Exception desc: " + e.getMessage());
            return false;

        }
        return true;
    }
// se crea un metodo "waiFroPageToLoad" para que nos indique que la pagiana esta completamente cargada

    /*private boolean waiFroPageToLoad(){
        try {
            do {
                js= (JavascriptExecutor)driver;
                pageLoadStatus = (String)js.executeAsyncScript("return document.readyState");
            }while (!pageLoadStatus.equals("complete"));


        }catch (Exception e){
            System.err.println("JavaScript | Mathod: waiFroPageToLoad | Exception desc: " + e.getMessage()+"Se jode");
            return false;
        }
        return true;


    }*/


    @BeforeTest
    public void launcherBrowser(){

        String chomePath = "./drivers/chromedriver";
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(baseUrl);
        //waiFroPageToLoad();
        System.out.println("Abre Browser ");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("paso por aqui FINAL-");

    }

    @Test(priority = 0)
    public void goToRegisterPage(){
        WebElement InkRegister = driver.findElement(By.linkText("REGISTER"));
        Assert.assertTrue(highLight(InkRegister));
        js.executeScript("arguments[0].click();",InkRegister);//Damos click pero con JS
        expectedResult= "Register: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(scrollWindow());
        System.out.println("Busca REGISTER");


    }

    @Test(priority = 1)
    public void registerAnUser(){
        try{
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            highLight(txtFirstName);
            txtFirstName.sendKeys("Jonathan");

            WebElement ddlCountry = driver.findElement(By.name("country"));
            highLight(ddlCountry);
            new Select(ddlCountry).selectByVisibleText("AUSTRIA");

            highLight(driver.findElement(By.id("email")));
            driver.findElement(By.id("email")).sendKeys("tatan@gmail.com");


            highLight(driver.findElement(By.name("password")));
            driver.findElement(By.name("password")).sendKeys("123");


            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            highLight(txtConfirmPass);
            txtConfirmPass.sendKeys("123");
            txtConfirmPass.submit();
            System.out.println("paso por aqui Termina Formulario 3");

            //Assert.assertTrue(waiFroPageToLoad());

            highLight(driver.findElement(By.xpath("//*[contains(text(),'Note:')]")));

            System.out.println("Compara mensaje de guarado");




        }catch(NoSuchElementException ne){
            Assert.fail("Test Failed: Element was not found");

        }catch(Exception e){
            Assert.fail("Test Failed: " + e.getMessage());
        }


    }

}
