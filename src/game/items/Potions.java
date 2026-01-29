package game.items;

public class Potions extends Item {

    private String id;
    private String name;
    private int health;

    public Potions() {
    }

    @Override
    public String toString() {
        return name + ": přidá " + health + " životů";
    }


    public boolean use() {
        return false;
    }


    public String getName() {
        return name;
    }
}
