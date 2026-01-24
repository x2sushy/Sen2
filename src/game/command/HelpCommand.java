package game.command;

import java.io.*;

public class HelpCommand implements Command {
    @Override
    public String execute() {
        try(BufferedReader br = new BufferedReader(new FileReader("help.txt"))) {
            String line = " ";
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            return "problém se souborem";
        }
        return "";
    }
}
