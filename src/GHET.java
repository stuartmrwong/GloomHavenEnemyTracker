//Idea - potentially track initiative too, would make condition expiration and wound ticks easier
//but would require players to program each turns initiatives
//To Do- wound damage ticks at start of round either by implementing a start round method or automatically
//Need to be able to add enemies after start of encounters
//Make it prettier!

import java.util.Scanner;

public class GHET {
    int level;
    String name;
    int initiative;
    boolean epicStatus;
    int health;
    int[] healthArry = new int[16];
    int maxHealth;
    boolean poison;
    boolean wound;
    boolean immobilize;
    boolean disarm;
    boolean stun;
    boolean muddle;
    boolean invisible;
    boolean strengthen;

    public GHET(String name, int initiative, boolean epicStatus, int health) {
        this.name = name;
        this.initiative = initiative;
        this.epicStatus = epicStatus;
        this.health = health;
        this.maxHealth = this.health;
        this.poison = false;
        this.wound = false;
        this.immobilize = false;
        this.disarm = false;
        this.stun = false;
        this.muddle = false;
        this.invisible = false;
        this.strengthen = false;
    }

    public GHET enemy(int enLvl, String enName, int enInitiative, boolean enEpic){
        name = enName;
        initiative = enInitiative;
        epicStatus = enEpic;
        level = enLvl;
        if(name.equals("Ancient Artillery")) {
            healthArry = new int[]{4, 7, 6, 9, 7, 11, 8, 13, 9, 13, 11, 15, 14, 16, 16, 20};
        }
        else if(name.equals("Black Imp")) {
            healthArry = new int[]{3, 4, 4, 6, 5, 8, 5, 8, 7, 11, 9, 12, 10, 14, 12, 17};
        }
        else if(name.equals("Bandit Archer")) {
            healthArry = new int[]{4, 6, 5, 7, 6, 9, 6, 10, 8, 10, 10, 12, 10, 13, 13, 17};
        }
        else if(name.equals("Bandit Guard")) {
            healthArry = new int[]{5, 9, 6, 9, 6, 10, 9, 10, 10, 11, 11, 12, 14, 14, 16, 14};
        }
        else if(name.equals("Cave Bear")) {
            healthArry = new int[]{7, 11, 9, 14, 11, 17, 13, 20, 16, 21, 17, 24, 19, 28, 22, 33};
        }
        else if(name.equals("City Archer")) {
            healthArry = new int[]{4, 6, 5, 6, 6, 7, 6, 8, 8, 10, 9, 11, 9, 12, 10, 13};
        }
        else if(name.equals("City Guard")) {
            healthArry = new int[]{5, 6, 5, 6, 7, 9, 8, 9, 9, 10, 10, 12, 11, 13, 13, 14};
        }
        else if(name.equals("Cultist")) {
            healthArry = new int[]{4, 7, 5, 9, 7, 12, 9, 13, 10, 15, 11, 18, 14, 22, 15, 25};
        }
        else if(name.equals("Deep Terror")) {
            healthArry = new int[]{3, 5, 4, 6, 4, 7, 5, 8, 6, 9, 7, 11, 8, 13, 9, 15};
        }
        else if(name.equals("Earth Demon")) {
            healthArry = new int[]{7, 10, 9, 13, 12, 18, 13, 20, 15, 21, 17, 25, 20, 27, 22, 32};
        }
        else if(name.equals("Flame Demon")) {
            healthArry = new int[]{2, 3, 2, 3, 3, 4, 3, 5, 3, 5, 4, 6, 4, 7, 5, 8};
        }
        else if(name.equals("Forest Imp")) {
            healthArry = new int[]{1, 4, 2, 5, 2, 6, 3, 7, 3, 7, 4, 8, 4, 9, 6, 11};
        }
        else if(name.equals("Frost Demon")) {
            healthArry = new int[]{5, 10, 6, 10, 7, 12, 8, 14, 10, 18, 11, 20, 12, 22, 14, 25};
        }
        else if(name.equals("Giant Viper")) {
            healthArry = new int[]{2, 3, 3, 5, 4, 7, 4, 8, 6, 11, 7, 13, 8, 14, 10, 17};
        }
        else if(name.equals("Harrower Infester")) {
            healthArry = new int[]{6, 12, 7, 12, 8, 14, 10, 17, 12, 19, 12, 21, 15, 22, 17, 26};
        }
        else if(name.equals("Hound")) {
            healthArry = new int[]{4, 6, 4, 6, 6, 7, 8, 8, 8, 11, 9, 12, 11, 15, 15, 15};
        }
        else if(name.equals("Inox Archer")) {
            healthArry = new int[]{5, 7, 6, 8, 8, 11, 9, 13, 10, 14, 12, 17, 12, 19, 15, 23};
        }
        else if(name.equals("Inox Guard")) {
            healthArry = new int[]{5, 9, 8, 10, 9, 12, 11, 15, 12, 17, 13, 19, 16, 21, 19, 23};
        }
        else if(name.equals("Inox Shaman")) {
            healthArry = new int[]{4, 6, 6, 9, 7, 11, 9, 14, 10, 16, 13, 20, 15, 24, 16, 27};
        }
        else if(name.equals("Living Bones")) {
            healthArry = new int[]{5, 6, 5, 6, 5, 7, 7, 10, 7, 11, 9, 11, 10, 11, 13, 14};
        }
        else if(name.equals("Living Corpse")) {
            healthArry = new int[]{5, 10, 7, 10, 9, 13, 10, 13, 11, 15, 13, 17, 14, 21, 15, 25};
        }
        else if(name.equals("Living Spirit")) {
            healthArry = new int[]{2, 3, 2, 3, 2, 3, 3, 4, 3, 4, 4, 6, 4, 7, 6, 9};
        }
        else if(name.equals("Lurker")) {
            healthArry = new int[]{5, 7, 7, 9, 9, 12, 10, 14, 11, 15, 12, 16, 14, 18};
        }
        else if(name.equals("Night Demon")) {
            healthArry = new int[]{3, 5, 5, 8, 6, 11, 7, 13, 8, 15, 11, 17, 14, 21, 15, 21};
        }
        else if(name.equals("Ooze")) {
            healthArry = new int[]{4, 8, 5, 9, 7, 11, 8, 11, 9, 13, 10, 15, 12, 16, 14, 18};
        }
        else if(name.equals("Rending Drake")) {
            healthArry = new int[]{5, 7, 6, 7, 7, 9, 7, 10, 9, 11, 10, 14, 11, 15, 14, 18};
        }
        else if(name.equals("Savvas Lavaflow")) {
            healthArry = new int[]{8, 13, 9, 15, 11, 18, 14, 21, 16, 24, 18, 27, 20, 30, 24, 35};
        }
        else if(name.equals("Savvas Icestorm")) {
            healthArry = new int[]{7, 12, 10, 12, 12, 15, 12, 18, 14, 19, 16, 21, 16, 23, 17, 24};
        }
        else if(name.equals("Stone Golem")) {
            healthArry = new int[]{10, 10, 10, 11, 11, 14, 11, 15, 12, 17, 13, 19, 16, 20, 16, 21};
        }
        else if(name.equals("Spitting Drake")) {
            healthArry = new int[]{5, 8, 6, 9, 8, 10, 8, 12, 9, 14, 12, 16, 13, 19, 16, 21};
        }
        else if(name.equals("Sun Demon")) {
            healthArry = new int[]{5, 9, 7, 12, 9, 13, 10, 15, 11, 16, 11, 16, 12, 18, 15, 22};
        }
        else if(name.equals("Vermling Scout")) {
            healthArry = new int[]{2, 4, 3, 5, 3, 5, 5, 7, 6, 8, 8, 11, 9, 12, 11, 15};
        }
        else if(name.equals("Vermling Shaman")) {
            healthArry = new int[]{2, 3, 2, 3, 3, 4, 3, 5, 3, 5, 4, 6, 5, 6, 7, 8};
        }
        else if(name.equals("Wind Demon")) {
            healthArry = new int[]{3, 5, 3, 5, 4, 7, 5, 8, 7, 8, 9, 11, 10, 12, 11, 13};
        }
        else {
            System.out.println("Enemy type not found");
            healthArry = new int[]{99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99};
        }
        switch(enLvl) {
            case 0:
                if (enEpic) {
                    health = healthArry[1];
                } else {
                    health = healthArry[0];
                }
                break;
            case 1:
                if (enEpic) {
                    health = healthArry[3];
                } else {
                    health = healthArry[2];
                }
                break;
            case 2:
                if (enEpic) {
                    health = healthArry[5];
                } else {
                    health = healthArry[4];
                }
                break;
            case 3:
                if (enEpic) {
                    health = healthArry[7];
                } else {
                    health = healthArry[6];
                }
                break;
            case 4:
                if (enEpic) {
                    health = healthArry[9];
                } else {
                    health = healthArry[8];
                }
                break;
            case 5:
                if (enEpic) {
                    health = healthArry[11];
                } else {
                    health = healthArry[10];
                }
                break;
            case 6:
                if (enEpic) {
                    health = healthArry[13];
                } else {
                    health = healthArry[12];
                }
                break;
            case 7:
                if (enEpic) {
                    health = healthArry[15];
                } else {
                    health = healthArry[14];
                }
                break;
            default:
                System.out.println("Invalid level");
                break;
        }
        return new GHET(name, initiative, epicStatus, health);
    }

