package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;

import java.awt.image.BufferedImage;

public abstract class Item {

    public int id;
    public String name;
    public int count = 0;
    public BufferedImage image;
    protected Game game;
    protected Citys cityClass;

    public Item(int id, String name, BufferedImage image, Game game, Citys cityClass) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.game = game;
        this.cityClass = cityClass;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    //Setter
    public void setCount(int count) {
        this.count = count;
    }

}
