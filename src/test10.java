public class test10 {
    static int count=0;

    public static void main(String[] args) {
        for(int i=1;15*i<180;i++){
            if((180-15*i-3)%2==0){
                count+=(177-i*15)/6;
            }
            else
                count+=(174-i*15)/6;
        }
        System.out.println("共有"+count+"种可能");
        traverse();
    }

    //笨蛋遍历法
    public static void traverse(){
        count=0;
        for(int i=1;15*i<180;i++){
            for(int j=1;15*i+3*j<180;j++)
                if((180-15*i+3*j)%2==0)
                    count++;
        }
        System.out.println("傻瓜遍历法：共有"+count+"种可能");
    }
}

