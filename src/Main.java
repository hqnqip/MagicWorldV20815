import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in); //Instantiates an input-scanner.
        Player one = start(key); //Establishes user-player.
        System.out.println(one.toString());
        mainStory(key, one);
    }


    public static Player start(Scanner key)
    {
        String reply = "";
        boolean weapon;
        Player unknown = new Player ("");
        System.out.println("You have been born anew. You see a light in the darkness." +
                        "\nThree of them. Flames of different colors. Your fate is in" +
                        "\nyour hands. Type a number from 1 to 3.");
        reply = key.nextLine();
        if (reply.equals("1"))
        {
            System.out.println("And what is your name, young spirit?");
            reply = key.nextLine();
            System.out.println(reply + ", a fitting name for a Bard." +
                               "\nWould you like something to aid you in your journey? \n>True \nFalse");
            weapon = key.nextBoolean();
            unknown = new Bard(reply, weapon);
            return unknown;
        }
        //Add if-else for Wizard.
        else if (reply.equals("2"))
        {
            System.out.println("And what is your name, young spirit?");
            reply = key.nextLine();
            System.out.println(reply + ", a fitting name for a Wizard." +
                               "\nWould you like something to aid you in your journey? \n>True \nFalse");
            weapon = key.nextBoolean();
            unknown = new Wizard(reply, weapon);
            return unknown;
        }
        //Add if-else for Elf.
        else
        {
            System.out.println("\nLet us run this once more.");
            unknown = start(key);
        }
        return unknown;
    }


    public static void mainStory(Scanner key, Player one)
    {
        String reply = "";
        System.out.println("\nYou are on your way to enter Mirkwood, a forest of many terrible creatures." +
                           "\nBut the path serves as your only way of finding the hidden elf town, known for " +
                           "\nselling rare jewelry. Oh dear! You come across three angry goblins!");


        Goblin gob = new Goblin(50, 15, 15);


        while (gob.health > 0) {
            gob.strike(one);
            counter(one, gob);
        }


        System.out.println("\nAn elderly man discovers you, who has slain the goblin." +
                           "\nYou were awarded with 15 golden coins.");


        one.addCoins(15);

        one.backpack();
    }


    public static void counter(Player one, Goblin gob)
    {
        if (one instanceof Bard)
            ((Bard)one).sing(gob);
        else if (one instanceof Wizard)
            ((Wizard)one).spell(gob);
    }
}
