public class Goblin
{
    int health;
    int maxHealth;
    int atk;
    int def;


    public Goblin (int health, int atk, int def)
    {
        this.health = health;
        maxHealth = health;
        this.atk = atk;
        this.def = def;
    }


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


    //toString
    public String toString()
    {
        String output = "\nHealth: " + health +
                        "\nAtk: " + atk +
                        "\nDef: " + def;
        return output;
    }
}

/*


























*/