    //<--- Action Phase methods will go here (ex Hit, Heal, Poison, etc...) -->
    public void heal(int points) {
        if(this.poison) {
            points = 0;
            this.poison = false;
            System.out.println("Poison has been cleansed");
        }
        if(this.wound) {
            this.wound = false;
            System.out.println("Wound has been cured");
        }
        this.health = this.health + points;
        if(this.health > this.maxHealth) {
            this.health = this. maxHealth;
        }
        System.out.println("Heal (+" + points + ") " + this.toString());
    }

    public void hurt(int points) {
        this.health = this.health - points;
        if(this.poison) {
            this.health--;
            System.out.println("Poison saps 1 health");
        }
        if(this.health <= 0) {
            this.name = "Dead";
            this.maxHealth = 0;
            this.health = 0;
            this.initiative = 0;
            System.out.println("Damage (-" + points + ") Enemy killed!");
        }
        else {
            System.out.println("Damage (-" + points + ") " + this.toString());
        }
    }
    //<-- Conditions Placeholders -->
    public void poison() {
        this.poison = true;
        System.out.println(this.toString());
    }
    //Wound to do - damage tick at start of enemy round
    public void wound() {
        this.wound = true;
        System.out.println(this.toString());
    }

    public void immobilize() {
        this.immobilize = true;
        System.out.println(this.toString());
    }

