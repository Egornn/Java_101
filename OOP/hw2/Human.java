public class Human {
    protected String name;
    

    public Human(String name) {
        this.name = name;
    }
    
    public Human() {
        this.name = "Default human";
    }
    @Override
    public String toString() {
        return this.name.toString();
    }
}
