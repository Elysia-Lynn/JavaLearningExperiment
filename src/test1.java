import java.util.InputMismatchException;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int volume=0;
        while(true) {
            try {
                volume = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数");
                scanner.nextLine();
            }
        }
        WaterRate waterRate=new WaterRate();
        double result=waterRate.calculateWaterBill(volume);
        System.out.printf("%.1f",result);
        scanner.close();
    }
}

class WaterRate{
    private final double bill1=2.3;
    private final double bill2=2.8;
    private final double bill3=3.6;
    private final int class1=10;
    private final int class2=25;
    public double calculateWaterBill(int water) {
        double result;
        if (water <= class1)
            result = water * bill1;
        else if (water <= class2) {
            result = class1 * bill1 + (water - class1) * bill2;
        } else
            result = class1 * bill1 + (class2 - class1) * bill2 + (water - class2) * bill3;
        return result;
    }
}