    public void disarm() {
        this.immobilize = true;
        System.out.println(this.toString());
    }

    public void stun() {
        this.stun = true;
        System.out.println(this.toString());
    }

    public void muddle() {
        this.muddle = true;
        System.out.println(this.toString());
    }

    public void invisible() {
        this.invisible = true;
        System.out.println(this.toString());
    }

    public void strengthen() {
        this.strengthen = true;
        System.out.println(this.toString());
    }

    public void endTurn() {
        if(this.immobilize) {
            this.immobilize = false;
            System.out.println("Immobilize has worn off");
        }
        if(this.disarm) {
            this.disarm = false;
            System.out.println("Disarm has worn off");
        }
        if(this.stun) {
            this.stun = false;
            System.out.println("Stun has worn off");
        }
        if(this.muddle) {
            this.muddle = false;
            System.out.println("Muddle has worn off");
        }
        if(this.invisible) {
            this.invisible = false;
            System.out.println("Invisible has worn off");
        }
        if(this.strengthen) {
            this.strengthen = false;
            System.out.println("Strengthen has worn off");
        }

    }

    public String toString() {
        if(this.name.equals("Dead")) {
            return name;
        }
        else if(this.poison || this.wound || this.immobilize || this.disarm || this.stun || this.muddle || this.invisible || this.strengthen) {
            String conditions = "";
            if(this.strengthen){
                conditions = conditions.replaceFirst("", "strengthen, ");
            }
            if(this.invisible){
                conditions = conditions.replaceFirst("", "invisible, ");
            }
            if(this.muddle){
                conditions = conditions.replaceFirst("", "muddle, ");
            }
            if(this.stun){
                conditions = conditions.replaceFirst("", "stun, ");
            }
            if(this.disarm){
                conditions = conditions.replaceFirst("", "disarm, ");
            }
            if(this.immobilize){
                conditions = conditions.replaceFirst("", "immobilize, ");
            }
            if(this.wound){
                conditions = conditions.replaceFirst("", "wound, ");
            }
            if(this.poison){
                conditions = conditions.replaceFirst("", "poison, ");
            }
            char[] conditionArry = conditions.toCharArray();
            conditionArry[conditions.length() - 1] = ' ';
            conditionArry[conditions.length() - 2] = ' ';
            conditions = new String(conditionArry);
            return initiative + " " + name + ", current health : " + health + " conditions: " + conditions;
        }
        else {
            return initiative + " " + name + ", current health : " + health;
        }
    }

