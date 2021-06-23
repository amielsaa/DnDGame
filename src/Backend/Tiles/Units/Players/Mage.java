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

    protected Mage(String name, int healthCapacity, int attack, int defense, int mana, int cost, int spellPower, int hitsCount, int abilityRange)
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
        messageCallback.send(this.name+"have used Blizzard");
        List<Enemy> closeEnemys = new LinkedList<Enemy>();
        if(mageResorce.getMana()>mageResorce.getCost()) {
            for (Enemy enemy : e)
            {
                int distance = this.CheckDistance(enemy);
                if (distance <= abilityRange)
                    closeEnemys.add(enemy);
            }
            for (Enemy enemy : closeEnemys)
            {
                double coinflip = NumericGenerator.getInstance().nextDouble();
                if (coinflip > 0.5) {
                    enemy.acceptAbility(spellPower);
                }
                mageResorce.setMana();
            }
        }
    }
    @Override
    public void processStep() {

    }


}
