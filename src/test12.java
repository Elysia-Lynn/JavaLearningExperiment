import java.util.Random;

public class test12 {
    public static void main(String[] args) {
        Deck deck=new Deck();
        CardGroup group1=deck.formCardGroup();
        group1.printCardGroup();
        CardGroup group2=deck.formCardGroup();
        group2.printCardGroup();
        group1.compare(group2);
    }
}

class Card{
    private String number;
    private int colour;
    private boolean isUsed=false;
    public Card(String number,int colour){
        this.number=number;
        this.colour=colour;
    }

    public int getNumber() {
        return switch (number) {
            case "A" -> 1;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(number);
        };
    }
    public String getColour(){
        return switch (colour){
            case 1->"黑桃";
            case 2->"红心";
            case 3->"梅花";
            case 4->"方块";
            default -> "你搞错了";
        };
    }
    public boolean getIfUsed(){
        return isUsed;
    }
    public void used(){
        this.isUsed=true;
    }
    public void printCard(){
        System.out.println(this.getColour()+","+this.getNumber());
    }
}

class Deck{
    private Card[] deck;
    public Deck(){
        deck=new Card[52];
        for (int i=1;i<5;i++){
            deck[i-1]=new Card("A",i);
        }
        for (int i=2;i<11;i++){
            for (int j=1;j<5;j++)
                deck[4*(i-1)+j-1]=new Card(String.valueOf(i),j);
        }
        for (int i=1;i<5;i++){
            deck[40+i-1]=new Card("J",i);
        }
        for (int i=1;i<5;i++){
            deck[44+i-1]=new Card("Q",i);
        }
        for (int i=1;i<5;i++){
            deck[48+i-1]=new Card("K",i);
        }
    }
    public Card dealCard(){
        Random random=new Random();
        while(true){
            int cardNumber=random.nextInt(52);
            //System.out.println(cardNumber);       纠错中
            if (!deck[cardNumber].getIfUsed()){
                deck[cardNumber].used();
                return deck[cardNumber];
            }
        }
    }
    public CardGroup formCardGroup(){       //嗯对我花了这么多行好不容易写出来的随机发牌，用list+shuffle+每次直接抽走前三张牌可以秒掉
        return new CardGroup(this.dealCard(),this.dealCard(),this.dealCard());
    }
}

class CardGroup{
    private Card[] cards;
    public CardGroup(Card card1,Card card2,Card card3){
        this.cards=new Card[3];
        this.cards[0]=card1;
        this.cards[1]=card2;
        this.cards[2]=card3;
    }
    public int countTheSameNumbers(){
        int count=1;
        for (int i=1;i<3;i++){
            if(cards[i].getNumber()==cards[0].getNumber())
                count++;
        }
        if(count!=1)
            return count;
        else if (cards[1].getNumber()==cards[2].getNumber())
        return 2;
        else
            return 1;
    }
    public boolean ifAllTheColorsAreTheSame(){
        int count=1;
        for(int i=1;i<3;i++){
            if(cards[i].getColour().equals(cards[0].getColour()))
                count++;
        }
        if(count==3)        //这整个可以简化为一个return语句
            return true;
        else
            return false;
    }
    public int getCardGroupSum(){
        return cards[0].getNumber()+cards[1].getNumber()+cards[2].getNumber();
    }
    public void compare(CardGroup c){
        int sameNumberInTheOriginCardGroup=this.countTheSameNumbers();      //这些也可以优化成CardGroup类的属性
        int sameNumberInTheCompareCardGroup=c.countTheSameNumbers();
        boolean ifAllTheColorsAreTheSameInTheOrigin=this.ifAllTheColorsAreTheSame();
        boolean ifAllTheColorsAreTheSameInTheCompare=c.ifAllTheColorsAreTheSame();
        int sumOfTheOriginCardGroup=this.getCardGroupSum();
        int sumOfTheCompareCardGroup=c.getCardGroupSum();
        if(sameNumberInTheOriginCardGroup==3||sameNumberInTheCompareCardGroup==3){       //first
            if(sameNumberInTheOriginCardGroup>sameNumberInTheCompareCardGroup)
                System.out.println("本牌组大于被比较的牌组");
            else if (sameNumberInTheOriginCardGroup<sameNumberInTheCompareCardGroup) {
                System.out.println("本牌组小于被比较的牌组");
            }
            else {
                if(sumOfTheOriginCardGroup>sumOfTheCompareCardGroup)
                    System.out.println("本牌组大于被比较的牌组");
                else if (sumOfTheOriginCardGroup==sumOfTheCompareCardGroup) {
                    System.out.println("这两个数组一样大");
                } else  {
                    System.out.println("本牌组小于被比较的牌组");
                }
            }
        }
        else if (sameNumberInTheOriginCardGroup==2||sameNumberInTheCompareCardGroup==2) {        //second
            if(sameNumberInTheOriginCardGroup>sameNumberInTheCompareCardGroup)
                System.out.println("本牌组大于被比较的牌组");
            else if (sameNumberInTheOriginCardGroup<sameNumberInTheCompareCardGroup) {
                System.out.println("本牌组小于被比较的牌组");
            }
            else {
                if(sumOfTheOriginCardGroup>sumOfTheCompareCardGroup)
                    System.out.println("本牌组大于被比较的牌组");
                else if (sumOfTheOriginCardGroup==sumOfTheCompareCardGroup) {
                    System.out.println("这两个数组一样大");
                }
                else  {
                    System.out.println("本牌组小于被比较的牌组");
                }
            }
        }
        else if (ifAllTheColorsAreTheSameInTheCompare||ifAllTheColorsAreTheSameInTheOrigin){     //third
            if(ifAllTheColorsAreTheSameInTheOrigin&&!ifAllTheColorsAreTheSameInTheCompare)
                System.out.println("本牌组大于被比较的牌组");
            else if (!ifAllTheColorsAreTheSameInTheOrigin) {
                System.out.println("本牌组小于被比较的牌组");
            }
            else {
                if(sumOfTheOriginCardGroup>sumOfTheCompareCardGroup)
                    System.out.println("本牌组大于被比较的牌组");
                else if (sumOfTheOriginCardGroup==sumOfTheCompareCardGroup) {
                    System.out.println("这两个数组一样大");
                }
                else  {
                    System.out.println("本牌组小于被比较的牌组");
                }
            }
        }
        else {
            if(sumOfTheOriginCardGroup>sumOfTheCompareCardGroup)
                System.out.println("本牌组大于被比较的牌组");
            else if (sumOfTheOriginCardGroup==sumOfTheCompareCardGroup) {
                System.out.println("这两个数组一样大");
            }
            else  {
                System.out.println("本牌组小于被比较的牌组");
            }
        }
    }
    public void printCardGroup(){
        cards[0].printCard();
        cards[1].printCard();
        cards[2].printCard();
    }
}