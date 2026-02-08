package game.command;

import game.character.MC;
import game.gamedata.GameData;
import game.location.Location;

public class UpCommand implements Command {

    private MC player;
    private GameData data;

    public UpCommand(MC player, GameData data) {
        this.player = player;
        this.data = data;
    }

    /**
     * Executes the command to move the player up.
     * @return result message
     */
    @Override
    public String execute() {
        Location l = data.findLocation(player.getLocationNow());
        if(l.getUp() != null){
            player.setLocationNow(l.getUp());
            return "vešel jsi do lokace: " + data.findLocation(player.getLocationNow()).getName();
        }else{
            return "tady nemůžeš jít";
        }
    }

}
