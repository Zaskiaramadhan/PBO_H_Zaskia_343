import plants.*;
import humans.Farmer;

public class Main {
    public static void main(String[] args) {
        Farmer farmer3 = new Farmer("New Farmer");
        Talkable myPlant = new Flower("Rose");
        farmer3.talk(myPlant);

        Plant cactus = new Plant("Cactus");
        cactus.grow();
        cactus.breathe();
    }
}