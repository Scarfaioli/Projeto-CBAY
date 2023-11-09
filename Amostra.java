
public class Amostra {
    public double[] input;
    public double[] output;

    Amostra(double[] input, double[] output){
        this.input = input.clone();
        this.output = output.clone();
    }
    
    Amostra(){}

    public void printAmostra(){
        for(int i=0; i<input.length; i++){
            System.out.print(input[i]+" ");
        }
        System.out.println(output[0]+" "+output[1]+" "+output[2]);
    }
}
