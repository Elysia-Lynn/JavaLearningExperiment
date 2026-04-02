import java.util.Scanner;
//我已崩溃，用useDelimiter的话要输入像1,1,这样的，结尾那个,不能省，不然Java会一直等你，它会以为,才是结束的点然后忽略那个回车键
public class test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /*scanner.useDelimiter(",");
        double temp=scanner.nextDouble();
        double pace=scanner.nextDouble();*/
        //以下提供一种工业界的更稳健的做法
        String input=scanner.nextLine();
        String[] parts=input.split(",");
        double temp=Double.parseDouble(parts[0].trim());
        double pace=Double.parseDouble(parts[1]);
        //工业界做法结束
        CalculateWindSpeed calculateWindSpeed=new CalculateWindSpeed(temp,pace);
        boolean flag=calculateWindSpeed.typematch();
        if(flag==false){
            System.out.println("温度为"+temp+"，温度需要在 [-58F,41F]之间。风速为"+pace+"，风速需大于等于2mph。");
        }
        else{
            double twc=calculateWindSpeed.calculate();
            String result=String.format("%.2f",twc);
            System.out.println("温度为"+temp+"，风速为"+pace+"，风寒温度为"+result);
        }
        System.out.println("程序结束");
        scanner.close();
    }
}

class CalculateWindSpeed{
    private final double temp;
    private final double pace;
    public CalculateWindSpeed(double temp,double pace){
        this.temp=temp;
        this.pace=pace;
    }
    public boolean typematch(){
        boolean flag=true;
        if(temp<-58||temp>41)
            flag=false;
        else if (pace<2) {
            flag=false;
        }
        return flag;
    }
    public double calculate(){
        double power=Math.pow(pace,0.16);
        return 35.74 + 0.6215 * temp - 35.75 * power + 0.4275 * temp *power;
    }
}

class testbug{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in).useDelimiter(",");
        System.out.println("我们成功输入了");
        //scanner.useDelimiter(",");
        System.out.println("我们用了分隔符");
        int a=scanner.nextInt();
        System.out.println("我们成功得到了a");
        int b=scanner.nextInt();
        System.out.println("我们成功得到了a和b");
        System.out.println(a+b);
        scanner.close();
    }
}