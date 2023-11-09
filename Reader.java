import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public Amostra[] readDataSet() {
        Amostra amostras[] = new Amostra[272];
        double input[] = new double[7];
        double output[] = new double[3];

        try {
            FileReader file = new FileReader("ecoli.data");
            BufferedReader fr = new BufferedReader(file);
            String line;
            int amostra = 0;
            while ((line = fr.readLine()) != null) {
                String[] s = line.split("\\s+");
               
                for(int i=1; i<s.length; i++){
                    if(i==(s.length-1)){
                        switch(s[i]){
                            case "cp":
                                output[0]=0.995;
                                output[1]=0.005;
                                output[2]=0.005;
                                break;
                            case "pp":
                                output[0]=0.005;
                                output[1]=0.995;
                                output[2]=0.005;
                                break;
                            case "im":
                                output[0]=0.005;
                                output[1]=0.005;
                                output[2]=0.995;
                                break;
                        }
                    }else{
                        input[i-1] = Double.parseDouble(s[i]);
                    }
                }
                amostras[amostra] = new Amostra(input, output);
                amostra++;
            }

            file.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        normalizer(amostras);
        return amostras;
    }

    private void normalizer(Amostra[] amostras) {        
        for(int x=0; x<amostras[0].input.length; x++){
            
            int imax=0, imin=0;
            
            for(int i=1; i<amostras.length; i++){
                if(amostras[imax].input[x]<amostras[i].input[x]) imax = i;
                if(amostras[imin].input[x]>amostras[i].input[x]) imin = i;
            }
            float xmin = (float)amostras[imin].input[x];
            float xmax = (float)amostras[imax].input[x];
            if(xmin != xmax){
                if(xmin == 0) xmin = 0.005f;
                
                for(int i=0; i<amostras.length; i++){
                    amostras[i].input[x] = (amostras[i].input[x]-xmin)/(xmax-xmin);
                }
            }
        }
    }
}
