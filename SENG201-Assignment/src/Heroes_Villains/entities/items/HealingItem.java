package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.States.GameState;
import Heroes_Villains.SystemUI.PotionTimer;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.cities.rooms.Hospital;
import Heroes_Villains.entities.heroes.Hero;
import Heroes_Villains.graphics.Assets;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class HealingItem extends Item {

    private int healthAmount;
    private long currentTime;
    private int applyTime;

    public HealingItem(int id, String name, BufferedImage image, Game game, Citys cityClass, int healthAmount, int cost, int applyTime) {
        super(id, name, image, game, cityClass);
        this.healthAmount = healthAmount;
        this.cost = cost;
        this.currentTime = 0;
        this.applyTime = applyTime;
    }

    @Override
    public void use(Hero hero) {

        if ((hero.getHealth() < hero.getMaxHealth()) && !hero.getUsingPotion()) {
            count --;
            Timer timer = new Timer();
            hero.setUsingPotion(true);
            //for a commit
            int loops = 0;
            boolean done = false;
            int testHealth = hero.getHealth();
            int testMax = hero.getHealth() + healthAmount;

            if (testMax > hero.getMaxHealth()) {
                testMax = hero.getMaxHealth();
            }

            while (!done) {
                if (testHealth + healthAmount/4 <= testMax) {
                    testHealth += healthAmount/4;
                    loops += 1;
                } else {
                    done = true;
                }
            }

            System.out.println(loops);




            //GameState currentState = (GameState)game.gameState;
            game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].hospital.getTimerList().get(game.getTeam().indexOf(hero)).setTimeRemaining((applyTime/4)*loops);
            //PotionTimer test = new PotionTimer(200,200,hero,game,Assets.deleteButton, applyTime);

            TimerTask task = new TimerTask() {
                int timerCounter = 0;
                @Override
                public void run() {
                    if (timerCounter >= 3) {
                        hero.setUsingPotion(false);
                        timer.cancel();
                    }
                    if (hero.getHealth() + healthAmount/4 < hero.getMaxHealth()) {
                        hero.setHealth(hero.getHealth() + healthAmount/4);
                        System.out.println("Used " + name);
                        System.out.println("first");
                        System.out.println(hero.getName() + ": " +hero.getHealth());
                        timerCounter ++;
                        //test.update();
                        //test.render(game.getGraphics());
                    } else {
                        hero.setHealth(hero.getMaxHealth());
                        System.out.println(hero.getName() + ": " +hero.getHealth());
                        System.out.println("second");
                        hero.setUsingPotion(false);
                        timer.cancel();
                    }
                }
            };

            timer.schedule(task, ((int)((applyTime * 1000)/4)), ((int)((applyTime * 1000)/4)));

        }

    }

    public boolean isUseable() {
        try {

            if (cityClass.cities[game.getPlayer().getCurrentCity()].getRooms()[game.getPlayer().getCurrentRoom()] instanceof Hospital) {
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
