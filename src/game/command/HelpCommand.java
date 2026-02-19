package game.command;

import java.io.*;

public class HelpCommand implements Command {
    /**
     * Executes the help command, which prints the content of the help.txt file.
     * @return empty string, or error message if file reading fails
     */
    @Override
    public String execute() {
        try (InputStream is = getClass().getResourceAsStream("/help.txt")) {
            if (is == null) {
                return "Soubor nebyl nalezen.";
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, java.nio.charset.StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            return "Problém se souborem.";
        }
        return "";
    }
}
