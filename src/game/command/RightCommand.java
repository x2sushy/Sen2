package game.command;

import game.character.MC;
import game.gamedata.GameData;
import game.location.Location;

public class RightCommand implements Command {

    private MC player;
    private GameData data;

    public RightCommand(MC player, GameData data) {
        this.player = player;
        this.data = data;
    }

    @Override
    public String execute() {
        Location l = data.findLocation(player.getLocationNow());
        if(l.getRight() != null){
            player.setLocationNow(l.getRight());
            return "vešel jsi do lokace: " + player.getLocationNow();
        }else{
            return "tady nemůžeš jít";
        }
    }


}
