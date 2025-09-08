
public class Hero {

    private String name;
    private int health;
    private int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int attack() {
        return this.attackPower;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
