package plants;

public abstract class LivingThing {
    protected String name;
    
    public abstract void grow(); // Abstract method
    
    public void breathe() {
        System.out.println(name + " is breathing");
    }
}