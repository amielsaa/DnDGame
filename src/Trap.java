public class Trap extends Enemy {
    int visibleTime;
    int invisbleTime;

    protected Trap(char tile, String name, int healthCapacity, int attack, int defense,int exp,int visableTime,int invisbleTime) {
        super(tile, name, healthCapacity, attack, defense,exp);
        this.visibleTime=visableTime;
        this.invisbleTime=invisbleTime;

    }
}
