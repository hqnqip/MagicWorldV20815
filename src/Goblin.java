public class Goblin
{
    //Instance Variables
    int health;
    int maxHealth;
    int atk;
    int def;

    //Constructors
    //Default
    public Goblin()
    {
        health = 50;
        maxHealth = health;
        atk = 30;
        def = 30;
    }
    //Everything
    public Goblin (int health, int atk, int def)
    {
        this.health = health;
        maxHealth = health;
        this.atk = atk;
        this.def = def;
    }

    //Brain Methods
    public void strike(Player one)
    {
        System.out.println("\nRah! The goblin strikes!");
        int ran = (int)(Math.random() * 3);
        if (ran == 1)
        {
            System.out.println("You managed to avoid the attack.");
        }
        else
        {
            one.health -= 3;
            System.out.println("Your health is " + one.health + "/" + one.maxHealth);
        }
    }

    public void takeCoins(Player one)
    {
        System.out.println("You watch the goblin try to sneak up from behind.");
        int ran = (int)(Math.random() * 2);
        if (ran == 1)
        {
            System.out.println("Alas, the goblin failed to steal your coins!");
        }
        else
        {
            one.coins -= 5;
            if (one.coins < 0)
                one.setCoins(0);
            System.out.println("Oh my! The goblin has come to take your coins!");
        }
    }

    //toString
    public String toString()
    {
        String output = "\nHealth: " + health +
                "\nAtk: " + atk +
                "\nDef: " + def;
        return output;
    }
}