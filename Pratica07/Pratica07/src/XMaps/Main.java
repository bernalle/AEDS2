package XMaps;

public class Main {
    public static void main(String[] args) throws Exception {        
        XGrafo grafo = new XGrafo(6); //Grafo1 distância
        XGrafo grafo2 = new XGrafo(6); //Grafo1 tempo     
//Grafo 1
//Distância
       grafo.insereAresta(1, 2, 8); 
       grafo.insereAresta(1, 3, 4); 
       grafo.insereAresta(1, 4, 5);      
       grafo.insereAresta(2, 5, 9);  
       grafo.insereAresta(3, 5, 5);         
       grafo.insereAresta(4, 2, 3);  
       grafo.insereAresta(4, 5, 2);         
//Tempo
       grafo2.insereAresta(1, 2, 3); 
       grafo2.insereAresta(1, 3, 10); 
       grafo2.insereAresta(1, 4, 2);  
       grafo2.insereAresta(2, 5, 5);        
       grafo2.insereAresta(3, 5, 2);        
       grafo2.insereAresta(4, 2, 8); 
       grafo2.insereAresta(4, 5, 7);        
       
        XAGM arvore = new XAGM (grafo);
        XAGM arvore2 = new XAGM (grafo2);
        System.out.println("Grafo1: ");
        arvore.obterArvoreCMC(1);
        System.out.println("Caminho: ");
        arvore.imprimeCaminho(1, 5);
        System.out.println("Menor distância: " + arvore.peso(5)+"\n");  
        arvore2.obterArvoreCMC(1);
        System.out.println("Caminho: ");
        arvore2.imprimeCaminho(1, 5);
        System.out.println("Menor tempo: " + arvore2.peso(5));
        System.out.println(" \n");
          
        XGrafo grafo3 =  new XGrafo(6);  //Grafo2 distância
        XGrafo grafo4 =  new XGrafo(6); //Grafo2 tempo
              
//Distância
       grafo3.insereAresta(1, 2, 3);  
       grafo3.insereAresta(1, 4, 5);  
       grafo3.insereAresta(2, 3, 2); 
       grafo3.insereAresta(2, 4, 2);  
       grafo3.insereAresta(3, 5, 2);         
       grafo3.insereAresta(4, 2, 3); 
       grafo3.insereAresta(4, 3, 5); 
       grafo3.insereAresta(4, 5, 9);        
       grafo3.insereAresta(5, 1, 6);  
       grafo3.insereAresta(5, 3, 4);  
//Tempo
       grafo4.insereAresta(1, 2, 3);  
       grafo4.insereAresta(1, 4, 5);         
       grafo4.insereAresta(2, 3, 6); 
       grafo4.insereAresta(2, 4, 2);       
       grafo4.insereAresta(3, 5, 2);        
       grafo4.insereAresta(4, 2, 1);  
       grafo4.insereAresta(4, 3, 4); 
       grafo4.insereAresta(4, 5, 6);        
       grafo4.insereAresta(5, 1, 3);  
       grafo4.insereAresta(5, 3, 7);  
       
       // A =1 , B=2 , C=3 , D=4, E=5
       
        XAGM arvore3 =  new XAGM(grafo3);
        XAGM arvore4 = new XAGM(grafo4); 
        System.out.println("Grafo 2: ");
        arvore3.obterArvoreCMC(4);
        System.out.println("Caminho: ");
        arvore3.imprimeCaminho(4, 1);
        System.out.println("Menor distância: " + arvore3.peso(1)+"\n");
        arvore4.obterArvoreCMC(4);
        System.out.println("Caminho: ");
        arvore4.imprimeCaminho(4, 1);
        System.out.println("Menor tempo: " + arvore4.peso(1));
        System.out.println("\n");
        
   
    }
}
