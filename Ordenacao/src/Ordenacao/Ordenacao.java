package Ordenacao;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ordenacao {

    public static void main(String[] args) {
        int n = 5000;
        int v[] = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = i + 1;
        }
        
        embaralha(v);
        
        int[] vetorEmbaralhado = v.clone();
        long tempoInicial = System.nanoTime();
        bubbleSort(vetorEmbaralhado);
        long tempoFinal = System.nanoTime();
        System.out.println("Bubble iterativo: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        bubbleSortOtimizado(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Bubble otimizado: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        oddEvenSort(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Odd Even: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        cocktailSort(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("CockTail: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        insertionSort(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Insertion: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        //na chamada do shellsort precisa do vetor e também o vetor.length como 
        //parâmetro
        shellSort(vetorEmbaralhado, vetorEmbaralhado.length);
        tempoFinal = System.nanoTime();
        System.out.println("ShellSort: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        selectionSort(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Selection Sort: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        //merge precisa do vetor, 0 e também o tamanho do verto - 1
        mergeSort(vetorEmbaralhado, 0,vetorEmbaralhado.length - 1);
        tempoFinal = System.nanoTime();
        System.out.println("Selection Sort: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        mergeSortIterativo(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Merge Iterativo: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        //precisa do vetor, 0 e tamanho do vetor -1
        quickSort(vetorEmbaralhado, 0, vetorEmbaralhado.length-1);
        tempoFinal = System.nanoTime();
        System.out.println("Quick: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
        
        vetorEmbaralhado = v.clone();
        tempoInicial = System.nanoTime();
        heapSort(vetorEmbaralhado);
        tempoFinal = System.nanoTime();
        System.out.println("Heap: " + (tempoFinal - tempoInicial)
        + "ns" + "-" + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial)
                , TimeUnit.NANOSECONDS)+ "ms");
    }
    
    private static void embaralha(int[] embaralhado) {
        Random random = new Random();
        int elementosRestantes = embaralhado.length;
        while (elementosRestantes > 0) {
            int k = random.nextInt(elementosRestantes);

            int temp = embaralhado[k];
            embaralhado[k] = embaralhado[elementosRestantes - 1];
            embaralhado[elementosRestantes - 1] = temp;

            elementosRestantes--;
        }
    }
    
    static void swap(int v[], int a, int b) {
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }
    //verificador de ordenação
    static boolean isOrdered(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    //código bubbleSort - normal
    static void bubbleSort(int[] vetor) {
        for (int i = vetor.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    swap(vetor, j, j + 1);
                }
            }
        }
    }
    
    //código BubbleSort - Otimizado
    static void bubbleSortOtimizado(int[] vetor) {
        boolean ordenado = false;
        for (int i = vetor.length - 1; i >= 0 && !ordenado; i--) {
            ordenado = true;
            for (int j = 0; j < i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    swap(vetor, j, j + 1);
                    ordenado = false;
                }
            }
        }
    }
    
    //Bubblesort - Recursivo
    static void bubbleSortRecursivo(int[] vetor, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                swap(vetor, i, i + 1);
            }
            bubbleSortRecursivo(vetor, n - 1);
        }
    }
    
    //Código OddEven
    static void oddEvenSort(int[] vetor) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < vetor.length - 1; i += 2) {
                if (vetor[i] > vetor[i + 1]) {
                    swap(vetor, i, i + 1);
                    sorted = false;
                }
            }
            for (int i = 0; i < vetor.length - 1; i += 2) {
                if (vetor[i] > vetor[i + 1]) {
                    swap(vetor, i, i + 1);
                    sorted = false;
                }
            }
        }
    }
    
    //Código cocktailSort
    static void cocktailSort(int[] vetor) {
        int n = 0;
        int m = vetor.length - 1;
        while (n <= m) {
            for (int i = n; i < m; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    swap(vetor, i, i + 1);
                }
            }
            m--;
            for (int j = m; j > n; j--) {
                if (vetor[j] < vetor[j - 1]) {
                    swap(vetor, j, j - 1);
                }
            }
            n++;
        }
    }
    
    //insertionSort - normal
    static void insertionSort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i; j > 0; j--) {
                if (vetor[j] < vetor[j - 1]) {
                    swap(vetor, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    
    //código insertionSort - recursivo
    static void insertionSortRecursivo(int[] vetor, int n) {
        if (n > 1) {
            insertionSortRecursivo(vetor, n - 1);
        }
        for (int i = n - 1; i > 0; i--) {
            if (vetor[i] < vetor[i - 1]) {
                swap(vetor, i, i - 1);
            } else {
                break;
            }
        }
    }
    //código shellSort
    static void shellSort(int[] vetor, int n) {
        int i, j, aux, h = 1;
        do {
            h = h * 3 + 1;
        } while (h < n);
        do {
            h /= 3;
            for (i = h; i < n; i++) {
                aux = vetor[i];
                j = i;
                while (vetor[j - h] > aux) {
                    vetor[j] = vetor[j - h];
                    j -= h;
                    if (j < h) {
                        break;
                    }
                }
                vetor[j] = aux;
            }
        } while (h != 1);
    }
    //selection - normal
    static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            swap(vetor, i, menor);
        }
    }
    //selection - recursivo
    static void selectionSortRecursivo(int[] vetor, int m) {
        if (m < vetor.length - 1) {
            int menor = m;
            for (int i = m + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[menor]) {
                    menor = i;
                }
            }
            swap(vetor, m, menor);
            selectionSortRecursivo(vetor, m + 1);
        }
    }
    //continuação
    static void mergeSort(int[] vetor, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(vetor, p, q);
            mergeSort(vetor, q + 1, r);
            merge(vetor, p, q, r);
        }
    }
    //metodo merge
    static void merge(int[] vetor, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] aux1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            aux1[i] = vetor[i + p];
        }
        int[] aux2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            aux2[i] = vetor[i + q + 1];
        }
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i == n1) {
                vetor[k] = aux2[j++];
            } else if (j == n2) {
                vetor[k] = aux1[i++];
            } else if (aux1[i] < aux2[j]) {
                vetor[k] = aux1[i++];
            } else {
                vetor[k] = aux2[j++];
            }
        }
    }
    //merge - normal
    public static void mergeSortIterativo(int[] vetor) {
        int p, r;
        int b = 1;
        while (b < vetor.length) {
            p = 0;
            while (p + b < vetor.length) {
                r = p + 2 * b;
                if (r > vetor.length) {
                    r = vetor.length;
                }
                merge(vetor, p, p + b - 1, r - 1);
                p = p + 2 * b;
            }
            b = b * 2;
        }
    }
    //quick e sua construção
    static void quickSort(int[] vetor, int p, int r) {
        if (p < r) {
            int q = partition(vetor, p, r);
            quickSort(vetor, p, q - 1);
            quickSort(vetor, q + 1, r);
        }
    }

    static int partition(int[] vetor, int p, int r) {
        int q = p;
        for (int i = p; i < r; i++) {
            if (vetor[i] <= vetor[r]) {
                swap(vetor, q, i);
                q++;
            }
        }
        swap(vetor, q, r);
        return q;
    }
    //heap sort e sua construção abaixo
    static void heapSort(int[] vetor) {
        buildMaxHeap(vetor, vetor.length);
        int n = vetor.length;
        for (int i = n - 1; i >= 1; i--) {
            swap(vetor, 0, i);
            n--;
            maxHeapfy(vetor, n, 0);
        }
    }

    static void buildMaxHeap(int[] vetor, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapfy(vetor, n, i);
        }
    }

    static void maxHeapfy(int[] vetor, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maior;
        if (left < n && vetor[left] > vetor[i]) {
            maior = left;
        } else {
            maior = i;
        }
        if (right < n && vetor[right] > vetor[maior]) {
            maior = right;
        }
        if (maior != i) {
            swap(vetor, i, maior);
            maxHeapfy(vetor, n, maior);
        }
    }

}
