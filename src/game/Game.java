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
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void run(){
        boolean exit = true;
        //uvod do hry
        while(exit){
            if (!data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).isFriendly()){
                System.out.println("v lokaci se nachází nepřátelé");
                for (int i = 0; i < data.findLocation(player.getLocationNow()).getCharacters().size(); i++) {
                    player.attack(data, data.getSC(data.findLocation(player.getLocationNow()).getCharacters().get(i)),new Game());
                }
            }
            System.out.print(">>");
            char c = (scanner.nextLine() + " ").charAt(0);
            c = Character.toLowerCase(c);
            System.out.println(commandManager.executeCommand(c));
        }
    }
}
