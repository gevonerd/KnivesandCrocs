
/**
 * Abstract class Items - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Items
{
   static int price;
   static String name;
   static String description;
   static int balance;
   public Items(){
       name = "";
       price = 0;
       description = "";
    }
    public Items(String name, int price, String description){
       this.name = name;
       this.price = price;
       this.description = description;
    }
    public static String getName(){
        return name;
    }
    public static String getDescription(){
        return description;
    }
     public static int getPrice(){
        return price;
    }
    public static int getBalance(){
        return balance;
    }
    public static void setName(String n){
        name = n;
    }
    public static void setDescription(String d){
        name = d;
    }
    public static void setBalance(int b){
        balance = b;
    }
    public static void setPrice(String p){
        name = p;
    }
    public static void buy(Items I){
        
        balance -= I.getPrice();
        //Add Method call to add bought item into inventory
    }
}
