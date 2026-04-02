import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    double x=sc.nextDouble();
    Calculate calculate=new Calculate(x);
    double y=calculate.calculatey();
    String result=String.format("%.2f",y);
    System.out.println(result);
    }
}

class Calculate{
    private double x;
    public Calculate(double x){
        this.x=-x;
    }
    public double calculatey(){
        return 1/(1+Math.exp(x));
    }
}
