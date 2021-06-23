package Backend.Utils;

public class RougeResource extends Resource{
    private int energy;
    public RougeResource(int currentHealth, int healthCapacity ,int energy, int cost) {
        super(currentHealth, healthCapacity);
        this.energy = energy;
    }

    public int getEnergy() { return energy; }
    public void setEnergy(int value) { energy = energy+value; }
}
