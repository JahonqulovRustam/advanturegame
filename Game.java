import java.util.Scanner;

public class Game {
    static int hp = 100;
    static int atk = 10;
    static int gold = 0;
    static int loc = 0;
    static boolean sword = false;
    static boolean shield = false;
    static boolean potion = false;
    static String pname = "";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter name: ");
        pname = sc.nextLine();
        System.out.println("Welcome " + pname);
        System.out.println("You are in a dark forest.");

        while (hp > 0) {
            if (loc == 0) {
                System.out.println("\n--- FOREST ---");
                System.out.println("HP: " + hp + " Gold: " + gold);
                System.out.println("1. Go to village");
                System.out.println("2. Go to cave");
                System.out.println("3. Fight wolf");
                System.out.println("4. Quit");
                String in = sc.nextLine();
                if (in.equals("1")) {
                    loc = 1;
                } else if (in.equals("2")) {
                    loc = 2;
                } else if (in.equals("3")) {
                    int ehp = 30;
                    int eatk = 8;
                    System.out.println("Wolf appears! HP: " + ehp);
                    while (ehp > 0 && hp > 0) {
                        System.out.println("1. Attack 2. Run");
                        String a = sc.nextLine();
                        if (a.equals("1")) {
                            int dmg = atk + (int)(Math.random() * 5);
                            ehp -= dmg;
                            System.out.println("You hit for " + dmg);
                            if (ehp > 0) {
                                int edm = eatk + (int)(Math.random() * 3);
                                hp -= edm;
                                System.out.println("Wolf hits you for " + edm + ". HP: " + hp);
                            }
                        } else if (a.equals("2")) {
                            System.out.println("You ran away!");
                            break;
                        }
                    }
                    if (ehp <= 0) {
                        System.out.println("Wolf defeated!");
                        gold += 10;
                        System.out.println("Got 10 gold");
                    }
                } else if (in.equals("4")) {
                    System.out.println("Bye");
                    break;
                }
            } else if (loc == 1) {
                System.out.println("\n--- VILLAGE ---");
                System.out.println("HP: " + hp + " Gold: " + gold);
                System.out.println("1. Buy sword (20g)");
                System.out.println("2. Buy shield (15g)");
                System.out.println("3. Buy potion (10g)");
                System.out.println("4. Use potion");
                System.out.println("5. Go back");
                String in = sc.nextLine();
                if (in.equals("1")) {
                    if (gold >= 20) {
                        gold -= 20;
                        sword = true;
                        atk = 20;
                        System.out.println("Bought sword");
                    } else {
                        System.out.println("Not enough gold");
                    }
                } else if (in.equals("2")) {
                    if (gold >= 15) {
                        gold -= 15;
                        shield = true;
                        System.out.println("Bought shield");
                    } else {
                        System.out.println("Not enough gold");
                    }
                } else if (in.equals("3")) {
                    if (gold >= 10) {
                        gold -= 10;
                        potion = true;
                        System.out.println("Bought potion");
                    } else {
                        System.out.println("Not enough gold");
                    }
                } else if (in.equals("4")) {
                    if (potion) {
                        hp += 30;
                        potion = false;
                        System.out.println("Used potion. HP: " + hp);
                    } else {
                        System.out.println("No potion");
                    }
                } else if (in.equals("5")) {
                    loc = 0;
                }
            } else if (loc == 2) {
                System.out.println("\n--- CAVE ---");
                System.out.println("HP: " + hp + " Gold: " + gold);
                System.out.println("1. Fight dragon");
                System.out.println("2. Go back");
                String in = sc.nextLine();
                if (in.equals("1")) {
                    int ehp = 150;
                    int eatk = 25;
                    System.out.println("DRAGON! HP: " + ehp);
                    while (ehp > 0 && hp > 0) {
                        System.out.println("1. Attack 2. Run");
                        String a = sc.nextLine();
                        if (a.equals("1")) {
                            int dmg = atk + (int)(Math.random() * 10);
                            ehp -= dmg;
                            System.out.println("You hit for " + dmg);
                            if (ehp > 0) {
                                int edm = eatk + (int)(Math.random() * 10);
                                if (shield) edm = edm / 2;
                                hp -= edm;
                                System.out.println("Dragon hits you for " + edm + ". HP: " + hp);
                            }
                        } else if (a.equals("2")) {
                            System.out.println("You fled!");
                            loc = 0;
                            break;
                        }
                    }
                    if (ehp <= 0) {
                        System.out.println("DRAGON DEFEATED! YOU WIN!");
                        gold += 100;
                        System.out.println("Got 100 gold. Total: " + gold);
                        System.out.println("Game over. Thanks for playing!");
                        hp = 0;
                    }
                } else if (in.equals("2")) {
                    loc = 0;
                }
            }
            if (hp <= 0) {
                System.out.println("You died. Game over.");
            }
        }
    }
}

