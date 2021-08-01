package Item;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HeapSort {
    public int contadorComparacoes;

    public void sort(int arr[]) {
        int n = arr.length;

        // Construindo o Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extraindo elemento um por um
        for (int i = n - 1; i > 0; i--) {
            // Movendo para o fim
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Iniciando o maior como principal
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        contadorComparacoes++;

        // Se o left for maior que o principal
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Se o right for maior que o principal
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Se o maior não for o principal
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Algoritmo Fisher–Yates permutação
    static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    /* Percorre o vetor de forma contrária e salva em outro vetor*/
    static void vetorReverso(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++)
        {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }


    public static void main(String[] args)
    {
        int[] qtdElementos = {0,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};

        for (int j = 0; j < 10; j++)
        {
            //gera um vetor de j[i] elementos
            int [] vetor = new int[qtdElementos[j + 1]];
            for (int a = 0; a < vetor.length; a++)
            {
                vetor[a] = a + 1;
            }
            
            //vetorReverso(vetor, vetor.length);
            shuffleArray(vetor);
            HeapSort heap = new HeapSort();
            heap.sort(vetor);
            
            System.out.println("Intervalo: " + 0 + " a " + ((j+1) * 10000) + "\n");
            System.out.println("Comparações realizadas: " + heap.contadorComparacoes + "\n");
        }
    }

}