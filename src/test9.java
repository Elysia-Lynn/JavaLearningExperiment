public class test9 {
    public static void main(String[] args) {
        for(int i=0;i<=9;i++){
            int result=10702+i*1000;
            for(int j=0;j<=9;j++){
                if(result%23==0)
                    System.out.println(result);
                result+=10;
            }
        }
    }
}
