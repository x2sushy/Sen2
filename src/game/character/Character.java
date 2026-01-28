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

    public String addToLoot(int index, String item) {
        String temp = "";
        if (index == 1 || index == 2) {
            if (loot.size() < 5) {
                loot.remove(index-1);
                loot.add(index-1, item);
                temp = "sebral jsi: " + item;
            } else {
                temp = "máš plný inventář";
            }
        }else {
            if (loot.size() < 5) {
                loot.addLast(item);
                temp = "sebral jsi: " + item;
            }else {
                temp = "máš plný inventář";
            }
        }
        return temp;
    }
}
