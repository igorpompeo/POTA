package questao7;

import java.util.Random;
import javax.swing.JOptionPane;

public class Questao7 {

    public static void main(String[] args) {
        Random r = new Random();
        int[] vetor = new int[Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " o tamanho do vetor"))];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt();
        }
        JOptionPane.showConfirmDialog(null, "A soma dos elementos do vetor é "
                + soma(vetor, vetor.length));
    }

    private static int soma(int[] vetor, int n) {
        if (n == 1) {
            return vetor[0];
        } else {
            return vetor[n - 1] + soma(vetor, n - 1);
        }
    }

}
