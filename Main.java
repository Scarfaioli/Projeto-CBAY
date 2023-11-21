import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Reader rd = new Reader();
        Amostra[] amostras = rd.readDataSet();

        classificadorBayess(amostras);
    }

    private static void classificadorBayess(Amostra[] amostras) {
        // cada classe precisa de para cada um dos 5 atributos, 2 valores media e desvio padrao
        double[][] c1 = new double[5][2];
        double[][] c2 = new double[5][2];
        double[][] c3 = new double[5][2];
        
        //calcular média e desvio padrão
        medSig(c1, Arrays.copyOfRange(amostras, 0, 143));
        medSig(c2, Arrays.copyOfRange(amostras, 143, 220));
        medSig(c3, Arrays.copyOfRange(amostras, 220, 272));
    }

    private static void medSig(double[][] classeX, Amostra[] amostras) {
        for (int i = 0; i < classeX.length; i++) {
            for (int j = 0; j < amostras.length; j++) {
                
            }
        }
    }

}