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
        //todo opravit
        String temp = "";
        boolean x = true;
        int num = 0;
        if (gameData.findLocation(player.getLocationNow()).getWeapon() != null && gameData.findLocation(player.getLocationNow()).getArmor() != null && gameData.findLocation(player.getLocationNow()).getPotion() != null) {
            while (x) {
                System.out.println("můžeš si vzít jenom jednu věc, když dáš 4 tak si nevezmeš nic a předměty zůstanou v lokaci" + "\n" + gameData.getWeapon(gameData.findLocation(player.getLocationNow()).getWeapon()).getName() +
                        ", " + gameData.getArmor(gameData.findLocation(player.getLocationNow()).getArmor()).getName() +
                        ", " + gameData.getPotion(gameData.findLocation(player.getLocationNow()).getPotion()).getName());

                try {
                    num = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    x = false;
                }

                x = true;
                switch (num) {
                    case 1 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getWeapon(), gameData);
                        x = false;
                        gameData.findLocation(player.getLocationNow()).setWeapon(null);
                    }
                    case 2 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getArmor(), gameData);
                        x = false;
                        gameData.findLocation(player.getLocationNow()).setArmor(null);
                    }
                    case 3 -> {
                        temp = player.addToLoot(num, gameData.findLocation(player.getLocationNow()).getPotion(), gameData);
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
        } else {
            temp = "v této lokaci nic není";
        }
        return temp;
    }
}
