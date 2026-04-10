import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=0;
        int n=0;
        while(true) {
            String input = sc.nextLine();
            String[] parts = input.split("\\s*,\\s*");
            m = Integer.parseInt(parts[0]);
            n = Integer.parseInt(parts[1]);
            while (n % 2 != 0) {
                System.out.println("脚数必须为偶数，请重新输入!");
                //这是一种反复输入的手段
                n = sc.nextInt();
                sc.nextLine();
            }
            if(n<2*m||n>4*m){
                //这是另一种
                System.out.println("脚数必须>=2倍的只数，且<=4倍的只数，请重新输入!");
                continue;
            }
            break;
        }
        for(int i=0;i<=m;i++){
                int j=(n-4*i)/2;
                if(i+j==m)
                System.out.println("鸡的数量为"+j+"，兔的数量为"+i);
                else
                    continue;
                break;
        }
    }
}
