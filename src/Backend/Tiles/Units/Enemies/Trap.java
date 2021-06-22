package Backend.Tiles.Units.Enemies;

import Backend.Tiles.Units.Enemy;

public class Trap extends Enemy {
    int visibleTime;
    int invisbleTime;

    public Trap(char tile, String name, int healthCapacity, int attack, int defense, int exp, int visableTime, int invisbleTime) {
        super(tile, name, healthCapacity, attack, defense,exp);
        this.visibleTime=visableTime;
        this.invisbleTime=invisbleTime;

    }
}
