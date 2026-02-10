package game;

import game.character.MC;
import game.command.*;
import game.gamedata.GameData;
import game.location.Location;

import java.util.Scanner;

public class Game {
    private MC player;
    private Scanner scanner = new Scanner(System.in);
    private CommandManager commandManager;
    private GameData data;

    /**
     * Initializes the game by loading data and setting up commands.
     */
    public Game() {
        data = GameData.loadGameDataFromResources("/gameData.json");
        data.getLocations().forEach((k,v)->{
            v.setScs(data);
        });
        player = data.getPlayer();
        commandManager = new CommandManager();
        commandManager.registerCommand('w', new UpCommand(data.getPlayer(), data));
        commandManager.registerCommand('a', new LeftCommand(data.getPlayer(), data));
        commandManager.registerCommand('s', new DownCommand(data.getPlayer(), data));
        commandManager.registerCommand('d', new RightCommand(data.getPlayer(), data));
        commandManager.registerCommand('l', new ExitCommand());
        commandManager.registerCommand('h', new HelpCommand());
        commandManager.registerCommand('i', new InventoryCommand(data.getPlayer(), data));
        commandManager.registerCommand('e', new PickUpCommand(data.getPlayer(), data));
        commandManager.registerCommand('q', new DialogCommand(data.getPlayer(), data));
    }


    public CommandManager getCommandManager() {
        return commandManager;
    }


    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Starts and runs the main game loop.
     */
    public void run(){
        boolean exit = true;
        //todo uvod do hry
        while(exit){
            if (!data.findLocation(player.getLocationNow()).getCharacters().isEmpty()) {
                if (data.findLocation(player.getLocationNow()).getCharacters() != null && !data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).isFriendly()) {
                    System.out.println("v lokaci se nachází nepřátelé");
                    for (int i = 0; i < data.findLocation(player.getLocationNow()).getCharacters().size(); i++) {
                        System.out.println("počet nepřátel: " + data.findLocation(player.getLocationNow()).getCharacters().size());
                        player.attack(data, data.getSC(data.findLocation(player.getLocationNow()).getCharacters().get(i)), new Game());
                        if (player.getHealth() <= 0){
                            System.out.println("Umřel jsi. Vzbudil tě budík do práce. Po zbytek života tě bude trápit, že jsi neosvobodil princeznu.");
                            System.exit(0);
                        }
                        switch (data.findLocation(player.getLocationNow()).getCharacters().getFirst()){
                            case "kronos"->{
                                player.setHasCurse(true);
                                System.out.println("kronos ti před svou smrtí dal odzaklínadlo");
                            }
                            case "enemy4"->{
                                System.out.println("Jeden z elfů říká: Pokud hledáš způsob jak zachránit princeznu, najdi Kronose v jeho sídle. To sídlo se nachází na západ od Paseky.");
                            }
                            case "enemy6" -> {
                                //todo dodelat co se stane v lese
                            }
                            default -> {
                            }
                        }
                        data.findLocation(player.getLocationNow()).getCharacters().removeFirst();
                        i--;
                    }
                }else{
                    //todo easter egg
                    System.out.println("v lokaci se nachází: " + data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).getName());
                }
            }
            System.out.print(">>");
            char c = (scanner.nextLine() + " ").charAt(0);
            c = Character.toLowerCase(c);
            System.out.println(commandManager.executeCommand(c));
            if (player.getLocationNow().equals("princezninPalac") && player.HasCurse()){
                //todo konecny vypis pribehu
                exit = false;
            }
        }
    }
}
