package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.MageResorce;

public class Mage extends Player {
    public MageResorce resorce;

    protected Mage(String name, int healthCapacity, int attack, int defense, int mana, int cost) {
        super(name, healthCapacity, attack, defense);
        resorce = new MageResorce(healthCapacity,healthCapacity,mana, cost);
    }

    @Override
    public void CastAbility(Enemy e) {
        messageCallback.send(this.name+"have used Blizzard");

    }
    @Override
    public void processStep() {

    }


}
