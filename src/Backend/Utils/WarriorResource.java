package Backend.Utils;

public class WarriorResource extends Resource {

    private int abilitycooldown;
    private int remainingCooldown;
    int defense;
    protected static final int HEALTH_BONUS = 10;

    public WarriorResource(int currentHealth, int healthCapacity, int abilitycooldown,int defense) {
        super(currentHealth, healthCapacity);
        this.abilitycooldown = abilitycooldown;
        remainingCooldown = 0;
        this.defense=defense;
    }
    public int getRemainingCooldown() { return remainingCooldown;}
    public void castedAbility()
    {
        remainingCooldown = abilitycooldown;
        setCurrentHealth(Math.min((getCurrentHealth()+HEALTH_BONUS*defense),getHealthCapacity()));
    }
    public void cooldownOnTick(){
        if(remainingCooldown>0)
            remainingCooldown=remainingCooldown-1;
    }
    public void resetCooldown()
    {remainingCooldown=0;}
}
