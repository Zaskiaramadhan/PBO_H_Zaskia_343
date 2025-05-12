package praktekModul2;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Plant Plant1 = new Plant("Sunflower");
        Plant Plant2 = new Plant("Tulip");
        Farmer farmer1 = new Farmer( "Crazy dave", Plant1.name);
        Farmer farmer2 = new Farmer( "Sober dave", Plant2.name);


        System.out.println("Hello, World!");
        System.out.println("Current date and time: " + new Date());
    }
}