import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Reader rd = new Reader();
        Amostra[] amostras = rd.readDataSet();
        List<Amostra> treinoC1 = new ArrayList<>();
        List<Amostra> treinoC2 = new ArrayList<>();
        List<Amostra> treinoC3 = new ArrayList<>();
        basesDistrib(amostras, treinoC1, treinoC2, treinoC3);
    }

    private static void basesDistrib(
        Amostra[] amostras, List<Amostra> treinoC1, List<Amostra> treinoC2, List<Amostra> treinoC3) {
        for (int i = 0; i < amostras.length; i++) {
            switch ((int)amostras[i].output[0]) {
                case 0:
                    treinoC1.add(amostras[i]);
                    break;
                case 1:
                    treinoC2.add(amostras[i]);
                    break;
                case 2:
                    treinoC3.add(amostras[i]);
                    break;
            }
        }
    }
}