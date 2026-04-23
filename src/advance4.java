public class advance4 {
    public static void main(String[] args) {
        Strategy strategy=new Strategy();
        strategy.solve();
        strategy.output();
    }
}

class Strategy{
    private int[] result=new int[5];

    private int[][] outcomes={
            {3,2,4,1},
            {15,1,17,7},
            {9,4,6,5},
            {11,1,4,3}
    };

    public void output(){
        for (int i=0;i<4;i++){
            switch (result[i]){
                case 0:
                    System.out.println("第"+(i+1)+"年种水稻");
                    continue;
                case 1:
                    System.out.println("第"+(i+1)+"年种大豆");
                    continue;
                case 2:
                    System.out.println("第"+(i+1)+"年种燕麦");
                    continue;
                case 3:
                    System.out.println("第"+(i+1)+"年种牧草");
                    continue;
                default:
                    System.out.println("这一年什么也没种");
            }
        }
    }

    private int[][] thePast=new int[4][5];  //元素大小是过去对应的这一年种了什么
    private int[][] theTemp=new int[4][2];
    private int[] temp=new int[4];  //用来暂存四种作物的收益
    private int[] profit=new int[4];
    private int[] tempProfit=new int[4];

    public void figureOutTheBestThisYear(int thisYearPlant,int year){
        if(year==4)
            return;
        temp[0]=profit[0]+outcomes[0][thisYearPlant];
        int bestNumber=0,bestProfit=temp[0];
        for (int i=1;i<4;i++){
            temp[i]=profit[i]+outcomes[i][thisYearPlant];
            if(temp[i]>bestProfit) {
                bestNumber = i;
                bestProfit = temp[i];
            }
        }
        thePast[bestNumber][year]=thisYearPlant;
        profit[bestNumber]=bestProfit;
        for(int i=0;i<4;i++){
            figureOutTheBestThisYear(i,year+1);
        };
    }

    public void solve(){
        for (int i=0;i<4;i++){
            profit[i]=outcomes[3][i];
        }
        for(int i=0;i<4;i++)
            figureOutTheBestThisYear(i,1);
        int best=profit[0],bestNumber=0;
        for(int i=1;i<4;i++){
            if(profit[i]>best){
                best=profit[i];
                bestNumber=i;
            }
        }
        for(int i=0;i<5;i++){
            result[i]=thePast[bestNumber][i];
        }
    }

}