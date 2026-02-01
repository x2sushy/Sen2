package game.command;

import game.character.MC;
import game.gamedata.GameData;

public class InventoryCommand implements Command {

    private MC player;
    private GameData gameData;

    public InventoryCommand(MC player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }
    //todo dokonci execute
    @Override
    public String execute() {
        String loot = "";
        for (int i = 0; i < player.getLoot().size(); i++) {
            switch (i){
                case 0-> loot += i + ") " + gameData.getWeapon(player.getLoot().get(i)).toString();
                case 1-> loot += ", " + i + ") " + gameData.getArmor(player.getLoot().get(i)).toString();
                default-> loot += ", " + i + ") " + gameData.getPotion(player.getLoot().get(i)).toString();
            }
        }
        return loot;
    }
}
