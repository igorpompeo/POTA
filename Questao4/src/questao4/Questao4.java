/*
Encontrar o valor do maior elemento de um vetor de inteiros de tamanho n 
(informado pelo usuário).
 */
package questao4;

import java.util.Random;
import javax.swing.JOptionPane;

public class Questao4 {

    public static void main(String[] args) {
        Random r = new Random();
        //Solicitação para o usuário do tamanho do vetor
        int[] vetor = new int[Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " o valor do seu vetor: "))];
        //leitura do vetor de N posições e alocação de número aleatórios
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt();
        }
        int tamanho = vetor.length;
        int maior = maior(vetor, tamanho - 1);
        System.out.println("O maior valor do vetor é: " + maior);
    }

    /**
     * Calcula o maior elemento do vetor
     *
     * @param vetor vetor com os valores
     * @param n quantidade de elementos do vetor
     * @return o maior elemento do vetor
     */
    private static int maior(int[] vetor, int n) {
        if (n == 0) {
            return vetor[0];
        } else {
            int m = maior(vetor, n - 1);
            if (m> vetor[n]){
                return m;
            }else{
                return vetor[n];
            }
        }
    }

}
