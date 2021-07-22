package extraiPalavra;
import java.util.StringTokenizer;
import java.io.*;
public class ExtraiPalavra {
  private final BufferedReader arqDelim, arqTxt;
  private StringTokenizer palavras;
  private final String delimitadores;

  public ExtraiPalavra (String nomeArqDelim, String nomeArqTxt) 
  throws Exception {
    this.arqDelim = new BufferedReader (new FileReader (nomeArqDelim));
    this.arqTxt = new BufferedReader (new FileReader (nomeArqTxt));
    // Os delimitadores devem estar juntos em uma única linha do arquivo 
    this.delimitadores = arqDelim.readLine() + "\r\n";
    this.palavras = null;
  }  
  public String proximaPalavra () throws Exception{
    if (palavras == null || !palavras.hasMoreTokens()) {
      String linha = arqTxt.readLine();
      if (linha == null) return null; // Não quero que retorne null 
      this.palavras = new StringTokenizer (linha, this.delimitadores);
      if (!palavras.hasMoreTokens()) return ""; // Se for string vazia, vazio
    }
    return this.palavras.nextToken ();
  }  
  public void fecharArquivos () throws Exception {
    this.arqDelim.close(); 
    this.arqTxt.close();
  }
}
