package Item;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ArvoreSBB
{
    public int contadorComparacoes;
    private static class No
    {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }

    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private No raiz;
    private boolean propSBB;

    //para inicializar o nó raiz
    public ArvoreSBB()
    {
        this.raiz = null;
        this.propSBB = true;
    }

    private No ee(No ap)
    {
        No ap1 = ap.esq;
        ap.esq = ap1.dir;
        ap1.dir = ap;
        ap1.incE = Vertical;
        ap.incE = Vertical;
        ap = ap1;
        return ap;
    }
    private No ed(No ap) {
        No ap1 = ap.esq;
        No ap2 = ap1.dir;
        ap1.incD = Vertical;
        ap.incE = Vertical;
        ap1.dir = ap2.esq;
        ap2.esq = ap1;
        ap.esq = ap2.dir;
        ap2.dir = ap;
        ap = ap2;
        return ap;
    }
    private No dd(No ap)
    {
        No ap1 = ap.dir;
        ap.dir = ap1.esq;
        ap1.esq = ap;
        ap1.incD = Vertical;
        ap.incD = Vertical;
        ap = ap1;
        return ap;
    }
    private No de(No ap)
    {
        No ap1 = ap.dir;
        No ap2 = ap1.esq;
        ap1.incE = Vertical;
        ap.incD = Vertical;
        ap1.esq = ap2.dir;
        ap2.dir = ap1;
        ap.dir = ap2.esq;
        ap2.esq = ap;
        ap = ap2;
        return ap;
    }

    //para inserir o elemento reg passado por parâmetro
    public void insere (Item reg) {
        this.raiz = this.insere (reg, null, this.raiz, true);
    }

    private No insere(Item reg, No pai, No filho, boolean filhoEsq) {
        if (filho == null){
            
            filho = new No();
            filho.reg = reg;
            filho.incE = Vertical;
            filho.incD = Vertical;
            filho.esq = null;
            filho.dir = null;
            if (pai != null)
            {
                if (filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
            }
            this.propSBB = false;
        }
        else if (reg.compara (filho.reg) < 0) {
            filho.esq = insere (reg, filho, filho.esq, true);
            if (!this.propSBB)
                if (filho.incE == Horizontal) {
                    if (filho.esq.incE == Horizontal) {
                        filho = this.ee(filho); // transformação esquerda-direita
                        if (pai != null)
                            if (filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
                    }
                else if(filho.esq.incD == Horizontal) {
                    filho = this.ed(filho); // transformação esquerda-direta
                        if (pai != null)
                        if(filhoEsq) pai.incE = Horizontal;
                        else pai.incD = Horizontal;
                }
            }
            else this.propSBB = true;
        }
        else if (reg.compara (filho.reg) > 0) {
            filho.dir = insere (reg, filho, filho.dir, false);
            if (!this.propSBB)
                if (filho.incD == Horizontal) {
                    if (filho.dir.incD == Horizontal) {
                        filho = this.dd(filho); // transformação esquerda-direita
                        if (pai != null)
                            if (filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
                    }
                    else if(filho.dir.incE == Horizontal) {
                        filho = this.de(filho); // transformação esquerda-direta
                        if (pai != null)
                            if(filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
                    }
                }
                else this.propSBB = true;
        }
        else{
            System.out.println("Erro: Registro ja existente");
            this.propSBB = true;
        }
        return filho;
    }

    //Realizando a busca do elemento reg passado por parâmetro
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

    // Implementando o algoritmo Fisher–Yates 
    static void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    //ORDENADA
    public static void main(String[] args){
        
        int[] qtdElementos = {0,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        int itemEscolhido;

        for (int j = 0; j < 10; j++){
            //gera um vetor de j[i] elementos
            int [] vetor = new int[qtdElementos[j + 1]];
            
            for (int a = 0; a < vetor.length; a++) vetor[a] = a + 1;
            
            ArvoreSBB arvore = new ArvoreSBB();
            
            //insere cada um dos elementos da vetor na arvore criada
            for (int i = 0; i < qtdElementos[j + 1]; i++){
                Item novoItem = new Item(vetor[i]);
                arvore.insere(novoItem);
            }
            
            //Busca valor inexistente
            int min = qtdElementos[j + 1];
            int max = qtdElementos[j + 1] + 10000;
            
            int var = ThreadLocalRandom.current().nextInt(min, max + 1);
            itemEscolhido = (var);
            
            Item itemAPesquisar = new Item(itemEscolhido);
            
            //mede o tempo gasto na pesquisa
            long startTime = System.nanoTime();
            arvore.pesquisa(itemAPesquisar);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            
            
            System.out.println("Item pesquisado: " + itemAPesquisar.getChave() + "\n");
            System.out.println("Intervalo: " + (j * 10000) + " a " + ((j+1) * 10000) + "\n");
            System.out.println("Comparações realizadas: " + arvore.contadorComparacoes + "\n");
            System.out.println("Tempo gasto: " + totalTime + " milissegundos" + "\n\n");
        }
    }

    //ALEATÓRIA
/*    public static void main(String[] args)
    {
        int[] qtdElementos = {0,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        int itemEscolhido;

        for (int j = 0; j < 10; j++)
        {
            //gera um vetor de j[i] elementos
            int [] vetor = new int[qtdElementos[j + 1]];
            for (int a = 0; a < vetor.length; a++)vetor[a] = a + 1;
   
            shuffleArray(vetor);
            ArvoreSBB arvore = new ArvoreSBB();
            
            //insere cada um dos elementos da vetor na arvore criada
            for (int i = 0; i < qtdElementos[j + 1]; i++)
            {
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
