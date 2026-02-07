package game.items;

import game.character.Character;
import game.gamedata.GameData;

public class Weapons extends Item {

    private String id;
    private String name;
    private int damage;

    public Weapons() {
    }

    public Weapons(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return name  +
                ": damage: " + damage;
    }

    public int use(Character character, GameData gameData) {
        return damage - gameData.getArmor(character.getLoot().get(1)).getReduction();
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
