package Backend.Tiles.Units;

import Backend.Tiles.Empty;
import Backend.Tiles.Units.Enemies.Monster;
import Backend.Tiles.Units.Enemies.Trap;
import Backend.Tiles.Units.Players.Mage;
import Backend.Tiles.Units.Players.Warrior;
import Backend.Utils.Position;
import Frontend.GameBoard;
import Frontend.TileFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    static TileFactory tileFactory;
    static Player player;
    static List<Enemy> enemies;

    @BeforeAll
    static void setUpBeforeAll() {
        tileFactory = new TileFactory();
        player = new Warrior("Jon Snow", 300, 30, 4, 3);
        enemies = new ArrayList<Enemy>();

    }

    void initializeEnemies() {

        Enemy e=new Monster('k',"enemy1",200,14,8,4,50);
        Enemy a=new Monster('s',"enemy2",200,14,8,4,50);
        Enemy c=new Monster('b',"enemy3",200,14,8,4,50);
        Enemy d=new Monster('d',"enemy4",1000,1000,8,4,50);
        Enemy f=new Trap('j',"TRAP",500, 100, 20, 250, 1, 10);
        e.position = new Position(0,2);
        a.position = new Position(0,1);
        c.position = new Position(1,1);
        d.position = new Position(2,0);
        f.position = new Position(1,0);

        enemies.add(e);
        enemies.add(a);
        enemies.add(c);
        enemies.add(d);
        enemies.add(f);

        for(Enemy enemy : enemies) {
            enemy.setMovementCallback((m,s)->{});
            enemy.setMessageCallback((s)->{System.out.print(s);});
            enemy.setDeathCallback(()->{});
        }

    }



    @BeforeEach
    void setUp() {
        player = new Warrior("Jon Snow", 300, 30, 4, 3);
        player.initialize(new Position(0,0),(msg) -> System.out.println(msg),()->{} ,()->'s');
        player.setMovementCallback((m,s)->{});
        initializeEnemies();
    }

    @AfterEach
    void tearDown() {
        enemies = new ArrayList<>();
    }



    @Test
    void visit_trap() {
        enemies.get(4).setDefense(0);
        player.setAttack(1000);
        while(enemies.get(4).getResource().getCurrentHealth()>0){
            enemies.get(4).visit(player);
        }

        Assertions.assertEquals(0,enemies.get(4).getResource().getCurrentHealth());
    }


    @Test
    void accept_empty_tile() {
        player.visit(new Empty(new Position(10,9)));
        boolean row = player.getPosition().getRow()==10;
        boolean col = player.getPosition().getCol()==9;


        Assertions.assertEquals(row & col, true);
    }


    @Test
    void levelUp() {
        player.gaindExperience(60);

        Assertions.assertEquals(2,player.getLevel());

    }
    @Test
    void castAbility() {
        player.heal(230);
        player.CastAbility(enemies);

        Assertions.assertEquals(270,player.getResource().getCurrentHealth());
    }

    @Test
    void castAbility_one_enemy() {
        player.heal(230);
        List<Enemy> enemyList = new ArrayList<>();
        enemies.get(0).setDefense(0);
        enemyList.add(enemies.get(0));
        player.CastAbility(enemyList);
        int damage = (int)Math.round(0.1*player.getResource().getHealthCapacity());

        Assertions.assertEquals(200-damage,enemyList.get(0).getResource().getCurrentHealth());
    }

    @Test
    void visit_enemy() {
        enemies.get(1).setDefense(0);
        enemies.get(1).visit(player);

        Assertions.assertTrue(enemies.get(1).getResource().getCurrentHealth()<=200);

    }

    @Test
    void visit_player() {
        player.setDefense(0);
        player.visit(enemies.get(0));

        Assertions.assertTrue(player.getResource().getCurrentHealth()<300);

    }

    @Test
    void visit_player_attack_zero() {
        enemies.get(0).setAttack(0);
        player.visit(enemies.get(0));

        Assertions.assertTrue(player.getResource().getCurrentHealth()==300);

    }


    @Test
    void player_death() {
        while(player.getResource().getCurrentHealth()>0){
            player.visit(enemies.get(3));
        }

        Assertions.assertTrue(!player.alive());
    }

    @Test
    void monster_death() {
        while(enemies.get(0).getResource().getCurrentHealth()>0){
            enemies.get(0).visit(player);
        }

        Assertions.assertEquals(0,enemies.get(0).getResource().getCurrentHealth());
    }





}