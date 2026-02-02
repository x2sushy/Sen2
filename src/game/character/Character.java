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
                try {
                    temp = game.getScanner().nextInt();
                    tmp = false;
                } catch (InputMismatchException e) {
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
                        }
                    }
                }
                case 2 -> {
                    System.out.println("brnění máš na sobě, není důvod ho používat");
                }
                default -> {
                    if (loot.get(temp - 1).equals("curse")) {
                        System.out.println("zaklínadlo nemůžeš použít na nepřítele");
                    } else {
                        System.out.println(data.getPotion(loot.get(temp - 1)).use((MC) this));
                        health = health - data.getWeapon(enemy.getLoot().getFirst()).use(this, data);
                        System.out.println(enemy.getName() + " ti ubral " + data.getWeapon(enemy.getLoot().getFirst()).use(this, data) + " životů");
                    }
                }
            }
        }while (health > 0 && enemy.getHealth() > 0);
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
