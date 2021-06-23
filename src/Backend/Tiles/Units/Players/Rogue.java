package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.RougeResource;

import java.util.List;

public class Rogue extends Player {

    public RougeResource rougeResource;
    protected Rogue(String name, int healthCapacity, int attack, int defense, int energy ,int cost) {
        super(name, healthCapacity, attack, defense);
        rougeResource = new RougeResource(healthCapacity,healthCapacity,energy, cost);
    }

    @Override
    public void CastAbility(List<Enemy> e) {

        messageCallback.send(this.name+"have used Fan of Knifes");
    }

    @Override
    public void processStep() {

    }

}
