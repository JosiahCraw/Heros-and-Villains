package Heroes_Villains.entities.npc;

import Heroes_Villains.entities.Entities;

/**
 * The abstract class describing NPC entities.
 * Extends Entities.
 */
public abstract class NPC extends Entities {

    protected String name;

    /**
     * Default constructor of the NPC Type entities.
     *
     * @param x the x position in pixels of the NPC.
     * @param y the y position in pixels of the NPC.
     * @param name the name of the NPC.
     */
    public NPC(float x, float y, String name) {
        super(x, y);
        this.name = name;
    }
}
