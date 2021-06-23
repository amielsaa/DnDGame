package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.NumericGenerator;
import Backend.Utils.WarriorResource;

import java.util.LinkedList;
import java.util.List;

public class Warrior extends Player {

    public WarriorResource warriorResource;
    public Warrior(String name, int healthCapacity, int attack, int defense, int cooldown) {
        super(name, healthCapacity, attack, defense);
        warriorResource = new WarriorResource(healthCapacity,healthCapacity,cooldown,defense);

    }

    @Override
    public void CastAbility(List<Enemy> e) {
        if(warriorResource.getRemainingCooldown()==0) {
            List<Enemy> closeEnemies = new LinkedList<Enemy>();
            for (Enemy enemy : e) {
                int distance = this.CheckDistance(enemy);
                if (distance < 3)
                    closeEnemies.add(enemy);
            }
            messageCallback.send(this.name+" have have used Avengers Shield"+"\n");
            int index = (int)Math.round(NumericGenerator.getInstance().nextDouble()*(closeEnemies.size()-1));
            closeEnemies.get(index).acceptAbility((int)(Math.round(0.1*warriorResource.getHealthCapacity())));
            warriorResource.castedAbility();

        }
        else
            messageCallback.send("ability cool down hasn't reset yet"+"\n");




    }

    @Override
    public void processStep() {


    }
}
