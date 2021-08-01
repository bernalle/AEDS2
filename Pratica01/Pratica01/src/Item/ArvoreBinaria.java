package Item;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ArvoreBinaria
{
    public int contadorComparacoes;
    private static class No
    {
        Item reg;
        No esq, dir;
    }

    private No raiz;

    //para inicializar o nó raiz
    public ArvoreBinaria()
    {
        this.raiz = null;
    }

    //para inserir o elemento reg passado por parâmetro
    public void insere (Item reg)
    {
        this.raiz = this.insere (reg, this.raiz);
    }

    private No insere(Item reg, No p)
    {
        if (p == null)
        {
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
        }
        else if (reg.compara (p.reg) < 0)
            p.esq = insere (reg, p.esq);
        else if (reg.compara (p.reg) > 0)
            p.dir = insere (reg, p.dir);
        else System.out.println("Erro: Registro ja existente");
        return p;
    }

    //Buscando elemento reg passado por parâmetro
    public Item pesquisa(Item reg){
        return this.pesquisa(reg, this.raiz);
    }

    private Item pesquisa(Item reg, No p){
        if (p == null)
        {
            return null; //Registro não encontrado
        }
        else if (reg.compara (p.reg) < 0)
        {
            contadorComparacoes ++;
            return pesquisa(reg, p.esq);
        }
        else if (reg.compara (p.reg) > 0)
        {
            contadorComparacoes ++;
            return pesquisa(reg, p.dir);
        }
        else return p.reg;
    }

    // Implementando Algoritmo de Fisher–Yates 
    static void shuffleArray(int[] ar){
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

    //ORDENADA
    public static void main(String[] args){
        int qtdElementos[] = {0,1000,2000,3000,4000,5000,6000,7000,8000,9000};
        int itemEscolhido;

        for (int j = 0; j < 9; j++){
            //gera um vetor de j[i] elementos
            int [] vetor = new int[qtdElementos[j + 1]];
            for (int a = 0; a < vetor.length; a++) vetor[a] = a + 1;
           
            ArvoreBinaria arvore = new ArvoreBinaria();
            //insere cada um dos elementos da vetor na arvore criada
            for (int i = 0; i < qtdElementos[j + 1]; i++){
                Item novoItem = new Item(vetor[i]);
                arvore.insere(novoItem);
            }
    
            //Busca valor inexistente
            int min = qtdElementos[j + 1];
            int max = qtdElementos[j + 1] + 1000;
            int var = ThreadLocalRandom.current().nextInt(min, max + 1);
            itemEscolhido = (var);
            Item itemAPesquisar = new Item(itemEscolhido);
            
              //mede o tempo gasto na pesquisa
            long startTime = System.nanoTime();
            arvore.pesquisa(itemAPesquisar);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
    
            System.out.println("Item pesquisado: " + itemAPesquisar.getChave() + "\n");
            System.out.println("Intervalo: " + (j * 1000) + " a " + ((j+1) * 1000) + "\n");
            System.out.println("Comparações realizadas: " + arvore.contadorComparacoes + "\n");
            System.out.println("Tempo gasto: " + totalTime + " milissegundos" + "\n\n");
        }
    }
/*
    //ALEATÓRIA
    public static void main(String[] args){
        
        int qtdElementos[] = {0,1000,2000,3000,4000,5000,6000,7000,8000,9000};
        int itemEscolhido;

        for (int j = 0; j < 9; j++){
            //gera um vetor de j[i] elementos
            int [] vetor = new int[qtdElementos[j + 1]];
            
            for (int a = 0; a < vetor.length; a++) vetor[a] = a + 1;
         
            shuffleArray(vetor);
            ArvoreBinaria arvore = new ArvoreBinaria();
            
            //insere cada um dos elementos da vetor na arvore criada
            for (int i = 0; i < qtdElementos[j + 1]; i++) {
                Item novoItem = new Item(vetor[i]);
                arvore.insere(novoItem);
            }
            
            //Busca valor inexistente
            int min = qtdElementos[j + 1];
            int max = qtdElementos[j + 1] + 1000;
            int var = ThreadLocalRandom.current().nextInt(min, max + 1);
            itemEscolhido = (var);
            Item itemAPesquisar = new Item(itemEscolhido);
            
            //mede o tempo gasto na pesquisa
            long startTime = System.nanoTime();
            arvore.pesquisa(itemAPesquisar);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            
            System.out.println("Item pesquisado: " + itemAPesquisar.getChave() + "\n");
            System.out.println("Intervalo: " + (j * 1000) + " a " + ((j+1) * 1000) + "\n");
            System.out.println("Comparações realizadas: " + arvore.contadorComparacoes + "\n");
            System.out.println("Tempo gasto: " + totalTime + " milissegundos" + "\n\n");
        }
    }
*/
}