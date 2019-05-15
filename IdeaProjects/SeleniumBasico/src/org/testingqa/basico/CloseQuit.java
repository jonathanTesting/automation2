package org.testingqa.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    static WebDriver driver;
    static String baseURL  = "http://www.popuptest.com/popuptest1.html";
    static String chomePath = "./drivers/chromedriver";

    /// Se crean dos Metodos CLOSE and QUIT

    public static void close(){ // para este metodo voy a utilizar navigat
        driver = new ChromeDriver();
        driver.navigate().to(baseURL);
        driver.close();

    }

    public static void quit () throws InterruptedException{
        driver = new ChromeDriver();
        driver.get(baseURL);
        Thread.sleep(2000);
        driver.quit();

    }

/// Se debe crear el metodo MAIN

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",chomePath);
        //close();// se llama el primer metodo ESTA SOLO CIERRA UNA VENTA DEL NAVEGADOR
        quit(); //este metodo cierra todas las ventanas



    }

}
