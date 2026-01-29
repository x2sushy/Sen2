package game.character;

import game.items.Item;

import java.util.ArrayList;

public class Character {

    protected String id;
    protected int health;
    protected String name;
    protected ArrayList<String> loot;

    public Character() {
    }
    //todo metoda attack
    public void attack(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<String> loot) {
        this.loot = loot;
    }


}
