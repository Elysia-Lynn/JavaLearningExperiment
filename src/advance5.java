public class advance5 {
    public static void main(String[] args) {
        Side origin=new Side(3,3);
        Side destination=new Side(0,0);
        Boat boat=new Boat();
        String strategy;
        while(destination.getSheep()!=3&&destination.getWolf()!=3){

        }
    }
}

class Side{
    private int sheep;
    private int wolf;
    public Side(int sheep,int wolf){
        this.sheep=sheep;
        this.wolf=wolf;
    }
    public boolean isSafe(){
        if(sheep>wolf)
            return true;
        else
            return false;
    }
    public void updateSheep(int i){
        sheep+=i;
    }
    public void updateWolf(int i){
        wolf+=i;
    }
    public int getSheep(){
        return sheep;
    }
    public int getWolf(){
        return wolf;
    }
}

class Boat{
    private int sheep;
    private int wolf;
    public void goToDestination(Side origin,Side destination,int sheep,int wolf,String strategy){
        origin.updateSheep(-sheep);
        origin.updateWolf(-wolf);
        destination.updateSheep(sheep);
        destination.updateWolf(wolf);
        strategy+="带过去"+sheep+"只羊，"+wolf+"只狼";
    }
    public void goToOrigin(Side origin,Side destination,int sheep,int wolf,String strategy){
        origin.updateSheep(sheep);
        origin.updateWolf(wolf);
        destination.updateSheep(-sheep);
        destination.updateWolf(-wolf);
        strategy+="带回来"+sheep+"只羊，"+wolf+"只狼";
    }
}