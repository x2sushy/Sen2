package game.command;

import game.character.MC;
import game.gamedata.GameData;
import game.location.Location;

public class LeftCommand implements Command {
    private MC player;
    private GameData data;

    public LeftCommand(MC player, GameData data) {
        this.player = player;
        this.data = data;
    }

    @Override
    public String execute() {
        Location l = data.findLocation(player.getLocationNow());
        if(l.getLeft() != null){
            player.setLocationNow(l.getLeft());
            return "vešel jsi do lokace: " + data.findLocation(player.getLocationNow()).getName();
        }else{
            return "tady nemůžeš jít";
        }
    }



}
