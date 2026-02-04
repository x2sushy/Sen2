package game.command;

import game.character.MC;
import game.gamedata.GameData;

import java.util.NoSuchElementException;

public class DialogCommand implements Command {

    private MC player;
    private GameData gameData;

    public DialogCommand(MC player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    @Override
    public String execute() {
        try {
            if (gameData.getSC(gameData.findLocation(player.getLocationNow()).getCharacters().getFirst()).isFriendly()) {
                return gameData.getSC(gameData.findLocation(player.getLocationNow()).getCharacters().getFirst()).getDialog();
            }
        } catch (NoSuchElementException e) {
            System.out.println("zde není žádný charakter");
        }
        return "";
    }


}
