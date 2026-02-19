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

    /**
     * Executes the pick up item command at the player's current location.
     * The method checks if items (weapon, armor, potion) are available in the location.
     * If so, it lists them and prompts the player to choose one using numeric input.
     * @return result message of the action.
     */
    @Override
    public String execute() {
        String temp = "";
        boolean x = true;
        int num = 0;
        if (gameData.findLocation(player.getLocationNow()).getWeapon() != null && gameData.findLocation(player.getLocationNow()).getArmor() != null && gameData.findLocation(player.getLocationNow()).getPotion() != null) {
            while (x) {
                System.out.println("můžeš si vzít jenom jednu věc, když dáš 4 tak si nevezmeš nic a předměty zůstanou v lokaci" + "\n" + "1) " + gameData.getWeapon(gameData.findLocation(player.getLocationNow()).getWeapon()).toString() +
                        ", " + "2) " + gameData.getArmor(gameData.findLocation(player.getLocationNow()).getArmor()).toString() +
                        ", " + "3) " + gameData.getPotion(gameData.findLocation(player.getLocationNow()).getPotion()).toString());

                try {
                    num = Integer.parseInt(sc.next());
                } catch (NumberFormatException _) {
                }

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
    /**
     * Executes the pickup command for testing purposes with a predefined choice.
     * @param num the choice made (1-4)
     * @return result message
     */
    public String executeForTest(int num) {
        String temp = "";
        boolean x = true;
        if (gameData.findLocation(player.getLocationNow()).getWeapon() != null && gameData.findLocation(player.getLocationNow()).getArmor() != null && gameData.findLocation(player.getLocationNow()).getPotion() != null) {
            while (x) {
                System.out.println("můžeš si vzít jenom jednu věc, když dáš 4 tak si nevezmeš nic a předměty zůstanou v lokaci" + "\n" + gameData.getWeapon(gameData.findLocation(player.getLocationNow()).getWeapon()).getName() +
                        ", " + gameData.getArmor(gameData.findLocation(player.getLocationNow()).getArmor()).getName() +
                        ", " + gameData.getPotion(gameData.findLocation(player.getLocationNow()).getPotion()).getName());
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
