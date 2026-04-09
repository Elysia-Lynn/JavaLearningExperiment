import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"UTF-8");
        boolean membership=false;
        String haveMembership=sc.nextLine();
        if(haveMembership.equals("是"))
            membership=true;
        //这是一种很厉害的方式，它既保证换行输入又得到int类型
        //String getPrice=sc.nextLine();
        //int price=Integer.parseInt(getPrice);
        //这是另一种保证换行输入的同时得到int类型的方法
        int price=sc.nextInt();
        sc.nextLine();
        CountPrice countPrice=new CountPrice(price,membership);
        countPrice.price();
    }
}

class CountPrice{
    int price=0;
    boolean Membership=false;
    int originPrice=0;
    public CountPrice(int price,boolean haveMembership){
        this.price=price;
        this.Membership=haveMembership;
        this.originPrice=price;
    }
    public void price(){
        if(price>=3000) {
            price *= 0.9;
            System.out.println("discount by 0.9");
        }
        else if(price>=1000){
            price*=0.95;
            System.out.println("discount by 0.95");}
        if(Membership) {
            price *= 0.95;
            System.out.println("discount as a member");
        }
        System.out.println("该顾客购物金额为"+originPrice+"。买付金额为"+price+"。");
        return ;
    }
}

