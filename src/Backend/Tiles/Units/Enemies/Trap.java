package Backend.Tiles.Units.Enemies;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.TrapResource;

public class Trap extends Enemy {
   public TrapResource trapResource;
    int vision;
    public Trap(char tile, String name, int healthCapacity, int attack, int defense, int exp, int visableTime, int invisbleTime) {
        super(tile, name, healthCapacity, attack, defense,exp);
        trapResource = new TrapResource(healthCapacity, visableTime, invisbleTime,visibilityCallBack);
        vision = 2;

    }
    @Override
    public void processStep(Player p) {
        trapResource.visibilityOnTick();
        if(position.checkDistance(p.position)<vision)
            p.visit(this);
    }
    @Override
    public void updateResources(){}
}
