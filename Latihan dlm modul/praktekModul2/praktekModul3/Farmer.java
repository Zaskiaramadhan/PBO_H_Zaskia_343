package praktekModul2;

public class Farmer {
    String name;
    String favourite;

    public Farmer(String name, String favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    void talk() {
        System.out.println("Hi! My name is: " + name + ". My favourite plant is: " + favourite);
    }
}