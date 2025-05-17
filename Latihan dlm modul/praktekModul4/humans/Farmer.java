package humans;

import plants.Talkable;

public class Farmer {
    private String name;
    private String favourite;

    public Farmer(String name, String favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    public Farmer(String name) {
        this.name = name;
        this.favourite = "No favorite plant yet";
    }

    public void talk(Talkable talkable) {
        talkable.talk();
    }
    public void talk() {
        System.out.println("My favourite plant is: " + favourite);
    }
}