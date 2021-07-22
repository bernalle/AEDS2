package arvorePatricia;
import extraiPalavra.ExtraiPalavra;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestaArvorePatricia{
    public static void main (String[] args) throws Exception {
        ArvorePatricia dicionario = new ArvorePatricia (128);
    
        ExtraiPalavra palavras = new ExtraiPalavra ("/home/gabrielbernalle/Área de trabalho/Códigos/AEDS2/Tp01/src/arvorePatricia/examples/delimitador.txt","/home/gabrielbernalle/Área de trabalho/Códigos/AEDS2/Tp01/src/arvorePatricia/examples/Exemplo1.txt");
        
//       Esta parte está pegando as palavras do arquivo passado acima e salvando em um Array List
//       cuja a chave será "palvaraN" sendo N o número de acordo com a entrada.
        
        
        List<String> palavra = new ArrayList<String>();

        int i = 0;
        palavra.add(palavras.proximaPalavra());
     	
        for (; ;i++){
            if(palavra.get(i) == null) break;                        
            palavra.add(palavras.proximaPalavra());
            //System.out.println ("Palavra"+ (i++) +": " + palavra.get(i-1));  
//       Esta pegando certo e salvando dentro do ArrayList
//       Erro nos delimitadores 
        }
        
        for(i = 0; i< palavra.size();i++){
            if("".equals(palavra.get(i))){
                palavra.remove(i);
            }
        }
//       Erro nos delimitadores corrigido com essa instrução acima!!!        
        
//      INSTRUÇÃO PARA TESTAR SE FOI CERTO PARA ARRAYLIST
/*        for (i=0; ;){
            if(palavra.get(i) == null) break;                        
            
            System.out.println ("Palavra"+ (i++) +": " + palavra.get(i-1));  
        }
*/        
        palavras.fecharArquivos();  
            
        // toString adiciona um null no final do arquivo
        
        //System.out.println(palavra.toString());
        
        char c;
        
        // Insere cada chave na árvore
        for(i = 0; i < palavra.size()-1; i++){
            for(int j=0; j< palavra.get(i).length();j++){
                c = palavra.get(i).charAt(j);
                //System.out.println(c);
                dicionario.insere (c); 
                //System.out.println ("Inseriu chave"+ i + ": " + (int)c + " -- char:" + c);  
            }
        }
        
        //dicionario.imprime ();

        //Pesquisa palavra na árvore
        System.out.println("Qual palavra deseja Pesquisar?");
        Scanner ler = new Scanner(System.in);
        String recebe = ler.nextLine();
        
        for(i=0; i<recebe.length();i++){
            c=recebe.charAt(i);
            //System.out.println ("Pesquisando chave" + i + ": " + c);
            dicionario.pesquisa(c);
        }

    }
}

