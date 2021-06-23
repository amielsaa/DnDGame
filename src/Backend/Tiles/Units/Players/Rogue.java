package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.RougeResource;

public class Rogue extends Player {

    public RougeResource resource;
    protected Rogue(String name, int healthCapacity, int attack, int defense, int energy ,int cost) {
        super(name, healthCapacity, attack, defense);
        resource = new RougeResource(healthCapacity,healthCapacity,energy, cost);
    }

    @Override
    public void CastAbility(Enemy e) {

        messageCallback.send(this.name+"have used Fan of Knifes");
    }

    @Override
    public void processStep() {

    }

}
