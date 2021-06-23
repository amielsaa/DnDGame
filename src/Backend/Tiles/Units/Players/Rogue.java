package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.RougeResource;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {

    public RougeResource rougeResource;
    protected static final int ATTACK_BONUS = 3;

    public Rogue(String name, int healthCapacity, int attack, int defense, int energy, int cost) {
        super(name, healthCapacity, attack, defense);
        rougeResource = new RougeResource(healthCapacity,healthCapacity, cost);
    }

    @Override
    public void CastAbility(List<Enemy> e) {
        if(rougeResource.getEnergy()>rougeResource.getCost()) {
            int hits=0;
            for (Enemy enemy : e)
            {
                int distance = this.CheckDistance(enemy);
                if (distance <2 )
                {
                    enemy.acceptAbility(this,attack);
                    hits = hits+1;
                }
            }
            rougeResource.setEnergy();
            messageCallback.send(this.name + "have used Fan of Knifes, "+hits+" enemies were hit."+"\n");
        }
        else{ messageCallback.send(this.name+" doesn't have enough energy"+"\n");}
    }

    @Override
    public void levelUp()
    {
        int attackAdd = ATTACK_BONUS*(level+1);
        super.levelUp(0,attackAdd,0);
        rougeResource.resetEnergy();
    }

}
