package org.testingqa.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){

        //Instanciamos un objeto WebDriver
        WebDriver driver;

        //Declarar Variables
        String baseURL="http://newtours.demoaut.com/";
        String actualResult="";
        String expectedResult="Welcome: Mercury Tours";

        ///Indicra la localizacion del archivo chromedriver
        //Sistem.getProperty("user.dir")=
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        //Abrir el navegador
        driver = new ChromeDriver();

        //Entrar a la URL
        driver.get(baseURL);

        //Obtener nombre de la pagina
        actualResult= driver.getTitle();


        //Imprimir el resultado usando el opeardor ternario "Valida si el resultado es verdadera o no "
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Paso" + actualResult: "Prueba fallida");

        driver.close();




    }


}
