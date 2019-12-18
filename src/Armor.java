import java.util.*;
/**
 * Write a description of class Armor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armor extends Items
{

    int armorRating;
    boolean chestplate;
    boolean leggings;
    boolean helmet;
    String name;
    int price;
    String description;
    public Armor(String name, int price, String description, int armorRating, boolean chestplate, boolean leggings, boolean helmet){
        super(name, price, description);
        this.armorRating = armorRating;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.helmet = helmet;
    }
    public Armor(String name, int price, String description, int armorRating){
        super(name, price, description);
        this.armorRating = armorRating;
        chestplate = false;
        leggings = false;
        helmet = false;
    }
    public boolean getChestplate(){
        return chestplate;
    }
    public boolean getLeggings(){
        return leggings;
    }
    public boolean getHelmet(){
        return helmet;
    }
    public static ArrayList makeArmor(){
        Armor RonMcDon = new Armor("Ronald McDonal's Outfit", 100, "No Molesting children... connor...", 1);
        ArrayList <Armor> armor = new ArrayList();
        armor.add(RonMcDon);
        return armor;
    }
}
