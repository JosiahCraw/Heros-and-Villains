package Heroes_Villains.entities.heroes;

public class Hero {

    protected int health;
    protected boolean isDead;
    protected boolean abilityUsed;
    protected String type, name;
    protected int maxHealth;
    private boolean isUsingPotion;

    public Hero(int health, String type, String name) {
        this.health = health;
        this.maxHealth = health;
        isDead = false;
        abilityUsed = false;
        this.type = type;
        this.name = name;
        isUsingPotion = false;
    }

    public boolean isAbilityUsed() {
        return abilityUsed;
    }

    public void setAbilityUsed(boolean abilityUsed) {
        this.abilityUsed = abilityUsed;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setUsingPotion(boolean using) {
        isUsingPotion = using;
    }

    public boolean getUsingPotion() {
        return isUsingPotion;
    }
}
