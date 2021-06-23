package Backend.Utils;

public class MageResorce extends Resource {
    private int manaPool;
    private int currentMana;
    private int cost;
    public MageResorce(int currentHealth, int healthCapacity, int mana , int cost) {
        super(currentHealth, healthCapacity);
        currentMana = mana/4;
        this.cost = cost;
        manaPool = mana;
    }
    public void setUponLevelUp(int mana)
    {
        manaPool = manaPool+mana;
        if(currentMana>manaPool*0.75)
            currentMana = manaPool;
        else
            currentMana =(int)Math.round(manaPool*1.25);
    }
    public int getMana() { return currentMana; }
    public int getCost(){return cost;}
    public void setMana(){ currentMana = currentMana-cost;}



}
