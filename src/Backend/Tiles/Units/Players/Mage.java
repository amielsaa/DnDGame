package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.MageResorce;
import Backend.Utils.NumericGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mage extends Player {
    public MageResorce mageResorce;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(String name, int healthCapacity, int attack, int defense, int mana, int cost, int spellPower, int hitsCount, int abilityRange)
    {
        super(name, healthCapacity, attack, defense);
        mageResorce = new MageResorce(healthCapacity,healthCapacity,mana, cost);
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }

    @Override
    public void CastAbility(List<Enemy> e)
    {
        int hits=0;
        if(mageResorce.getMana()>mageResorce.getCost()) {
            List<Enemy> closeEnemies = new LinkedList<Enemy>();
            for (Enemy enemy : e)
            {
                int distance = this.CheckDistance(enemy);
                if (distance <= abilityRange)
                    closeEnemies.add(enemy);
            }
            for (Enemy enemy : closeEnemies)
            {
                double coinflip = NumericGenerator.getInstance().nextDouble();
                if (coinflip > 0.5) {
                    enemy.acceptAbility(spellPower);
                    hits = hits + 1;
                }
            }
            mageResorce.setMana();
            messageCallback.send(this.name+"have used Blizzard, "+hits+" enemies were hit for "+spellPower+" damage."+"\n");
        }
        else{ messageCallback.send(this.name+" doesn't have enough mana"+"\n");}
    }
    @Override
    public void processStep() {

    }


}
