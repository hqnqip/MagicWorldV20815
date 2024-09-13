import java.util.Scanner;
public class Player
{
    //Instance Variables
    Scanner key = new Scanner(System.in);
    String name;
    int health;
    int maxHealth;
    int coins;

    //Constructors
    //Default
    public Player()
    {
        name = "Gandalf";
        health = 40;
        maxHealth = health;
        coins = 5;
    }
    //Everything
    public Player (String name, int health, int coins)
    {
        this.name = name;
        this.health = health;
        maxHealth = health;
        this.coins = coins;
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
    public void setCoins(int coins)
    {
        this.coins = coins;
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
            System.out.println("You decided to leave your backpack alone.");
        }
    }

   /*
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
   */

    //toString
    public String toString()
    {
        String output = "Name: " + name +
                "\nHealth: " + health + "/" + maxHealth +
                "\nCoins: " + coins;
        return output;
    }
}