public class ArenaFighter
{
    int health;
    int damage;
    double crit;
    int stamina;
    int level;
    public void fighter(){
        health=100;
        damage=10;
        crit=.02;
        stamina=100;
		level=1;
    }
    public void fighter(int health, int damage, double crit, int stamina, int level){
        this.health=health;
        this.damage=damage;
        this.crit=crit;
        this.stamina=stamina;
		this.level=level;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
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
}
