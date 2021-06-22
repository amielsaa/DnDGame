package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Player;

public class Warrior extends Player {

    protected Warrior(String name, int healthCapacity, int attack, int defense) {
        super(name, healthCapacity, attack, defense);

    }

    @Override
    public void CastAbility() {
      messageCallback.send(this.name+" have have used Avengers Shield"+"\n");


    }

    @Override
    public void processStep() {


    }
}
