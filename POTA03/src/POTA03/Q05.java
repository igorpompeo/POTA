package POTA03;

public class Q05 {

    public static int buscaSequencial(int vet[], int n, int chave, int[] posicoes) {
        int cont = 0;
        for (int i = 0; i < n && vet[i] <= chave; i++) {
            if (vet[i] == chave) {
                posicoes[cont] = i;
                cont++;
            }
        }
        return cont;
    }

    private static int buscaBinaria(int vet[], int n, int chave, int posicoes[]) {
        int inicio = 0, fim = n - 1, centro;
        int cont = 0;
        while (inicio <= fim) {
            centro = inicio + (fim - inicio) / 2;
            if (chave == vet[centro]) {
                posicoes[cont] = centro;
                cont++;
                int i = centro - 1;
                while (vet[i] == chave) {
                    posicoes[cont] = i;
                    cont++;
                    i--;
                }
                i = centro + 1;
                while (vet[i] == chave) {
                    posicoes[cont] = i;
                    cont++;
                    i++;
                }
                break;
            } else if (chave > vet[centro]) {
                inicio = centro + 1;
            } else {
                fim = centro - 1;
            }
        }
        return cont;
    }

    public static void main(String[] args) {
        int[] vetor = {0, 1, 2, 2, 2, 3, 4, 4, 5};
        int[] resposta = new int[vetor.length];

        System.out.println(buscaSequencial(vetor, vetor.length, 2, resposta));
        for (int i = 0; i < resposta.length; i++) {
            System.out.println(resposta[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println(buscaBinaria(vetor, vetor.length, 2, resposta));
        for (int i = 0; i < resposta.length; i++) {
            System.out.println(resposta[i] + " ");
        }
        System.out.println();
    }

}
