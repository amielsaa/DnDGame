package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Player;

public class Rogue extends Player {
    protected Rogue(String name, int healthCapacity, int attack, int defense) {
        super(name, healthCapacity, attack, defense);
    }

    @Override
    public void CastAbility() {
        messageCallback.send(this.name+"have used Fan of Knifes");
    }

    @Override
    public void processStep() {

    }
}
