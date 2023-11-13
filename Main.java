/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Reader rd = new Reader();
        Amostra[] amostras = rd.readDataSet();
        
        for (int i = 0; i < amostras.length; i++) {
            amostras[i].printAmostra();
        }
    }
}