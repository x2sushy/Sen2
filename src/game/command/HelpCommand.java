package game.command;

import java.io.*;

public class HelpCommand implements Command {
    /**
     * Executes the help command, which prints the content of the help.txt file.
     * @return empty string, or error message if file reading fails
     */
    @Override
    public String execute() {
        try(BufferedReader br = new BufferedReader(new FileReader("resource/help.txt"))) {
            String line = "";
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            return "problém se souborem";
        }
        return "";
    }
}
