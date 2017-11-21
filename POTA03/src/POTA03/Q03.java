package POTA03;

import javax.swing.JOptionPane;

public class Q03 {

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
        int posicao = buscaSequencial(vetor, fim, busca);
        if (posicao == -1) {
            JOptionPane.showMessageDialog(null, "Elemento não encontrado");
        } else {
            JOptionPane.showConfirmDialog(null, "Elementro encontrado na posicao " + posicao);
        }
    }

    public static int buscaSequencial(int[] vetor, int n, int k) {
        if (n <= 0) {
            return -1;
        } else if (vetor[n - 1] == k) {
            return n - 1;
        } else {
            return buscaSequencial(vetor, n - 1, k);
        }
    }

}
