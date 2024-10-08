import java.util.Scanner;
public class Wizard extends Player
{
    Scanner key = new Scanner(System.in);
    boolean staff;
    int atk;
    int def;

    //Constructors
    //Default
    public Wizard()
    {
        super();
        staff = true;
    }
    //Everything
    public Wizard (String name, int health, int coins, boolean staff)
    {
        super(name, health, coins);
        this.staff = staff;
        atk = 35;
        if (staff)
        {
            atk += 10;
        }
        def = 35;
    }

    //Getters
    public int getAtk()
    {
        return atk;
    }
    public int getDef()
    {
        return def;
    }

    //Setters
    public void setStaff(boolean staff)
    {
        this.staff = staff;
    }

    //Brain
    //Purpose: Provide options for Player to act in battle.
    public void spell(Goblin gob)
    {
        System.out.println("Select your attack: 1) Thunder Bolt or 2) Electric Sea.");
        String reply = key.nextLine();


        if (reply.equals("1") || reply.equals("Thunder Bolt"))
        {
            System.out.println("\nThe sky lights up with a white flash as thunder shook the world.");
            gob.health -= 20 - (gob.def/5);
            System.out.println("The goblin's health is at " + gob.health + "/" + gob.maxHealth);
        }
        else
        {
            System.out.println("\nThe electricity is lowering the Goblin's defense!");
            gob.def -= 10;
        }
    }

    //Purpose: Progresses the story, but skips over finding friends.
    public void teleport()
    {
        System.out.println("Perhaps it would be better to simply use your teleportation spell." +
                            "\nUnfortunately, it may mean the expense of your health.");
        int ran = (int)(Math.random() * 5);
        health -= ran;
        System.out.println("You have teleported! Your health is now at " + health + "/" + maxHealth);
    }

    //toString
    @Override
    public String toString()
    {
        String output = super.toString() +
                "\nStaff: " + staff +
                "\nAtk: " + atk +
                "\nDef: " + def;
        return output;
    }
}