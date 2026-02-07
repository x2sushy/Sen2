package game.location;


import game.character.SC;
import game.gamedata.GameData;

import java.util.ArrayList;

public class Location {

    private String id;
    private String name;
    private ArrayList<String> characters;
    private String weapon;
    private String armor;
    private String potion;
    private String up;
    private String down;
    private String left;
    private String right;
    private ArrayList<SC> scs;

    public Location(String id, String name, ArrayList<String> characters, String weapon, String armor, String potion, String right) {
        this.id = id;
        this.name = name;
        this.characters = characters;
        this.weapon = weapon;
        this.armor = armor;
        this.potion = potion;
        this.right = right;
    }

    public Location() {
    }

    public void setScs(GameData gameData) {
        scs = new ArrayList<>();
        if(characters == null){
            characters = new ArrayList<>();
        }
        for(String chrId:characters){
            scs.add(gameData.getSC(chrId));
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

    public ArrayList<SC> getScs() {
        return scs;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }
}

