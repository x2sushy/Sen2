package game.command;

import game.character.MC;
import game.gamedata.GameData;

import java.util.Scanner;

public class PickUpCommand implements Command {

    private MC player;
    private GameData gameData;
    private Scanner sc = new Scanner(System.in);

    public PickUpCommand(MC player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    @Override
    public String execute() {
        String temp = "";
        boolean x = true;
        if (gameData.findLocation(player.getLocationNow()).getWeapon() != null) {
            while (x) {
                System.out.println(gameData.findLocation(player.getLocationNow()).getWeapon() + ", " + gameData.findLocation(player.getLocationNow()).getArmor() + ", " + gameData.findLocation(player.getLocationNow()).getPotion());
                int num = Integer.parseInt(sc.next());
                switch (num) {
                    case 1 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getWeapon());
                        x = false;
                        gameData.findLocation(player.getLocationNow()).setWeapon(null);
                    }
                    case 2 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getArmor());
                        x = false;
                        gameData.findLocation(player.getLocationNow()).setArmor(null);
                    }
                    case 3 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getPotion());
                        x = false;
                        gameData.findLocation(player.getLocationNow()).setPotion(null);
                    }
                    case 4 -> {
                        temp = "nic sis nevzal";
                        x = false;
                    }
                    default -> System.out.println("špatný input");
                }
            }
        }else {
            temp = "v této lokaci nic není";
        }
        return temp;
    }
}
