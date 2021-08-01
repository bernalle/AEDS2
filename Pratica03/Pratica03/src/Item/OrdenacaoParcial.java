package Item;

public class OrdenacaoParcial {

    public static void selecaoParcial ( Item v [ ] , int n, int k) {
        for ( int i = 1; i <= k ; i ++) {
            int min = i ;
            for ( int j = i + 1; j <= n ; j ++)
                if ( v [ j ] .compara ( v [min] ) < 0 ) min = j ;
            Item x = v [min ] ; v [min] = v [ i ] ; v [ i ] = x ;
        }
    }
}