package game.character;

import game.gamedata.GameData;

public class MC extends Character{

    private String locationNow;
    private boolean curse = false;


    public MC() {
    }


    public String getLocationNow() {
        return locationNow;
    }


    public void setLocationNow(String locationNow) {
        this.locationNow = locationNow;
    }

    /**
     * Adds an item to the player's loot.
     * @param index type of item (1: Weapon, 2: Armor, 3: Potion)
     * @param item item ID to add
     * @param gameData game data for lookup
     * @return result message
     */
    public String addToLoot(int index, String item, GameData gameData) {
        String temp = "";
        switch (index) {
            case 1 -> {if (loot.size() < 5) {
                loot.remove(index-1);
                loot.add(index-1, item);
                temp = "sebral jsi: " + gameData.getWeapon(item).getName();
                } else {
                temp = "máš plný inventář";
                }
            }
            case 2 -> {if (loot.size() < 5) {
                loot.remove(index-1);
                loot.add(index-1, item);
                temp = "sebral jsi: " + gameData.getArmor(item).getName();
                }else {
                temp = "máš plný inventář";
                }
            }
            case 3 -> {if (loot.size() < 5) {
                loot.remove(index-1);
                loot.addLast(item);
                temp = "sebral jsi: " + gameData.getPotion(item).getName();
                }else {
                temp = "máš plný inventář";
                }
            }
        }
        return temp;
    }



    public boolean HasCurse() {
        return curse;
    }


    public void setHasCurse(boolean hasCurse) {
        this.curse = hasCurse;
    }
}
