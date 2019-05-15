package factorial;

import javax.swing.JOptionPane;

public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numero=0;
        int factorial=1;


        numero=Integer.parseInt(JOptionPane.showInputDialog("Ingresar un numero: "));

        factorial=Factorial.calcular(numero);


        if(factorial!=-1){
            JOptionPane.showMessageDialog(null, "El numero factorial Es: "+factorial);
        }
        else {
            JOptionPane.showMessageDialog(null, "El numero ingresado es invalido");
        }

        }




    public static int calcular (Integer numero){



        int factorial=1;

        if(numero>=1){
            while(numero!=0){
                factorial*=numero;
                numero--;
                System.out.println(numero);
            }
        }
        else{

            return -1;

        }

        return factorial;

    }


}