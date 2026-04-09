import java.util.Scanner;

public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split("\\s*,\\s*");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        FindDays findDays = new FindDays();
        int day = findDays.findTheDays(year, month);
        if(day!=0)
            System.out.println("输入的是"+year+"年"+month+"月，该月有"+day+"天");
    }
}

class FindDays{
    public int findTheDays(int year,int month){
        if(month<1||month>12) {
            System.out.println("输入的是" + year + "年+" + month + "月，月份必须在1-12之间");
            return 0;
        }
        else{
            if(month==1||(month>=3&&month<=7))
                return findDaysFromMarchToJulyAndJanuary(month);
            else if (month==2) {
                return isLeapYear(year);
            }
            else{
                return findDaysFromAugustToDecember(month);
            }
        }
    }
    private int findDaysFromMarchToJulyAndJanuary(int month){
        if(month%2==1)
            return 31;
        else
            return 30;
    }
    private int findDaysFromAugustToDecember(int month){
        if(month%2==1)
            return 30;
        else
            return 31;
    }
    private int isLeapYear(int year){
        if(year%400==0)
            return 29;
        else if((year%4==0)&&(year%100!=0))
            return 29;
        else
            return 28;
    }
}