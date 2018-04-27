public class Villian {

    private String villanName;
    private int villianHealth;
    private int villianMaxHealth;
    private boolean villianIsDead;

    public Villian(String name, int maxHealth) {
        villanName = name;
        villianMaxHealth = maxHealth;
        villianHealth = maxHealth;
    }

    public boolean checkIfDead() {
        if (villianHealth <= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void doDamage(int damage) {
        villianHealth -= damage;
        villianIsDead = checkIfDead();
    }
    public void heal(int healAmount) {

    }
}
