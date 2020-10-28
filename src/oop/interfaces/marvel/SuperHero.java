package oop.interfaces.marvel;

import java.util.ArrayList;
import java.util.Objects;

public abstract class SuperHero {
    // data field (common data set among all the sub classes)
    private int strength;
    private int health;
    private String realName;
    private String nationality;
    private ArrayList<String> specialAbilities; //一人のスーパーヒーローにつき複数個の能力

    // constructor1 (specialAbilitiesを個別にconstructor内で設定する）
    public SuperHero(int strength, int health, String realName, String nationality){
        this.strength = strength;
        this.health = health;
        this.realName = realName;
        this.nationality = nationality;
        this.specialAbilities = new ArrayList<>();       // initialize an empty ArrayList
    }

    // constructor2 (specialAbilitiesのArrayをargumentで投げる, pass everything）
    public SuperHero(int strength, int health, String realName, String nationality,
                     ArrayList<String> specialAbilities){
        this.strength = strength;
        this.health = health;
        this.realName = realName;
        this.nationality = nationality;
        this.specialAbilities = specialAbilities;
    }

    // method field
    public void addSpecialAbility(String ability){
        if (!specialAbilities.contains(ability)){      // check if the same ability is in the list already
            specialAbilities.add(ability);
        } else {
            System.out.println("Already exists.");
        }
    }

    public void removeSpecialAbility(String ability){
        if (specialAbilities.contains(ability)){
            specialAbilities.remove(ability);
        }  else {
            System.out.println("Does not exist.");
        }
    }

    // abstract method: has to be implemented in all the subclasses(override is required)
    public abstract void fight();

    // getter
    public int getStrength(){
        return strength;
    }
    public int getHealth(){
        return health;
    }
    public String getRealName(){
        return realName;
    }
    public String getNationality(){
        return nationality;
    }
    public ArrayList<String> getSpecialAbilities(){
        return specialAbilities;
    }


    // setter(if not having setter, it can not be mutated)
    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "strength=" + strength +
                ", health=" + health +
                ", realName='" + realName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", specialAbilities=" + specialAbilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return strength == superHero.strength &&
                health == superHero.health &&
                Objects.equals(realName, superHero.realName) &&
                Objects.equals(nationality, superHero.nationality);
    }
}
