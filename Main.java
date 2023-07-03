
public class Main {

    
    public static void main(String args[]) {
    
        MyFrame player = new MyFrame();
        player.GiveFood();
        
        while(player.GameOver()){
            if(player.CkeckFoodPosition())
                player.GiveFood();
        }
        
        System.out.println("Hello world");
        System.out.println("hello wordafljsd");
        
    }
}