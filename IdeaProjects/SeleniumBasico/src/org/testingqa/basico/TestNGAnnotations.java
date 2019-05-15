package org.testingqa.basico;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Este Meto se ejecuta antes de una suite de pruebas");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Este Meto se ejecuta antes de las pruebas @Tes");

    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("Este Meto se ejecuta antes de la clase");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Este Meto se ejecuta antes de cada metodo @Tes");

    }


    @Test
    public void testCase1(){
        System.out.println("Caso de prueba 1");

    }

    @Test
    public void testCase2(){
        System.out.println("Caso de prueba 2");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Se ejecuta despues de cada metod de prueba");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Este metod se ejecuta despues de la clase");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("Este metodo se ejecuta despues de todas las pruebas");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Este metdo se ejecuta despues de una suite de pruebas");

    }
}

