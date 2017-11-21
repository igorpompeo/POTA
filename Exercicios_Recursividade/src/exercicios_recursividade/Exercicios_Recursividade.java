/*Questão 1*/
package exercicios_recursividade;

import javax.swing.JOptionPane;

public class Exercicios_Recursividade {

    public static void main(String[] args) {
        double base = Double.parseDouble(JOptionPane.showInputDialog("Digite o"
                + " valor da base: "));
        int expoente = Integer.parseInt(JOptionPane.showInputDialog("Digite o"
                + " valor do expoente: "));
        if (expoente >= 0){
            JOptionPane.showMessageDialog(null, "O resultado da potência é " + 
                    potencia(base, expoente));
        } else {
            expoente = expoente * -1;
            JOptionPane.showMessageDialog(null, "O resultado da potência é 1/" +
                    potencia(base, expoente));
        }
    }
    /*Calcula a potência de um número
    base -  base da potência
    expoente - expoente da potência
    return - Potência da base elevado a expoente
    */
    
    private static double potencia(double base, int expoente){
        if (expoente == 0){
            return 1;
        } else {
            return base * potencia(base, expoente - 1);
        }
    }
    
}
