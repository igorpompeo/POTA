/*
Construir um algoritmo para imprimir a série de FIBONACCI até o n° termo. 
O termo deve ser passado pelo usuário.
 */
package questao3;

import java.util.Scanner;

public class Questao3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantos termos deseja imprimir da Sequência de "
                + "Fibonacci?");
        int termos = entrada.nextInt();
        for (int i = 0; i < termos; i++) {
            System.out.println(fibonacci(i) + "\t");
        }
        System.out.println();
    }

    /**
     * Calcula Fibonacci de um determinado termo
     *
     * @param n número do termo
     * @return valor de Fibonacci naquele termo
     */
    private static long fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
