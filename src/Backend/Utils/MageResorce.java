package Backend.Utils;

public class MageResorce extends Resource {
    private int manaPool;
    private int currentMana;
    private int cost;
    public MageResorce(int currentHealth, int healthCapacity, int mana , int cost) {
        super(currentHealth, healthCapacity);
        currentMana = mana;
        this.cost = cost;
        manaPool = mana;
    }
    public int getMana() { return currentMana; }
    public int getCost(){return cost;}
    public void setMana(){ currentMana = currentMana-cost;}



}
