/*
Faça uma função recursiva que converta um número na base 10 para a base 2
 */
package questao5;

import javax.swing.JOptionPane;

public class Questao5 {

    public static void main(String[] args) {
        converteBase10Para2(Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " um valor inteiro: ")));
    }

    private static void converteBase10Para2(int n) {
        if (n > 0) {
            converteBase10Para2(n / 2);
            System.out.print(n % 2);
        }
    }

}
