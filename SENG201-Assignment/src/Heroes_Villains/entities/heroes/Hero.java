package Heroes_Villains.entities.heroes;

public abstract class Hero {

    protected int health;
    protected boolean isDead;
    protected boolean abilityUsed;

    public Hero(int health) {
        this.health = health;
        isDead = false;
        abilityUsed = false;
    }
}
