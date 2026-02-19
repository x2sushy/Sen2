package game.items;

import game.character.MC;

public class Potions extends Item {

    private String id;
    private String name;
    private int health;

    public Potions() {
    }

    public Potions(String name, int health) {
        this.name = name;
        this.health = health;
    }

    /**
     * Returns a string representation of the potion.
     * @return name and health addition of the potion
     */
    @Override
    public String toString() {
        return name + ": přidá " + health + " životů";
    }

    /**
     * Uses the potion on the player.
     * @param player the player using the potion
     * @return result message
     */
    public String use(MC player) {
        if (player.getHealth() > 0) {
            if (player.getHealth() + health >= 100) {
                player.setHealth(100);
            }else {
                player.setHealth(player.getHealth() + health);
            }
        } else{
            return "";
        }
        return "přidal sis " + health + " životů";
    }

    public String getName() {
        return name;
    }
}
