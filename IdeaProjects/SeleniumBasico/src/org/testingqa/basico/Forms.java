package org.testingqa.basico;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import com.sun.xml.internal.ws.server.DefaultResourceInjector;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {

    static WebDriver driver;


    public static void main(String[] args){

        String chomePath = "./drivers/chromedriver";
        String baseURL = "http://newtours.demoaut.com";
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try{

            driver.findElement(By.linkText("REGISTER")).click();

            //Estas son las formas que se realiza el llenado de un campo
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Jonathan");
            // Se utilza para borrar el texto y volver a colocar otro
            //Thread.sleep(1500);
            //txtFirstName.clear();
            //Thread.sleep(1500);
            //txtFirstName.sendKeys("Jonathan Prueba");

            WebElement txtLastName = driver.findElement(By.name("lastName"));
            txtLastName.sendKeys("Rodriguez");

            WebElement txtphone = driver.findElement(By.name("phone"));
            txtphone.sendKeys("137277777");

            WebElement txtUserName =driver.findElement(By.name("userName"));
            txtUserName.sendKeys("Samtesting.qa@gmail.com");

            WebElement txtAddress1 = driver.findElement(By.name("address1"));
            txtAddress1.sendKeys("Carre 28 - 78");

            driver.findElement(By.name("city")).sendKeys("Bogota");

            driver.findElement(By.name("state")).sendKeys("077");

            driver.findElement(By.name("postalCode")).sendKeys("099");

            //Este es un selecctor

            Select drpCountry =new Select(driver.findElement(By.name("country")));
            Thread.sleep(2000);
            drpCountry.selectByVisibleText("COLOMBIA");

            driver.findElement(By.id("email")).sendKeys("Samtesting.qa@gmail.com");
            driver.findElement(By.name("password")).sendKeys("123");

            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("123");
            txtConfirmPass.submit();

            System.out.println("Prueba Exitosa!! " +driver.findElement(By.xpath("//*[contains(text(),'Note')]")).getText() );




        } catch (NoSuchElementException ne){
            System.err.println("NO se encontro el WebElement: " + ne.getMessage());
        } catch (WebDriverException we){
            System.err.println("WebDriver Fallo: ");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.quit();
        }



    }






}
