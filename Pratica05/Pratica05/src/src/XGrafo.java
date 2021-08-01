package src;

// Iniciando a classe XGrafo
public class XGrafo {
// Implementação da matriz de adjacência
    public static class Aresta{
//  Classe Aresta com os atributos v1,v2 e peso;
        private int v1,v2,peso;
        public Aresta(int v1, int v2, int peso){
//  Construtor para inicializar os atributos    
            this.v1 = v1; 
            this.v2 = v2; 
            this.peso = peso;
        }
//  Métodos para obter o valor dos atributos
        public int peso(){return this.peso;}
        public int v1(){return this.v1;}
        public int v2(){return this.v2;}
    }
    
//  Pesos das arestas;
    private int mat[][]; // pesos do tipo inteiro
//  Numero de vértices
    private int numVertices;
//  Atributo utilizado para percorrer a lista de adjacência de um dado vértice
    private int pos[]; // posição atual ao se percorre os adjs de um vértice v

//  Inicializa o Grafo com 0
    public XGrafo(int numVertices){
//      Instancialização de mat[][] e pos[];
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;

//  Inicialização de mat[][] e pos[];      
        for(int i = 0; i < this.numVertices; i++){
            for(int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0;
            this.pos[i] = -1;
        }
    }
//  Inserção de uma nova aresta em mat[][]
    public void insereAresta (int v1, int v2, int peso){
        this.mat[v1][v2] = peso;
    }
    
//  Verifica se existe uma aresta cujas incidências são passadas por parâmetro
    public boolean existeAresta (int v1, int v2){
        return (this.mat[v1][v2] > 0);
    }
    
    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v][i] > 0) {
                return false;
            }
        }
        return true;
    }
    
//  Retorna o primeiro objeto Aresta em que o parâmetro v participa
    public Aresta primeiroListaAdj (int v){
//  Retorna a primeira aresta que o vértice v participa
//  ou null se a lista de adjacência de v for vazia
        this.pos[v] = -1; // inicializa o percurso das adjacências de v
        return this.proxAdj(v);
    }
    
    public Aresta proxAdj(int v){
//  Retorna a próxima aresta que o vértice v participa ou
//  null se a lista de adjacência de v estiver no fim
        this.pos[v] ++; // posiciona p[] na próxima aresta a ser pesquisada
//      Verifica se p[v] é uma adjacência válida e se existe. Se não verifica
//      a próxima adjacência. Se for inválida, retorna null
//      caso contrário, retorna um objeto Aresta com a aresta procurada
        while((this.pos[v] < this.numVertices) && 
               this.mat[v][this.pos[v]] == 0) this.pos[v]++;
        if(this.pos[v] == this.numVertices) return null;
        else return new Aresta(v ,this.pos[v],this.mat[v][this.pos[v]]);
    }

//  Remoção de uma aresta em mat[][]
    public Aresta retiraAresta(int v1, int v2){
        if(this.mat[v1][v2] == 0) return null; //Aresta não encontrada
        else {
            Aresta aresta = new Aresta (v1,v2,this.mat[v1][v2]);
            this.mat[v1][v2]=0;
            return aresta;
        }
    }
    
//  Impressão de todas as arestas    
    public void imprime(){
        System.out.println(" ");
        System.out.print("  ");
        for(int i = 0;i < this.numVertices;i++) System.out.print(i + " ");
        System.out.println(" ");
        for(int i = 0;i < this.numVertices;i++){
            System.out.print(i + " ");
            for(int j = 0;j < this.numVertices; j++) System.out.print(this.mat[i][j] + " ");
            System.out.println();
        }
    }
  //metodo que retorna o numero de vertices de um grafo
    public int numVertices() {
        return this.numVertices;
    }        
}
