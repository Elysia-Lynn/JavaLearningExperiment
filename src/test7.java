import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        System.out.println("请输入一个五位数");
        Scanner sc = new Scanner(System.in);
        int integer = sc.nextInt();
        int[] digits=new int[5];
        int result=0;
        for(int i=0;integer!=0;integer/=10,i++){
            digits[i]=integer%10;
        }
        for(int i=4;i>=0;i--){
            result+=digits[i]*Math.pow(10,4-i);
        }
        System.out.println(result);
    }
}
