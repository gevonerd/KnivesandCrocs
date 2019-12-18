import java.util.ArrayList;
/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop
{
    static String name = "";
    static String desc = "";
    static int index = 0;
    static boolean  shop = false;
    public Shop(){
        name = "";
        desc = "";
        index = 0;
    }

    public Shop(String name, String desc, int index){
        this.name=name;
        this.desc=desc;
        this.index=index;
    }

    public String getShopName(){
        return name;
    }

    public String getShopDesc(){
        return desc;
    }
    //   Shop melee = new Shop("name","desc",0);
    public static void Create(){
        //Shop[] town=new Shop[4];
        Shop shop1=new Shop("Weapons","Buy some guns.",0);
        Shop shop2=new Shop("Armor","Buy some pants.",1);
        Shop shop3=new Shop("Potions","Buy some drank.",2);
    }

    public static void weapons(){
        // pull items from items, put into array and display
        while (shop == false){
            ArrayList<Weapon> weapons = Weapon.makeWeapons();
            for( int x = 0; x<weapons.size(); x++){
                System.out.println("Here you can buy the following: ");
                System.out.print(weapons.get(x).getName());
                System.out.print(" for " + weapons.get(x).getPrice()+ " moneys.");

            }
            shop = true;
        }
    }

    public static void armor(){
        while (shop == false){
            ArrayList<Armor> armor = Armor.makeArmor();
            for(int x = 0; x<armor.size(); x++){
                System.out.println("Here you can buy the following: ");
                System.out.print(armor.get(x).getName());
                System.out.print(" for " + armor.get(x).getPrice()+ " moneys.");;
            }
            shop = true;
        }
    }

    public static void consumables(){
        while (shop == false){
            ArrayList<Consumables> consumables = Consumables.makeConsumables();
            for(int x = 0; x<consumables.size(); x++){
                System.out.println("Here you can buy the following: ");
                System.out.print(consumables.get(x).getName());
                System.out.print(" for " + consumables.get(x).getPrice()+ " moneys.");
            }
            shop = true;
        }
    }
}