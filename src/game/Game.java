package game;

import game.character.MC;
import game.command.*;
import game.gamedata.GameData;
import game.location.Location;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        boolean egg = false;
        try(BufferedReader br = new BufferedReader(new FileReader("resource/start.txt"))) {
            String line = "";
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("problém se souborem");
        }
        while(exit){
            if (!data.findLocation(player.getLocationNow()).getCharacters().isEmpty()) {
                if (data.findLocation(player.getLocationNow()).getCharacters() != null && !data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).isFriendly()) {
                    System.out.println("v lokaci se nachází nepřátelé");
                    for (int i = 0; i < data.findLocation(player.getLocationNow()).getCharacters().size(); i++) {
                        System.out.println("počet nepřátel: " + data.findLocation(player.getLocationNow()).getCharacters().size());
                        player.attack(data, data.getSC(data.findLocation(player.getLocationNow()).getCharacters().get(i)), new Game());
                        if (player.getHealth() <= 0 && !egg){
                            System.out.println("Umřel jsi. Vzbudil tě budík do práce. Po zbytek života tě bude trápit, že jsi neosvobodil princeznu.");
                            System.exit(0);
                        } else if (player.getHealth() <= 0 && egg) {
                            System.out.println("Umřel jsi. Jelikož jsi vyměnil svojí duši za lepší vybavení, tak jsi se ocitnul v pekle v okovech a navěčnost budeš Malevole sloužit jako otrok. Hodně freaky win");
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
                                try(BufferedReader br = new BufferedReader(new FileReader("resource/les.txt"))) {
                                    String line = "";
                                    while((line = br.readLine())!=null){
                                        System.out.println(line);
                                    }
                                }catch (IOException e){
                                    System.out.println("problém se souborem");
                                }
                                player.setLocationNow("francovaJeskyne");
                            }
                            default -> {
                            }
                        }
                        data.findLocation(player.getLocationNow()).getCharacters().removeFirst();
                        i--;
                    }
                }else{
                    //todo easter egg
                    if (data.findLocation("tajemnyLes").getCharacters()!=null && player.getLocationNow().equals("pekelneUdoli")){
                        System.out.println("v lokaci se nachází: " + data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).getName() + '\n'
                                + " Zdravím tě Hrdino, mám pro tebe nabídku. Výměnou za tvojí duši ti dám mnohem lepší vybavení. Meč, který zabije kohokoliv na jednu ránu, a brnění, které ti naopak bude dávat větší damage od nepřátel." + '\n' + " odpověz ano nebo ne");
                        boolean tmp = true;
                        String s = "";
                        while(tmp) {
                            System.out.print(">>");
                            s = scanner.nextLine();
                            if (s.equals("ano")){
                                tmp = false;
                                player.addToLoot(0, data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).getLoot().getFirst(), data);
                                player.addToLoot(1, data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).getLoot().getLast(), data);
                                System.out.println("Good boy. Tady máš to lepší vybavení. Uvidíme se v pekle.");
                                data.findLocation(player.getLocationNow()).getCharacters().clear();
                            } else if (s.equals("ne")) {
                                tmp = false;
                                System.out.println("Škoda, mohl jsi být můj mazlíček. Přeji hodně štěstí s princeznou.");
                                data.findLocation(player.getLocationNow()).getCharacters().clear();
                            }else{
                                System.out.println("špatný input");
                            }
                        }
                        egg = true;
                    }else {
                        System.out.println("v lokaci se nachází: " + data.getSC(data.findLocation(player.getLocationNow()).getCharacters().getFirst()).getName());
                    }
                }
            }
            System.out.print(">>");
            char c = (scanner.nextLine() + " ").charAt(0);
            c = Character.toLowerCase(c);
            System.out.println(commandManager.executeCommand(c));
            if (player.getLocationNow().equals("princezninPalac") && player.HasCurse()){
                try(BufferedReader br = new BufferedReader(new FileReader("resource/end.txt"))) {
                    String line = "";
                    while((line = br.readLine())!=null){
                        System.out.println(line);
                    }
                }catch (IOException e){
                    System.out.println("problém se souborem");
                }
                exit = false;
            }
        }
    }
}
