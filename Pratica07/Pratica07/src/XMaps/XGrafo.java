package XMaps;

class XGrafo {
    //criando a classe aresta
    public static class Aresta {
//inicializando variaveis onde v1 e v2 são os vértices 1 e 2 respectivamente e peso é para atribuir um peso as ligações
        private int v1, v2, peso;
//construtores das variáveis.
        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }
        public int peso() {
            return this.peso;
        }
        public int v1() {
            return this.v1;
        }
        public int v2() {
            return this.v2;
        }
    }
    private int mat[][]; // pesos do tipo inteiro
    private int numVertices;
    private int pos[]; // posição atual ao se percorrer os adjs de um vértice v
//construtor do Grafo
    public XGrafo(int numVertices){
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }
//métodos que insere arestas, verifica se existe aresta, e verifica se a lista adjacente está vazia
    public void insereAresta(int v1, int v2, int peso) {
        this.mat[v1][v2] = peso;
    }
    public boolean existeAresta(int v1, int v2) {
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
// Retorna a primeira aresta que o vértice v participa ou null se a lista de adjacência de v for vazia
    public Aresta primeiroListaAdj(int v) {
        this.pos[v] = -1;
        return this.proxAdj(v);
    }
// Retorna a próxima aresta que o vértice v participa ou null se a lista de adjacência de v estiver no fim
    public Aresta proxAdj(int v) {
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices) && (this.mat[v][this.pos[v]] == 0)) {
            this.pos[v]++;
        }
        if (this.pos[v] == this.numVertices) {
            return null;
        } else {
            return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);
        }
    }
//método que retira uma aresta ou returna null caso ela não exista
    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == 0) {
            return null; // Aresta não existe
        } else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }
//método que imprime a matriz de vértices com 0 e 1 onde tem vertices
    public void imprime() {
        
        System.out.print("Grafo \n ");
        for(int i = 1; i < this.numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i < this.numVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    //metodo que retorna o numero de vertices de um grafo
    public int numVertices() {
        return this.numVertices;
    }
}
