package org.testingqa.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;




public class ActionsExample {
    static WebDriver driver;

    public static void main(String[] srgs){
        String chomePath = "./drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chomePath);
        String baseURL = "https://www.facebook.com/";


        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    try {
        //Mover el mause a la mitad del proyecto
        WebElement txtUser = driver.findElement(By.id("email"));

        Actions builder = new Actions(driver);


        Action seriesOfActions = builder.moveToElement(txtUser)
                .click()
                .keyDown(Keys.SHIFT)//Preciono la tecla SHIFT
                .sendKeys("Hello")
                .keyUp(Keys.SHIFT)
                .doubleClick() //doble clic donde se encuentre el mouse
                .contextClick(txtUser) //doble clic sobre le objeto
                .build();

        Thread.sleep(2000);
        System.out.println("Test passed");






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
