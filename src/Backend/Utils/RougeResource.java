package Backend.Utils;

public class RougeResource extends Resource{
    private int energy;
    private int cost;
    public RougeResource(int currentHealth, int healthCapacity ,int energy, int cost) {
        super(currentHealth, healthCapacity);
        this.energy = energy;
        this.cost = cost;
    }

    public int getEnergy() { return energy; }
    public int getCost(){return cost;}
    public void setEnergy() { energy = energy-cost; }
    public void energyOnTick() {
        if(energy>90)
            energy=100;
        else
            energy = energy+10;
    }
}
