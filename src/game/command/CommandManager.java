package game.command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<Character, Command> map;


    public CommandManager() {
        this.map  = new HashMap<>();
    }

    /**
     * Registers a command for a specific character.
     * @param chr character that triggers the command
     * @param comm the command to register
     */
    public void registerCommand(Character chr, Command comm) {
        map.put(chr, comm);
    }

    /**
     * Executes the command associated with the given character.
     * @param chr trigger character
     * @return result message of a commands execution method
     */
    public String executeCommand(Character chr) {
        chr = Character.toLowerCase(chr);
        if (map.containsKey(chr)) {
            return map.get(chr).execute();
        } else {
            return "špatný příkaz";
        }
    }



}
