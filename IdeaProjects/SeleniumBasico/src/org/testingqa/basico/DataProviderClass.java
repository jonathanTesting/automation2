package org.testingqa.basico;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {

    // Se debe Crear el DataProvider y se le da un alias
    @DataProvider(name="SearchProvider")
    //Se crea un metodo tipo Object para que le empeize a utilizar esta estructura
    public Object[][] getDataFromDataProvider(Method m) {
        return new Object[][]{
                {"Samuel", "Google"}, //Objeto bidimensional M = 1Y N 1x1 (Se ingresa el nombre el tester y la palabra de busqiuead que debe ingresar en Google )
                {"Lorena", "Yahoo"},
                {"Annie", "Gmail"},
                {"Jonathan", "Amazon"}

        };

    }



}
