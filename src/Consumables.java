import java.util.*;
/**
 * Write a description of class Consumables here.
 * 
 * @author Nickolas Flockery 
 * @version (a version number or a date)
 */
public  class Consumables extends Items
{

    static int healthMod;
    static int magikaMod;
    static int staminaMod;
    public Consumables(String name, int price, String description, int healthMod, int mMod, int sMod){
        super(name, price, description);
        this.healthMod = healthMod;
        this.magikaMod = mMod;
        this.staminaMod = sMod;
    }

    /*if we are going to use getters like this, then we just need to have one modifyer and can calculate which stat later
    basically we either call all effects to add in order to have multiple pot effects
    or we can have one modifier for weak, and strong pots then use a method in this class or wherever to just like "add .getPotStrength() to any stat"*/
    public static int getStaminaMod(){
        return staminaMod;
    }

    public static int getMagikaMod(){
        return magikaMod;
    }

    public static int getHealthMod(){
        return healthMod;
    }

    public static void setHealthMod(int h){
        healthMod = h;
    }

    public static void setStaminaMod(int s){
        staminaMod = s;
    }

    public static void setMagikaMod(int m){
        magikaMod = m;
    }

    public static ArrayList makeConsumables(){
        Consumables apple = new Consumables("Apple", 100, "yummm", 10, 0, 0);
        ArrayList <Consumables> consumables = new ArrayList();
        consumables.add(apple);
        return consumables;
    }
}
