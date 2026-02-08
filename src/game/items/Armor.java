package game.items;

import game.character.Character;

public class Armor extends Item {

    private String id;
    private String name;
    private int reduction;

    public Armor() {
    }

    public Armor(String name, int reduction) {
        this.name = name;
        this.reduction = reduction;
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


    public int getReduction() {
        return reduction;
    }


    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    /**
     * Returns a string representation of the armor.
     * @return name and reduction of the armor
     */
    @Override
    public String toString() {
        return name + ": redukce: " + reduction;
    }
}
