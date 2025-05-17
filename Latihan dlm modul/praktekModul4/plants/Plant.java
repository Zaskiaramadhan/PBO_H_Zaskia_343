package plants;

public class Plant extends LivingThing implements Talkable {
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Plant(String name) {
        this.name = name;
    }
    
    @Override
    public void talk() {
        System.out.println("I am a plant named " + name);
    }
    
    @Override
    public void grow() {
        System.out.println(name + " is growing slowly");
    }
}