package POTA03.Q01;

import javax.swing.JOptionPane;

public class Q01 {

    public static void main(String[] args) {
        Produto vetor[] = new Produto[16];
        for (int i = 0; i < 10; i++) {
            String codigo = JOptionPane.showInputDialog("Digite o código: ");
            String descricao = JOptionPane.showInputDialog("Digite a descrição: ");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço: "));
            Produto p = new Produto(codigo, descricao, preco);
            vetor[i] = p;
        }
        
        String busca = JOptionPane.showInputDialog("Digite o código a ser localizado: ");
        int compSeq = buscaSequencial(vetor, busca);
        JOptionPane.showMessageDialog(null, "A quantidade de comparações realizadas na busca sequencial é: "+ compSeq);
        int compBin = buscaBinaria(vetor, busca);
        JOptionPane.showMessageDialog(null, "A quantidade de comparações realizadas na busca binária é: "+ compBin);
    }
    
    public static int buscaSequencial(Produto[] vetor, String k){
        int comparacoes = 0;
        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i].getCodigo().equals(k)) {
                break;                
            }
        }
        return comparacoes;
    }
    
    public static int buscaBinaria(Produto[] vetor, String k){
        int inicio = 0, fim = vetor.length - 1, centro;
        int comparacoes = 0;
        while(inicio<=fim){
            centro = inicio + (fim-inicio)/2;
            comparacoes++;
            if (vetor[centro].getCodigo().equals(k)){
                break;
            } else if (vetor[centro].getCodigo().compareTo(k)<0){
                inicio = centro + 1;
            } else {
                fim = centro -1;
            }
        }
        return comparacoes;
    }
}
