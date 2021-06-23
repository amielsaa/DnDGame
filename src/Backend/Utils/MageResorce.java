package Backend.Utils;

public class MageResorce extends Resource {
    private int mana;
    public MageResorce(int currentHealth, int healthCapacity, int mana , int cost) {
        super(currentHealth, healthCapacity);
        this.mana = mana;
    }
    public int getMana() { return mana; }
    public void setMana(int value){ mana = mana+value;}

}
