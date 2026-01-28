package game.items;

import game.character.Character;

public class Weapons extends Item {

    private String id;
    private String name;
    private int damage;

    public Weapons() {
    }

    @Override
    public String toString() {
        return "zbraň: " +
                "damage=" + damage +
                ", jméno=" + name;
    }

    public boolean use() {
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
