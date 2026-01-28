package game.gamedata;

import game.Main;
import game.character.MC;
import game.character.SC;
import com.google.gson.Gson;
import game.items.*;
import game.location.Location;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as game.items, characters, locations, and quests.
 *
 */
public class GameData {

    private HashMap<String, Weapons> weapons;
    private HashMap<String, Armor> armors;
    private HashMap<String, Potions> potions;
    private HashMap<String, OtherItems> curse;
    private HashMap<String, SC> sideCharacters;
    private HashMap<String, Location> locations;
    private MC player;

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a game.gamedata.GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
       //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru game.gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {

        //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

        //Přečte celý JSON a vytvoří instanci game.gamedata.GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída game.gamedata.GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }

    /**
     * Finds a specific game.location by its identifier.
     * @param id the identifier of the game.location to be found
     * @return the matching game.location
     */
    public  Location findLocation(String id) {
       if (locations.containsKey(id)) {
           return locations.get(id);
       }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }

    public Weapons getWeapon(String id) {
        Weapons weapon = weapons.get(id);
        if(weapon == null) {
            throw new NullPointerException("žádná zbraň nemá toto id");
        }
        return weapon;
    }

    public Armor getArmor(String id) {
        Armor armor = armors.get(id);
        if(armor == null) {
            throw new NullPointerException("žádné brnění nemá toto id");
        }
        return armor;
    }

    public Potions getPotion(String id) {
        Potions potion = potions.get(id);
        if(potion == null) {
            throw new NullPointerException("žádný elixír nemá toto id");
        }
        return potion;
    }

    public OtherItems getCurse(String id) {
        OtherItems cur = curse.get(id);
        if(curse == null) {
            throw new NullPointerException("žádný předmět nemá toto id");
        }
        return cur;
    }

    public SC getSC(String id) {
        SC sc = sideCharacters.get(id);
        if(sc == null) {
            throw new NullPointerException("žádný charakter neodpovídá tomuto id");
        }
        return sc;
    }


    public HashMap<String, SC> getSideCharacters() {
        return sideCharacters;
    }

    public HashMap<String, Location> getLocations() {
        return locations;
    }

    public MC getPlayer() {
        return player;
    }
}
