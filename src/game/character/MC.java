package game.character;

import game.gamedata.GameData;

public class MC extends Character{

    private String locationNow;
    private boolean hasCurse = false;

    public MC() {
    }

    public String getLocationNow() {
        return locationNow;
    }

    public void setLocationNow(String locationNow) {
        this.locationNow = locationNow;
    }

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


    public boolean isHasCurse() {
        return hasCurse;
    }

    public void setHasCurse(boolean hasCurse) {
        this.hasCurse = hasCurse;
    }
}
