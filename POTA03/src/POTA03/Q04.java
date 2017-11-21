package POTA03;

import javax.swing.JOptionPane;

public class Q04 {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos elementos no máximo terá o vetor? "));
        int vetor[] = new int[n];
        int fim = -1;
        int elemento;
        do {
            elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor: "));
            fim++;
            vetor[fim] = elemento;
        } while (elemento != -999);
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado"));
        int posicao = buscaBinaria(vetor, 0, fim - 1, busca);
        if (posicao == -1) {
            JOptionPane.showMessageDialog(null, "Elemento não encontrado");
        } else {
            JOptionPane.showConfirmDialog(null, "Elementro encontrado na posicao " + posicao);
        }
    }

    public static int buscaBinaria(int[] vetor, int inicio, int fim, int k) {
        int centro;
        while (inicio <= fim) {
            centro = inicio + (fim - inicio) / 2;
            if (k == vetor[centro]) {
                return centro;
            } else if (k > vetor[centro]) {
                return buscaBinaria(vetor, centro + 1, fim, k);
            } else {
                return buscaBinaria(vetor, inicio, centro - 1, k);
            }
        }
        return -1;
    }

}
