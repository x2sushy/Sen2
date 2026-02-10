package tests;

import game.character.MC;
import game.character.SC;
import game.command.*;
import game.gamedata.GameData;
import game.items.Armor;
import game.items.OtherItems;
import game.items.Potions;
import game.items.Weapons;
import game.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private Location location;
    private Location location2;
    private GameData gameData;
    private GameData data;
    private DialogCommand dialog;
    private InventoryCommand inventory;
    private PickUpCommand pickUp;
    private RightCommand right;
    private CommandManager commandManager;
    private MC player;
    private HashMap<String, Location> locations;
    private HashMap<String, OtherItems> curses;
    private HashMap<String, SC> sideCharacters;
    private HashMap<String, Weapons> weapons;
    private HashMap<String, Armor> armors;
    private HashMap<String, Potions> potions;

    /**
     * Sets up the environment for each test.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        player = new MC();
        player.setLocationNow("start");
        ArrayList<String> itm = new ArrayList<>();
        itm.add("sword");
        itm.add("armor");
        itm.add("potion");
        player.setLoot(itm);
        ArrayList<String> chr = new ArrayList();
        chr.add("karel");
        location = new Location("start", "zacatek", chr, "sword", "armor", "potion", "end");
        location2 = new Location("end", "konec",  chr, "sword", "armor", "potion", null);
        locations = new HashMap<>();
        locations.put("start", location);
        locations.put("end", location2);
        weapons = new HashMap<>();
        weapons.put("sword", new Weapons("meč", 10));
        weapons.put("klada", new Weapons("kláda", 20000));
        armors = new HashMap<>();
        armors.put("armor", new Armor("brnění", 10));
        potions = new HashMap<>();
        potions.put("potion", new Potions("elixír", 10));
        curses = new HashMap<>();
        curses.put("curse", new OtherItems());
        sideCharacters = new HashMap<>();
        SC sc = new SC();
        sc.setDialog("ahoj");
        sc.setName("Karel");
        sc.setId("karel");
        sc.setFriendly(true);
        sideCharacters.put("karel", sc);
        data = new GameData();
        data.setUpForTesting(player, weapons, armors, potions, locations, curses, sideCharacters);
        dialog = new DialogCommand(player, data);
        inventory = new InventoryCommand(player, data);
        right = new RightCommand(player, data);
        pickUp = new PickUpCommand(player, data);
        commandManager = new CommandManager();
        commandManager.registerCommand('i', inventory);
    }

    /**
     * Tests the dialog command execution.
     */
    @org.junit.jupiter.api.Test
    void dialogExecute() {
        String tmp = dialog.execute();
        assertEquals("ahoj", tmp);
    }



    /**
     * Tests the inventory command execution.
     */
    @org.junit.jupiter.api.Test
    void inventoryExecute() {
        String tmp = inventory.execute();
        assertEquals("1) meč: damage: 10     2) brnění: redukce: 10     3) elixír: přidá 10 životů", tmp);
    }



    /**
     * Tests the movement command execution.
     */
    @org.junit.jupiter.api.Test
    void rightMovementExecute() {
        String tmp = right.execute();
        assertEquals("vešel jsi do lokace: konec", tmp);
    }



    /**
     * Tests the pick up command execution.
     */
    @org.junit.jupiter.api.Test
    void pickUpExecute() {
        String tmp = pickUp.executeForTest(1);
        assertEquals("sebral jsi: meč", tmp);
    }



    /**
     * Tests the command manager's execution of commands.
     */
    @org.junit.jupiter.api.Test
    void commandManagerExecute() {
        String tmp = commandManager.executeCommand('I');
        assertEquals(inventory.execute(), tmp);
    }



    /**
     * Tests adding an item to the character's loot.
     */
    @org.junit.jupiter.api.Test
    void addToLootTest() {
        String tmp = player.addToLoot(1, "klada", data);
        assertEquals("sebral jsi: kláda", tmp);
    }
}
