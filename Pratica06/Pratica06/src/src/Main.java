package src;

public class Main {

    public static void main(String[] args) throws Exception {
        XGrafo grafo = new XGrafo(10);
        
//Grafo 1 
//        grafo.insereAresta(1, 2, 5); //A--B
//        grafo.insereAresta(1, 7, 10); //A--G
//        grafo.insereAresta(1, 4, 10); //A--D
//        grafo.insereAresta(1, 5, 5); //A--E
//        grafo.insereAresta(1, 8, 10); //A--H
//        grafo.insereAresta(2, 1, 5); //B--A
//        grafo.insereAresta(2, 8, 5); //B--H
//        grafo.insereAresta(2, 6, 5); //B--F
//        grafo.insereAresta(2, 9, 10); //B--K
//        grafo.insereAresta(3, 5, 10); //C--E
//        grafo.insereAresta(3, 4, 5); //C--D
//        grafo.insereAresta(3, 7, 5); //C--G
//        grafo.insereAresta(4, 3, 5); //D--C
//        grafo.insereAresta(4, 7, 10); //D--G
//        grafo.insereAresta(4, 5, 5); //D--E
//        grafo.insereAresta(4, 1, 10); //D--A
//        grafo.insereAresta(5, 4, 5); //E--D
//        grafo.insereAresta(5, 1, 5); //E--A
//        grafo.insereAresta(5, 3, 10); //E--C
//        grafo.insereAresta(5, 9, 10); //E--D
//        grafo.insereAresta(6, 2, 5); //F--B
//        grafo.insereAresta(6, 7, 15); //F--G
//        grafo.insereAresta(7, 6, 15); //G--F
//        grafo.insereAresta(7, 1, 10); //G--A
//        grafo.insereAresta(7, 4, 10); //G--D
//        grafo.insereAresta(7, 3, 5); //G--C
//        grafo.insereAresta(8, 1, 10); //H--A
//        grafo.insereAresta(8, 2, 5); //H--B
//        grafo.insereAresta(8, 9, 20); //H--K
//        grafo.insereAresta(9, 8, 20); //K--H
//        grafo.insereAresta(9, 2, 10); //K--B
//        grafo.insereAresta(9, 5, 10); //K--E
        
//Grafo 2  
        grafo.insereAresta(1, 2, 8); //1--2
        grafo.insereAresta(1, 3, 2); //1--3
        grafo.insereAresta(1, 7, 9); //1--7
        grafo.insereAresta(2, 1, 8); //2--1
        grafo.insereAresta(2, 3, 3); //2--3
        grafo.insereAresta(2, 4, 2); //2--4
        grafo.insereAresta(2, 5, 7); //2--5
        grafo.insereAresta(2, 6, 5); //2--6
        grafo.insereAresta(2, 8, 6); //2--8
        grafo.insereAresta(3, 1, 2); //3--1
        grafo.insereAresta(3, 2, 3); //3--2
        grafo.insereAresta(3, 4, 9); //3--4
        grafo.insereAresta(3, 7, 6); //3--7
        grafo.insereAresta(4, 3, 9); //4--3
        grafo.insereAresta(4, 2, 2); //4--2
        grafo.insereAresta(4, 5, 6); //4--5
        grafo.insereAresta(4, 7, 2); //4--7
        grafo.insereAresta(5, 4, 6); //5--4
        grafo.insereAresta(5, 2, 7); //5--2
        grafo.insereAresta(5, 6, 5); //5--6
        grafo.insereAresta(5, 7, 4); //5--7
        grafo.insereAresta(6, 5, 5); //6--5
        grafo.insereAresta(6, 2, 5); //6--2
        grafo.insereAresta(6, 7, 6); //6--7
        grafo.insereAresta(6, 8, 4); //6--8
        grafo.insereAresta(7 ,6, 6); //7--6
        grafo.insereAresta(7 ,1, 9); //7--1
        grafo.insereAresta(7 ,3, 6); //7--3
        grafo.insereAresta(7 ,4, 2); //7--4
        grafo.insereAresta(7 ,5, 4); //7--5
        grafo.insereAresta(7 ,8, 3); //7--8
        grafo.insereAresta(8 ,7, 3); //8--7
        grafo.insereAresta(8 ,2, 6); //8--2
        grafo.insereAresta(8 ,6, 4); //8--6 
        //imprime os antecessores de cada aresta e seu peso e depois a soma dos pesos (peso da arvore)
        grafo.imprime();    
        XAGM arvore = new XAGM(grafo);
        arvore.obterAgm(1);
        arvore.imprime();
    }   
}