    public static void main(String[] args){
        //<-- Setup Phase Code Starts Here -->
        int option;
        int enemyNum = 0;
        GHET[] enemy = new GHET[16];
        GHET ghet = new GHET("Name", 0, false, 0);
        System.out.println("Please enter a player level");
        Scanner scanf = new Scanner(System.in);
        int enemyLvl = scanf.nextInt();
        scanf.nextLine();
        while(true) {
            System.out.println("Enter an enemy type");
            String enemyName = scanf.nextLine();
            System.out.println("Enter the initiative number");
            int enemyInitiative = scanf.nextInt();
            scanf.nextLine();
            System.out.println("Elite? 'yes' 'no'");
            String epic = scanf.nextLine();
            boolean enemyEpic;
            enemyEpic = epic.equals("yes");
            GHET nextEnemy = ghet.enemy(enemyLvl, enemyName, enemyInitiative, enemyEpic);
            if(nextEnemy.health != 99) {
                enemy[enemyNum] = nextEnemy;
                System.out.println("New enemy created : " + enemy[enemyNum].toString());
                enemyNum++;
            }
            System.out.println("\nEnter 1=New Enemy, 2=End Setup Phase, 3=Exit Program");
            option = scanf.nextInt();
            scanf.nextLine();
            if(option == 2){
                System.out.println("\nFull List of enemies:");
                for(int i = 0; i <= (enemyNum - 1); i++) {
                    System.out.println("(" + i + ") " + enemy[i].toString());
                }
                break;
            }
            if(option == 3){
                System.exit(0);
            }
        }
        //<-- Action Phase Code Starts Here -->
        int enemyPlace;
        while(true) {
            System.out.println("\n1=Heal, 2=Damage, 3=Status, 4=Enemy List, 5=Exit 6=Add New Enemies 7=End Turn");
            option = scanf.nextInt();
            scanf.nextLine();
            if(option == 4) {
                for(int i = 0; i <= (enemyNum - 1); i++) {
                    System.out.println("(" + i + ") " + enemy[i].toString());
                }
            }
            else if(option == 5) {
                System.exit(0);
            }
            else if(option == 6) {
                System.out.println("This area WIP");
                //TO DO - Figure out how to loop back to enemy setup phase
            }
            else {
                System.out.println("Select an enemy number");
                enemyPlace = scanf.nextInt();
                scanf.nextLine();
                if(option == 1) {
                    System.out.println("Select an amount to Heal");
                    enemy[enemyPlace].heal(scanf.nextInt());
                    scanf.nextLine();
                }
                else if(option == 2) {
                    System.out.println("Select an amount to Damage");
                    enemy[enemyPlace].hurt(scanf.nextInt());
                    scanf.nextLine();
                }
                else if(option == 3) {
                    int statusOption;
                    System.out.println("Select a status effect:\n1 = poison\n2 = wound\n3 = immobilize\n4 = disarm\n5 = stun\n6 = muddle\n7 = invisible\n8 = strengthen");
                    statusOption = scanf.nextInt();
                    scanf.nextLine();
                    switch(statusOption) {
                        case 1:
                            enemy[enemyPlace].poison();
                            break;
                        case 2:
                            enemy[enemyPlace].wound();
                            break;
                        case 3:
                            enemy[enemyPlace].immobilize();
                            break;
                        case 4:
                            enemy[enemyPlace].disarm();
                            break;
                        case 5:
                            enemy[enemyPlace].stun();
                            break;
                        case 6:
                            enemy[enemyPlace].muddle();
                            break;
                        case 7:
                            enemy[enemyPlace].invisible();
                            break;
                        case 8:
                            enemy[enemyPlace].strengthen();
                            break;
                        default:
                            System.out.println("Option not found");
                    }
                }
                else if(option == 7) {
                    enemy[enemyPlace].endTurn();
                }
                else {
                    System.out.println("Please pick a valid option");
                }
            }
        }
    }
}


