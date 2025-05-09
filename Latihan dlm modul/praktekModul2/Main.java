package praktekModul2;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Farmer farmer1 = new Farmer();
        Farmer farmer2 = new Farmer();
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();

        farmer1.name = "Crazy Dave";
        farmer2.name = "Sober Dave";

        plant1.name = "Sunflower";
        plant2.name = "Mushroom";

        System.out.println("Hello, World!");
        System.out.println("Current date and time: " + new Date());
    }
}