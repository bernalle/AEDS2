package src;

public class Main {
    public static void main(String[] args) throws Exception {
        
    //  XGrafo grafo = new XGrafo(8);
    XGrafo grafo = new XGrafo(10);
    
//inserindo arestas no grafo 1 da atv 3
//        grafo.insereAresta(0, 1, 1);
//        grafo.insereAresta(0, 4, 1);
//        grafo.insereAresta(0, 3, 1);
//        grafo.insereAresta(1, 0, 1);
//        grafo.insereAresta(1, 2, 1);
//        grafo.insereAresta(1, 5, 1);
//        grafo.insereAresta(2, 1, 1);
//        grafo.insereAresta(2, 6, 1);
//        grafo.insereAresta(2, 3, 1);
//        grafo.insereAresta(3, 2, 1);
//        grafo.insereAresta(3, 7, 1);
//        grafo.insereAresta(3, 0, 1);
//        grafo.insereAresta(4, 0, 1);
//        grafo.insereAresta(4, 7, 1);
//        grafo.insereAresta(4, 5, 1);
//        grafo.insereAresta(5, 4, 1);
//        grafo.insereAresta(5, 6, 1);
//        grafo.insereAresta(5, 1, 1);
//        grafo.insereAresta(6, 2, 1);
//        grafo.insereAresta(6, 5, 1);
//        grafo.insereAresta(6, 7, 1);
//        grafo.insereAresta(7, 4, 1);
//        grafo.insereAresta(7, 3, 1);
//        grafo.insereAresta(7, 6, 1);
        
//inserindo arestas no grafo 2 da atv 3
        
        grafo.insereAresta(9, 6, 1);
        grafo.insereAresta(0, 5, 1);
        grafo.insereAresta(0, 2, 1);
        grafo.insereAresta(0, 3, 1);
        grafo.insereAresta(5, 4, 1);
        grafo.insereAresta(5, 6, 1);
        grafo.insereAresta(1, 2, 1);
        grafo.insereAresta(2, 4, 1);
        grafo.insereAresta(2, 3, 1);
        grafo.insereAresta(4, 6, 1);
        grafo.insereAresta(6, 8, 1);
        grafo.insereAresta(7, 8, 1);
        //imprimindo grafo para teste
        grafo.imprime();
        //criando o objeto de ciclo e buscando em profundidade se é ciclo ou não
        XCiclo busca = new XCiclo(grafo);
        busca.buscaEmProfundidade();
        System.out.println();
        if(busca.isCiclo() == true) System.out.println("É Cíclico !");
        else System.out.println("Não é Cíclico !");
    }   
}
