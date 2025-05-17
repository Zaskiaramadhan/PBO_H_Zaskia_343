package plants;

public class Flower extends Plant {
    public Flower(String name) {
        super(name);
    }
    
    @Override
    public void talk() {
        System.out.println("Hi! I'm " + name + "! And I'm a Flower!");
    }
    
    @Override
    public void grow() {
        System.out.println(name + " is growing beautifully with colorful petals");
    }
}