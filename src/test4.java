import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        FindPlace findPlace=new FindPlace(num);
        boolean flag=findPlace.test();
        if(!flag)
            System.out.println("票号必须在1~36之间");
        else {
            findPlace.findIt();
        }
        sc.close();
    }
}

class FindPlace {
    private int num = 0;

    public FindPlace(int num){
        this.num=num;
    }

    public boolean test(){
        boolean flag=true;
        if(num<1||num>36)
            flag=false;
        return flag;
    }

    public void findIt(){
        int carrige=num/4+1;
        int left=num%4;
        if(left==1)
            System.out.println("("+carrige+"，左、下铺)");
        else if(left==2)
            System.out.println("("+carrige+"，左、上铺)");
        else if (left==3) {
            System.out.println("("+carrige+"，右、下铺)");
        }
        else{
            carrige--;
            System.out.println("("+carrige+"，右、上铺)");
        }
    }
}
