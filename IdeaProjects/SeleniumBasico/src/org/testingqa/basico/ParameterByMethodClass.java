package org.testingqa.basico;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class ParameterByMethodClass {
///https://www.youtube.com/watch?v=QLvgccK_O1s&list=PLgHCrivozIb3OPj61GmIIwXFqPrDI12vJ&index=54
    @DataProvider(name="SearchProvider")
    public java.lang.Object[][] getDataFromDataProvider(Method m) {//Reflexión con DataProvider
        if(m.getName().equals("testMethodA")){
            return new java.lang.Object[][]{
                    {"Samuel", "Google"},
                    {"Lorena", "Yahoo"},
                    {"Annie", "Gmail"},
                    {"Jonathan", "Amazon"}
            };
        }else{
            return new java.lang.Object[][]{
                    {" co"},
                    {"China"},
                    {"Rusia"}
            };

        }
    }
}
