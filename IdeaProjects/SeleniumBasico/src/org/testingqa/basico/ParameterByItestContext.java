package org.testingqa.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ParameterByItestContext {
    WebDriver driver;

    @BeforeTest(groups = {"A", "B"})//Indicamos que grupos tienen accesos a este metodo

    public void setup() {

        String chomePath = "./drivers/chromedriver";
        String baseURL = "http://google.com";
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest(groups = {"A"})

    public void tearDown(){
        driver.quit();

    }

    @Test (dataProvider = "SearchProvider", groups = "A")//Aqui llamamos la "clase ParameterByMethodClass" y le indicamos a que grupo pertenece el metodo
    public void testMethodA(String tester, String searchKey)throws InterruptedException {// Los dos parametrso de Busqueda
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);//Escribir lo que hay en la variable Search
        System.out.println("Welcome ->"+ tester + "Your search word is ->" + searchKey);
        Thread.sleep(3000);

        //Cuando se requiera extraer un texto de combo box se debera ser con un "Value"
        String tesValue = searchText.getAttribute("value");
        System.out.println("Test Values is -> "+ tesValue +"And is equels to" + searchKey);//Aqui imprimimos la comparamos los textos
        searchText.clear(); // para limpiar los textbox

        Assert.assertTrue(tesValue.equalsIgnoreCase(searchKey));
    }

    @Test (dataProvider = "SearchProvider",groups = "B")//Aqui llamamos la "clase ParameterByMethodClass" y le indicamos a que grupo pertenece el metodo )
    public void testMethodB(String searchKey)throws InterruptedException {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);
        Thread.sleep(3000);

        String tesValue = searchText.getAttribute("value");
        System.out.println("Test Values is -> "+ tesValue +"And is equels to" + searchKey);
        searchText.clear();

        //Verify if the values in google serach box is correct
        Assert.assertTrue(tesValue.equalsIgnoreCase(searchKey));
    }



    // Se crea la variable con "ITestContext"
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(ITestContext c) {
        Object[][] groupArray = null;
        for(String group: c.getIncludedGroups()){
            if(group.equals("A")) {
                groupArray = new Object[][]{
                        {"Samuel", "Google"},
                        {"Lorena", "Yahoo"},
                        {"Annie", "Gmail"},
                        {"Jonathan", "Amazon"}

                };
                break;

            }else if(group.equals("B")){
                groupArray = new Object[][]{
                        {"Colombia"},
                        {"China"},
                        {"Rusia"},
                        {"Alemania"}
                };



            }
            break;
        }
        return groupArray;

    }


}




