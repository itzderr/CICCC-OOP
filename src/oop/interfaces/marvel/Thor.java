package oop.interfaces.marvel;

public class Thor extends SuperHero implements Flyable{
    // data field specific to this subclass
    private String status;

    public Thor(int strength, int health){
        // using constructor1 from the superclass
        super(strength, health, "Christopher Hemsworth", "Australian");
        this.status = "Prince";
    }

    // getter
    public String getStatus(){
        return status;
    }

    // setter
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public void fight() {
        System.out.println("Thor is fighting...");
    }

    @Override
    public void fly(int distance) {
        if (distance > 0 && getHealth() > 0) {
            System.out.println("Flying...");
        }
    }
}
