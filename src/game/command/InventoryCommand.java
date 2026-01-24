package game.command;

import game.character.MC;

public class InventoryCommand implements Command {

    private MC player;

    public InventoryCommand(MC player) {
        this.player = player;
    }
    //todo dokonci execute
    @Override
    public String execute() {
        String loot = "";
        for (int i = 0; i < player.getLoot().size(); i++) {
            loot = loot + ", " + player.getLoot().get(i);
        }
        return loot;
    }
}
