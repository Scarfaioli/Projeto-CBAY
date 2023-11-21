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
        // cada classe precisa de para cada um dos 5 atributos, 2 valores media[0] e desvio padrao[1]
        double[][] c1 = new double[5][2];
        double[][] c2 = new double[5][2];
        double[][] c3 = new double[5][2];
        
        //calcular média e desvio padrão
        medSig(c1, Arrays.copyOfRange(amostras, 0, 100));
        medSig(c2, Arrays.copyOfRange(amostras, 143, 197));
        medSig(c3, Arrays.copyOfRange(amostras, 220, 256));

        //Verificar o modelo com os demais elementos de teste
        //elementos classe1
        int errClas = 0;
        for (int i = 100; i < 143; i++) {
            double pc1x = probBayes(amostras[i], c1, 143);
            double pc2x = probBayes(amostras[i], c2, 77);
            double pc3x = probBayes(amostras[i], c3, 52);
            
            if(pc1x >= pc2x && pc1x >= pc3x && amostras[i].output[0] != 0){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc2x >= pc1x && pc2x >= pc3x && amostras[i].output[0] != 1){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc3x >= pc1x && pc3x >= pc2x && amostras[i].output[0] != 2){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }

        }
        //elementos classe2
        for (int i = 197; i < 220; i++) {
            double pc1x = probBayes(amostras[i], c1, 143);
            double pc2x = probBayes(amostras[i], c2, 77);
            double pc3x = probBayes(amostras[i], c3, 52);

            if(pc1x >= pc2x && pc1x >= pc3x && amostras[i].output[0] != 0){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc2x >= pc1x && pc2x >= pc3x && amostras[i].output[0] != 1){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc3x >= pc1x && pc3x >= pc2x && amostras[i].output[0] != 2){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }
        }
        //elementos classe3
        for (int i = 256; i < amostras.length; i++) {
            double pc1x = probBayes(amostras[i], c1, 143);
            double pc2x = probBayes(amostras[i], c2, 77);
            double pc3x = probBayes(amostras[i], c3, 52);

            if(pc1x >= pc2x && pc1x >= pc3x && amostras[i].output[0] != 0){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc2x >= pc1x && pc2x >= pc3x && amostras[i].output[0] != 1){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }else if(pc3x >= pc1x && pc3x >= pc2x && amostras[i].output[0] != 2){
                errClas++;
                System.out.println("Erro de classificação "+errClas);
            }
        }
    }

    private static double probBayes(Amostra amostra, double[][] classeX, int qnt) {
        double pcX = qnt/272f;
        double pxcX = 1;
        
        for (int i = 1; i < classeX.length; i++) {
            pxcX *= (1/(classeX[i][1]*Math.sqrt(2*Math.PI)))*Math.pow(Math.E,-(Math.pow(amostra.input[i]-classeX[i][0],2)/(2*classeX[i][1])));
        }
        return 0;
    }

    private static void medSig(double[][] classeX, Amostra[] amostras) {
        for (int i = 0; i < classeX.length; i++) {
            classeX[i][0] = 0;
            classeX[i][1] = 0;
            for (int j = 0; j < amostras.length; j++) {
                classeX[i][0] += (amostras[j].input[i])/amostras.length;
            }
            for (int j = 0; j < amostras.length; j++) {
                classeX[i][1] += Math.pow(amostras[j].input[i]-classeX[i][0], 2)/amostras.length;
            }
            classeX[i][1] = Math.sqrt(classeX[i][1]);
        }
    }

}