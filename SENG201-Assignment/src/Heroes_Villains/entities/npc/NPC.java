package Heroes_Villains.entities.npc;

import Heroes_Villains.entities.Entities;

public abstract class NPC extends Entities {

    protected String name;

    public NPC(float x, float y, String name) {
        super(x, y);
        this.name = name;
    }
}
