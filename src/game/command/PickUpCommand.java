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
    //todo odstran item po sebrani z lokace
    @Override
    public String execute() {
        String temp = "";
        boolean x = true;
        if (gameData.findLocation(player.getLocationNow()).getLoot() != null) {
            while (x) {
                System.out.println(gameData.findLocation(player.getLocationNow()).getLoot());
                int num = sc.nextInt();
                switch (num) {
                    case 1 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getLoot().getFirst());
                        x = false;
                    }
                    case 2 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getLoot().get(1));
                        x = false;
                    }
                    case 3 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getLoot().getLast());
                        x = false;
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
