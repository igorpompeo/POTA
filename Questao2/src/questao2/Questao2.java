/*
Desenvolva um programa que calcule o 
fatorial de um número inteiro não negativo fornecido
pelo usuário. 
 */
package questao2;

import javax.swing.JOptionPane;

public class Questao2 {

    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número natural"));
        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "Digite um número inteiro não negativo");
        } else {
            JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é " + fatorial(numero));
        }
    }

    /**
     * Calcula o fatorial de um número
     *
     * @param n Número que se deseja o fatorial
     * @return Valor do fatorial de n
     */
    private static int fatorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }
}
