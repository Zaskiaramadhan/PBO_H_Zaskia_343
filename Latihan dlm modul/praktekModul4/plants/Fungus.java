package plants;

public class Fungus extends Plant {
    public Fungus(String name) {
        super(name);
    }
    
    @Override
    public void talk() {
        System.out.println("I am " + name + ", a mysterious fungus");
    }
    
    @Override
    public void grow() {
        System.out.println(name + " is growing in a dark and damp environment");
    }
}