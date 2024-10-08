import java.util.Scanner;

public class Elf extends Player
{
    Scanner key = new Scanner(System.in);
    String animal;
    int strength;

    //Constructors
    public Elf()
    {
        super();
        animal = "Bear";
        strength = 80;
    }

    public Elf(String name, int health, int coins, String animal, int strength)
    {
        super(name, health, coins);
        this.animal = animal;
        this.strength = strength;


        if (animal.equals("Bear"))
            this.strength += 30;
        else
            this.strength += 10;
    }

    //Getters
    public String getAnimal()
    {
        return animal;
    }
    public int getStrength()
    {
        return strength;
    }

    //Setters
    public void setAnimal(String animal)
    {
        this.animal = animal;
    }
    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    //Brain Method
    public void elfAct(Goblin gob)
    {
        System.out.println("Enter the following options: \n> 1) Claw\n> 2) Tame");
        String reply = key.nextLine();
        if (reply.equals("Claw") || reply.equals("1"))
            claw(gob);
        else
            tame(gob);
    }

    public void claw(Goblin gob)
    {
        if (animal.equals("Bear"))
        {
            gob.health -= (strength / 3);
            System.out.println("You roared, standing up on your hind legs, and swung your arm down at the enemy." +
                                "\nThe goblin's health is currently " + gob.health + "/" + gob.maxHealth);
        }
        else
        {
            //Add more User options....
            gob.health -= (strength / 4);
            System.out.println("You screeched, diving down at the goblin and swiping your talons!" +
                                "\nThe goblin cried. Their health is currently " + gob.health + "/" + gob.maxHealth);
        }
    }

    public void tame(Goblin gob)
    {
        int ran = (int)(Math.random() * 2);
        if (ran == 1)
        {
            gob.health = 0;
            System.out.println("The goblin fainted from your small act of kindness." +
                                "\nYou are able to escape this goblin.");
        }
        else
        {
            System.out.println("\nWell...");
        }
    }

    //toString
    @Override
    public String toString()
    {
        String output = super.toString() +
                "\nAnimal: " + animal +
                "\nStrength: " + strength;
        return output;
    }
}