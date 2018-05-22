package Heroes_Villains.entities.heroes;

public class Hero {

    protected int health;
    protected boolean isDead;
    protected boolean abilityUsed;
    protected String type;

    public Hero(int health, String type) {
        this.health = health;
        isDead = false;
        abilityUsed = false;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
