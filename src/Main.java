//Updated 8:03 PM
//Importing Scanner for User Input.
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Instantiates an input-scanner.
        Scanner key = new Scanner(System.in);
        //Instantiates Player (User) Object.
        Player one = start(key);
        //Checking Player Attributes.
        System.out.println(one.toString());
        //Beginning the Main Plot with Scanner and Player.
        mainStory(key, one);
    }

    //Instantiate Player Object.
    //Allows Player to select between Bard, Wizard, and Elf.
    public static Player start(Scanner key)
    {
        String reply = ""; //For User Input.
        boolean weapon; //Add to Bard/Wizard/Elf Constructor.
        Player unknown = new Player(); //Empty Player Object.
        System.out.println("""
                           You have been born anew. You see a light in the darkness.
                           Three of them. Flames of different colors. Your fate is in
                           your hands. Type a number from 1 to 3.""");

        //User Chooses Player Class.
        reply = key.nextLine();

        //This is for Bard.
        if (reply.equals("1"))
        {
            unknown = new Bard("", 40, 5, false);
            System.out.println("And what is your name, young spirit?");
            reply = key.nextLine();
            System.out.println(reply + ", a fitting name for a Bard." +
                    "\nWould you like something to aid you in" +
                    "your journey? \n> True \n> False");
            weapon = key.nextBoolean();
            unknown.setName(reply);
            ((Bard)unknown).setInstrument(weapon);
            return unknown;
        }
        //This is for Wizard.
        else if (reply.equals("2"))
        {
            unknown = new Wizard("", 40, 40, false);
            System.out.println("And what is your name, young spirit?");
            reply = key.nextLine();
            System.out.println(reply + ", a fitting name for a Wizard." +
                    "\nWould you like something to aid you in your journey?" +
                    "\n> True \n> False");
            weapon = key.nextBoolean();
            unknown.setName(reply);
            ((Wizard)unknown).setStaff(weapon);
            return unknown;
        }
        else if (reply.equals("3"))
        {
            unknown = new Elf("", 40, 40, "", 0);
            System.out.println("And what is your name, young spirit?");
            reply = key.nextLine();
            unknown.setName(reply);
            System.out.println(reply + ", a fitting name for an Elf." +
                    "\nWhat animal shall accompany you in form and spirit?" +
                    "\n> Bear \n> Eagle");
            reply = key.nextLine();
            ((Elf)unknown).setAnimal(reply);
            return unknown;
        }
        else
        {
            System.out.println("\nLet us run this once more.");
            unknown = start(key);
        }
        return unknown;
    }

    //This is the Main Story Prompts.
    public static void mainStory(Scanner key, Player one)
    {
        String reply = "";
        System.out.println("""
                           \nYou are on your way to enter Mirkwood, a forest of many terrible creatures.
                           But the path serves as your only way of finding the hidden elf town, known for\s
                           selling rare jewelry. Oh dear! You come across an angry goblin!\n\nEntering battle...""");

        Goblin gob = new Goblin(50, 15, 15);
        System.out.println(gob.toString());

        gob.takeCoins(one);

        while (gob.health > 0) {
            gob.strike(one);
            counter(one, gob);
            if (gob.health <= 0)
            {
                System.out.println("\nBATTLE SUCCESSFUL!");
            }
        }

        System.out.println("\nOh no!\nAnd yet another one!\n\nEntering battle...");

        Goblin gobTwo = new Goblin();

        while (gobTwo.health > 0) {
            gobTwo.strike(one);
            counter(one, gobTwo);
            if (gobTwo.health <= 0)
            {
                System.out.println("\nBATTLE SUCCESSFUL!");
            }
        }

        System.out.println("""
                           \nAn elderly man discovers you, who has slain the goblins.
                           You were awarded with 15 golden coins.""");

        one.addCoins(15);
        one.backpack();

        System.out.println("\nYou continue your journey to Meridian.");

        if (one instanceof Wizard)
            ((Wizard)one).teleport();
        else
        {
            System.out.println("\nOn the way, you met a duo of strange yet warming folk.");
            Bard drunkBard = new Bard("Venti", 30, 10, true);
            Wizard whiteBeard = new Wizard("Golly", 80, 30, true);
            Elf bearElf = new Elf();

            System.out.println("A wizard speaks, \"Hello there, you must be " + one.getName() + "! I am " +
                                whiteBeard.getName() + ".\"\nTheir friend of a short stature says, \"The name's " +
                                drunkBard.getName() + "!\"\n\nAnd there is another  who does not like to speak....");

            System.out.println("\n" + whiteBeard.toString() + "\n\n" + drunkBard.toString() + "\n\n" + bearElf.toString());
        }
    }

    //Purpose: Player attacks.
    public static void counter(Player one, Goblin gob)
    {
        if (one instanceof Bard)
            ((Bard)one).sing(gob);
        else if (one instanceof Wizard)
            ((Wizard)one).spell(gob);
        else //(one instanceof Elf)
            ((Elf)one).elfAct(gob);
    }
}