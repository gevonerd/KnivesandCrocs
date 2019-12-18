import java.util.*;
/**
 * Write a description of class Weapons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Items
{
    
    static int range;
    static int dmg;
    public Weapon(String name, int price, String description, int range, int dmg){
        super(name, price, description);
        this.range = range;
        this.dmg = dmg;
    }

    public static int getRange(){
        return range;
    }

    public static int getDMG(){
        return dmg;
    }

    public static void setRange(int r){
        range = r;
    }

    public static  void setDMG(int d){
        dmg = d;
    }
    public static ArrayList makeWeapons(){
        Weapon Rsword = new Weapon("Rusty Sword", 100, "sounds like a bar", 1, 2);
        ArrayList <Weapon> weapons = new ArrayList();
        weapons.add(Rsword);
        return weapons;
    }
}
