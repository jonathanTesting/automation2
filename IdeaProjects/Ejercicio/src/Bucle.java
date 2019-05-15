import javax.swing.*;

public class Bucle {



    int numero=0;
    int factorial=1;


    numero=Integer.parseInt(JOptionPane.showInputDialog("Ingresar un numero: "));

        while(numero!=0){
        factorial*=numero;
        numero--;


    }
        JOptionPane.showMessageDialog(null, "Paila"+factorial)
}
z