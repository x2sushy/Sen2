package game;

import game.command.*;
import game.gamedata.GameData;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private CommandManager commandManager;
    private GameData data;

    public Game() {
        data = GameData.loadGameDataFromResources("/gameData.json");
        commandManager = new CommandManager();
        commandManager.registerCommand('w', new UpCommand(data.getPlayer(), data));
        commandManager.registerCommand('a', new LeftCommand(data.getPlayer(), data));
        commandManager.registerCommand('s', new DownCommand(data.getPlayer(), data));
        commandManager.registerCommand('d', new RightCommand(data.getPlayer(), data));
        commandManager.registerCommand('l', new ExitCommand());
        commandManager.registerCommand('h', new HelpCommand());
        commandManager.registerCommand('i', new InventoryCommand(data.getPlayer()));
        commandManager.registerCommand('e', new PickUpCommand(data.getPlayer(), data));
    }
    //todo při vypisování itemu lokací a vseho z jsonu vypisovat jmeno a ne id

    public void run(){
        boolean exit = false;
        while(!exit){
            System.out.print(">>");
            Character c = scanner.nextLine().charAt(0);
            c = Character.toLowerCase(c);
            System.out.println(commandManager.executeCommand(c));
        }
    }
}
