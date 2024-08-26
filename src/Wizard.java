import java.util.Scanner;
public class Wizard extends Player
{
    Scanner key = new Scanner(System.in);
    boolean staff;
    int mana;
    int atk;
    int def;


    public Wizard (String name, boolean staff)
    {
        super(name);
        this.staff = staff;
        mana = 20;
        atk = 35;
        if (staff)
        {
            atk += 10;
        }
        def = 35;
    }


    //Getters
    public int getMana()
    {
        return mana;
    }
    public int getAtk()
    {
        return atk;
    }
    public int getDef()
    {
        return def;
    }


    //Brain
    public void spell(Goblin gob)
    {
        System.out.println("Select your attack: 1) Thunder Bolt or 2) Electric Sea.");
        String reply = key.nextLine();


        if (reply.equals("1") || reply.equals("Thunder Bolt"))
        {
            System.out.println("\nThe sky lights up with a white flash as thunder shook the world.");
            gob.health -= 15;
            System.out.println("The goblin's health is at " + gob.health + "/20");
        }
        else
        {
            gob.def -= 10;
        }
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
