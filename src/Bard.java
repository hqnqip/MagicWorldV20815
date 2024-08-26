import java.util.Scanner;
public class Bard extends Player
{
    //Instance Variables
    Scanner key = new Scanner(System.in);
    boolean instrument;
    int mana;
    int atk;
    int def;


    //Constructor
    public Bard (String name, boolean instrument)
    {
        super(name);
        this.instrument = instrument;
        mana = 20;
        atk = 30;
        def = 25;
        if (instrument)
        {
            atk += 10;
            def += 15;
        }
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


    //Setters


    //Brain Methods
    public void sing(Goblin gob)
    {
        System.out.println("Select your song: 1) Song of Healing or 2) Song of Flames?");
        String reply = key.nextLine();
        if (reply.equals("1") || reply.equals("Song of Healing"))
            songOfHealing();
        else
            songOfFlames(gob);
    }


    public void songOfHealing()
    {
        if (health < 16)
        {
            System.out.println("\n♫ Let my heart bravely spread the wings." +
                               "\nSoaring past the night to chase the bright moonlight. ♫");
            health += 5;
            System.out.println("Your health is " + health + ".");
        }
        else
        {
            System.out.println("Maximum health has been achieved.");
        }
    }


    public void songOfFlames(Goblin gob)
    {
        System.out.println("\n♫ Let my heart light up ablaze." +
                           "\nWitness me in the hour of this scorching power. ♫");
        gob.health -= atk / 5;
        System.out.println("The goblin's health is at " + gob.health + "/" + gob.maxHealth);
    }


    //toString
    @Override
    public String toString()
    {
        String output = super.toString() +
                        "\nInstrument: " + instrument +
                        "\nAtk: " + atk +
                        "\nDef: " + def;
        return output;
    }
}
