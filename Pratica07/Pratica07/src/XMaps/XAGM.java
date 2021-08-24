package XMaps;

public class XAGM {
    private int antecessor[];
    private double p[];
    private XGrafo grafo;
    public XAGM(XGrafo grafo) { //recebe no construtor elemento tipo grafo
        this.grafo = grafo;
    }
    
    public void obterArvoreCMC(int raiz) throws Exception { //metodo para encontar o caminho minimo
        int n = this.grafo.numVertices(); //cria um int com o tamanho do numero vertices do grafo recebido
        this.p = new double[n]; // peso dos vértices
        int vs[] = new int[n + 1]; // vértices
        this.antecessor = new int[n];
     
        for (int u = 0; u < n; u++) {
            this.antecessor[u] = -1;
            p[u] = Double.MAX_VALUE; // ∞
            vs[u + 1] = u; // Heap indireto a ser construído
        }
    
        p[raiz] = 0;
        FPHeapMinIndireto heap = new FPHeapMinIndireto(p, vs);
        heap.constroi();
        
        while (!heap.vazio()) {
            int u = heap.retiraMin();
            if (!this.grafo.listaAdjVazia(u)) { //enquanto nao estiver vazio o grafo continua fazendo comparações entre os pesos dos vertices 
                XGrafo.Aresta adj = grafo.primeiroListaAdj(u);
                while (adj != null) {
                    int v = adj.v2();
                    // imprimePeso(u,adj.peso());
                    //  System.out.println("peso: "+ adj.peso());
                    
                    if (this.p[v] > (this.p[u] + adj.peso())) {
                        antecessor[v] = u;
                        heap.diminuiChave(v, this.p[u] + adj.peso());
                    }
           
                    adj = grafo.proxAdj(u);
                }
            }
        }
    }
        
    public int antecessor(int u) {
        return this.antecessor[u];
    }
    
    public double peso(int u) { // o peso de cada caminho, no caso a distancia ou o tempo
        return this.p[u];
    }
    
    public void imprimeCaminho(int origem, int v) { //faz impressão se encontar, ou não, os caminhos minimos
        if (origem == v) {
            System.out.println(origem);
        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho de " + origem + " ate " + v);
        } else {
            imprimeCaminho(origem, this.antecessor[v]); 
            //System.out.println(this.peso(this.antecessor[v]));
            System.out.println(v);
        }
    }
}
