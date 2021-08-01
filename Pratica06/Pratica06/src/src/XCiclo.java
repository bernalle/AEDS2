package src;

public class XCiclo {
//inicializando variáveis
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], t[], antecessor[];
    private XGrafo grafo;
    private boolean ciclo;
//métodos do booleano ciclo
    public boolean isCiclo() {
        return ciclo;
    }

    public void setCiclo(boolean ciclo) {
        this.ciclo = ciclo;
    }
// construtor das variáveis do método XCiclo
    public XCiclo(XGrafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }
//Visitado vértices e mudando a cor de branco (não visitado) para cinza (visitado) se já for cinza quer dizer que é ciclico
    private int visitaDfs(int u, int tempo, int cor[]) {
        cor[u] = cinza;
        this.d[u] = ++tempo;
        if (!this.grafo.listaAdjVazia(u)) {
            XGrafo.Aresta a = this.grafo.primeiroListaAdj(u);
            while (a != null) {
                int v = a.v2();
                if (cor[v] == cinza) {
                    this.ciclo = true;
                }
                if (cor[v] == branco) {

                    this.antecessor[v] = u;
                    tempo = this.visitaDfs(v, tempo, cor);
                }
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
        this.t[u] = ++tempo;
        return tempo;
    }
//realizando busca em profundidade de um vértice v
    public void buscaEmProfundidade() {
        int tempo = 0;
        int cor[] = new int[this.grafo.numVertices()];
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.numVertices(); u++) {
            if (cor[u] == branco) {
                tempo = this.visitaDfs(u, tempo, cor);
            }
        }
    }
    public int d(int v) {
        return this.d[v];
    }
    public int t(int v) {
        return this.t[v];
    }
    public int antecessor(int v) {
        return this.antecessor[v];
    }
}