package game.command;

import game.character.MC;
import game.gamedata.GameData;
import game.location.Location;

public class DownCommand implements Command {
    private MC player;
    private GameData data;

    public DownCommand(MC player, GameData data) {
        this.player = player;
        this.data = data;
    }

    @Override
    public String execute() {
        Location l = data.findLocation(player.getLocationNow());
        if(l.getDown() != null){
            player.setLocationNow(l.getDown());
            return "vešel jsi do lokace: " + player.getLocationNow();
        }else{
            return "tady nemůžeš jít";
        }
    }



}
