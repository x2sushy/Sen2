package game.location;


import game.character.SC;
import game.gamedata.GameData;
import game.items.Item;

import java.util.ArrayList;

public class Location {

    private String id;
    private String name;
    private ArrayList<String> characters;
    private ArrayList<String> loot;
    private String up;
    private String down;
    private String left;
    private String right;
    private ArrayList<SC> scs;
    private ArrayList<Item> items;
    private GameData gameData;

    public Location() {
    }

    public void setScs() {
        if(characters == null){
            characters = new ArrayList<>();
        }
        for(String chrId:characters){
            // todo scs.add(gameData.getSC(chrId));
        }
    }

    public void setItems() {
        if(loot == null){
            loot = new ArrayList<>();
        }
        for(String itmId:loot){
            items.add(gameData.getItem(itmId));
        }
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

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public ArrayList<String> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<String> loot) {
        this.loot = loot;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<SC> getScs() {
        return scs;
    }

    public void setScs(ArrayList<SC> scs) {
        this.scs = scs;
    }
}
