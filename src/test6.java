import java.util.Scanner;

public class test6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        //在test2中关于如何在Java里进行,分割的两种方法，这里采取第三种方法：正则表达式
        String[] parts=input.split("\\s*,\\s*");
        int water=Integer.parseInt(parts[0]);
        int originTemp=Integer.parseInt(parts[1]);
        int finalTemp=Integer.parseInt(parts[2]);
        CalculateEnergy calculateEnergy=new CalculateEnergy(water,originTemp,finalTemp);
        calculateEnergy.calculate();
    }
}

class CalculateEnergy{
    private final int finalTemp;
    private final int originTemp;
    int water=0;
    public CalculateEnergy(int water,int originTemp,int finalTemp){
        this.water=water;
        this.originTemp=originTemp;
        this.finalTemp=finalTemp;
    }
    public void calculate(){
        int energy=water*(finalTemp-originTemp)*4184;
        System.out.println("将"+water+"kg的水从"+originTemp+"度加热到"+finalTemp+"度需要"+energy+"焦耳的能量");
    }
}