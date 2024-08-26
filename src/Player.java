import java.util.Scanner;

public class Player
{
    //Instance Variables
    Scanner key = new Scanner(System.in);
    String name;
    int health;
    int maxHealth;
    int coins;


    //Constructor
    public Player (String name)
    {
        this.name = name;
        health = 40;
        maxHealth = health;
        coins = 5;
    }


    //Getters
    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public int getMaxHealth()
    {
        return maxHealth;
    }
    public int getCoins()
    {
        return coins;
    }


    //Setters
    public void setName(String name)
    {
        this.name = name;
    }


    //Brain Method
    public void addCoins(int num)
    {
        coins += num;
    }


    public void backpack()
    {
        System.out.println("\nAccessing your backpack... \n1. Coins \n2. Food \n3. Exit");
        String reply = key.nextLine();
        if (reply.equals("1") || reply.equals("Coins"))
        {
            System.out.println("You have " + coins + " coins.");
        }
        else
        {
            System.out.println("You continue your journey to Meridian.");
        }
    }


    public void escape()
    {
        int ran = (int) (Math.random() * 3);
        if (ran == 1)
        {
            System.out.println("You have successfully escaped the battle.");
        }
        else
        {
            System.out.println("Your foes have become angrier at your attempt to flee.");
        }


    }


    //toString
    public String toString()
    {
        String output = "Name: " + name +
                        "\nHealth: " + health + "/" + maxHealth +
                        "\nCoins: " + coins;
        return output;
    }
}


/*
Player: Name, Health
> Bard: (Healing / Song Attacks)
> Wizard: (Spell Attacks)
> Elf: (Animal Shifter / Physical Attacks)


Enemy: Health, Attack, Defense
*/
