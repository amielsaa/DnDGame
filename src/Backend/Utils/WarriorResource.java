package Backend.Utils;

public class WarriorResource extends Resource {

    private int abilitycooldown;
    private int remainingCooldown;
    int defense;
    public WarriorResource(int currentHealth, int healthCapacity, int abilitycooldown,int defense) {
        super(currentHealth, healthCapacity);
        this.abilitycooldown = abilitycooldown;
        remainingCooldown = 0;
        this.defense=defense;
    }
    public int getRemainingCooldown() { return remainingCooldown;}
    public void castedAbility(){
        remainingCooldown = abilitycooldown;
        if(getCurrentHealth()>getHealthCapacity()-10*defense)
            setCurrentHealth(getHealthCapacity());
        else
            setCurrentHealth(getCurrentHealth()+10*defense);
    }
    public  void cooldownOnTick(){
        if(remainingCooldown>0)
            remainingCooldown=remainingCooldown-1;
    }
}
