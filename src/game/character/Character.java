package game.character;

import game.Game;
import game.gamedata.GameData;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Character {

    protected String id;
    protected int health;
    protected String name;
    protected ArrayList<String> loot;

    public Character() {
    }

    public void attack(GameData data, SC enemy, Game game) {
        do {
            int temp = 0;
            boolean tmp;
            do {
                System.out.println("co chceš použít:");
                System.out.println(game.getCommandManager().executeCommand('i'));
                String input = game.getScanner().nextLine().trim();
                try {
                    temp = Integer.parseInt(input);
                    if (temp <= loot.size()) {
                        tmp = false;
                    } else {
                        System.out.println("zadal jsi moc velké číslo");
                        tmp = true;
                    }
                } catch (Exception e) {
                    System.out.println("špatný input");
                    tmp = true;
                }
            } while (tmp);
            switch (temp) {
                case 1 -> {
                    if (!enemy.isFriendly()) {
                        enemy.setHealth(enemy.getHealth() - data.getWeapon(loot.getFirst()).use(enemy, data));
                        if (enemy.getHealth() > 0) {
                            health = health - data.getWeapon(enemy.getLoot().getFirst()).use(this, data);
                            System.out.println(enemy.getName() + " ti ubral " + data.getWeapon(enemy.getLoot().getFirst()).use(this, data) + " životů");
                        }else {
                            enemy.setHealth(0);
                        }
                        System.out.println(enemy);
                        System.out.println("tvoje životy: " + this.health);
                    }
                }
                case 2 -> {
                    System.out.println("brnění máš na sobě, není důvod ho používat");
                    System.out.println(enemy.toString());
                }
                default -> {
                    if (loot.get(temp - 1).equals("curse")) {
                        System.out.println("zaklínadlo nemůžeš použít na nepřítele");
                        System.out.println(enemy.toString());
                    } else {
                        System.out.println(data.getPotion(loot.get(temp - 1)).use((MC) this));
                        health = health - data.getWeapon(enemy.getLoot().getFirst()).use(this, data);
                        System.out.println(enemy.getName() + " ti ubral " + data.getWeapon(enemy.getLoot().getFirst()).use(this, data) + " životů");
                        System.out.println(enemy);
                    }
                }
            }
        }while (health > 0 && enemy.getHealth() > 0);
        System.out.println("zabil jsi: " + enemy.getName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<String> loot) {
        this.loot = loot;
    }


}
