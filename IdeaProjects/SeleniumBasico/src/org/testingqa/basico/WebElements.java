package org.testingqa.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {

    public static void  main (String[] args){

        WebDriver driver;

        String baseURL = "http://live.guru99.com/index.php/tv.html/";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chomePath = "./drivers/chromedriver";


        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();///Maximizar la pantalla no aplica para MAC


        //Clic en el TV --By.linkText
        WebElement inkTV = driver.findElement(By.linkText("TV"));
        inkTV.click();

        //Clic en boton ADD TO CART -By.xpath
        WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
        btnAddToCart.click();

        //Obtener el precio y validarla. (texto de dicho objeto)- By.cssSelector
        WebElement iblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
        actualResult = iblSubtotal.getText();

        //Validacion del valor
        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba Paso! el resultado actual es: " + actualResult + " es igual a" + expectedResult);

        } else {
            System.out.println("Prueba Falla! el resultado actual es: " + actualResult + " NO es igual a" + expectedResult);
        }

        driver.close();
    }



}
