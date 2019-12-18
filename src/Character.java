
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    // instance variables - replace the example below with your own
    private int x;
    private int phealth1;
    private int damage;
    private double crit;
    private int stamina;
    private int level;

    /**
     * Constructor for objects of class Character
     */
    public Character()
    {
        // initialise instance variables
        x = 0;
    }
    public int getphealth() {
        return phealth1;
    }
    public void setphealth(int health) {
        this.phealth1 = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public double getCrit() {
        return crit;
    }
    public void setCrit(double crit) {
        this.crit = crit;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
