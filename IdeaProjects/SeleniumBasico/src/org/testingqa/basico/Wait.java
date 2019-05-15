package org.testingqa.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Wait {

    static WebDriver driver;


    public static void main(String[] args){

        String chomePath = "./drivers/chromedriver";
        String baseURL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//Tiempo de limite de espera en cada ejecucion de cada linea de codigo
        WebDriverWait waitVar = new WebDriverWait(driver,10);



        try{

            driver.switchTo().frame("iframeResult"); // Aqui ya estamos dentro del "Frames"

            //Inspeccionar el Boton "TRY"
            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(2000);

            // validar la alerta del ExpectedConditions
            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alerWindow =driver.switchTo().alert();
            String alertText = alerWindow.getText(); //se obtiene el texto
            System.out.println(alertText);
            alerWindow.sendKeys("Jonathan");
            alerWindow.accept();

            //Variable para inspeccionar el resultado
            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Jonathan")?finalText:"Prueba Fallo");//Oprador ternario el cual validad si contiene algujuna parte del texto




        }

          catch (NoSuchFrameException nf){
            System.err.println("NO se encontro el Frame: " + nf.getMessage());
        } catch (NoAlertPresentException na){
            System.err.println("NO se encontro el alertas " + na.getMessage());

        } catch (TimeoutException te){
            System.err.println("Tiempo de espera expedido " + te.getMessage());

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
