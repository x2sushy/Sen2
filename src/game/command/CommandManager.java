package game.command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<Character, Command> map;

    public CommandManager() {
        this.map  = new HashMap<>();
    }

    public void registerCommand(Character chr, Command comm) {
        map.put(chr, comm);
    }

    public String executeCommand(Character chr) {
        chr = Character.toLowerCase(chr);
        if (map.containsKey(chr)) {
            return map.get(chr).execute();
        } else {
            return "špatný příkaz";
        }
    }



}
