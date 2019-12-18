// /**
 // * Write a description of class Arena here.
 // * 
 // * @author (your name) 
 // * @version (a version number or a date)
 // */
// public class Arena
// {
    
    // public static void pressAnyKey()
    // { 
        // System.out.println("Press [Enter] to continue.");
        // try{System.in.read();}  
        // catch(Exception e){}  
    // }
    // public static void Fight(){
        // //change this to character creation method in Ryan's class
        // ArenaFighter enemy=new ArenaFighter();
        // Character player=new Character();
        // int ehealth=enemy.getHealth();
        // int phealth=player.getphealth();
        // //use .getItems as array to step through using check type to only get weapons and pick weapons
        // Items[] l=Shop.getInventory().asList();
        // //add stops
        // while (ehealth*phealth!=0){
            // System.out.println("You have "+phealth+" health and the enemy has "+ehealth+" health.");
            // pressAnyKey();
            // System.out.println("Select the weapon you would like to use:");
            // //interactive shit goes here
            // for (int i=1;i<l.len+1;i++){
                // if (l[i] instanceof Weapon){
                    // System.out.println("["+i+"]"+l[i-1].getName);
                    // System.out.println(l[i-1].getDMG);
                // }
            // }
            // System.out.print(">");
            // String choice=UserInput.getString();
            // ehealth-=l[valueOf(choice)].getDMG();
            // System.out.println();
            // System.out.println("You hit the enemy with the "+l[valueOf(choice)].getName()+" dealing "+l[valueOf(choice)].getDMG()+".");
            // phealth=enemy.getDamage();
            // System.out.println();
            // System.out.println("The enemy hits you dealing"+enemy.getDamage()+" damage.");
            // pressAnyKey();
            // System.out.println();
            // System.out.println();
        // }
    // }
// }