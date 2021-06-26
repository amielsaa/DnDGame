package Backend.Tiles.Units;

import Backend.Tiles.Empty;
import Backend.Tiles.Units.Enemies.Monster;
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
    //static GameBoard gameBoard;

    @BeforeAll
    static void setUpBeforeAll() {
        tileFactory = new TileFactory();
        player = new Warrior("roobs", 300, 30, 4, 3);
        //player = new Warrior("Ari Snow",400,50,5,3);
        enemies = new ArrayList<Enemy>();
        //gameBoard = new GameBoard();

    }

    void initializeEnemies() {

        Enemy e=new Monster('k',"enemy1",200,14,8,4,50);
        Enemy a=new Monster('s',"enemy2",200,14,8,4,50);
        Enemy b=new Monster('a',"enemy3",200,14,8,4,50);
        Enemy c=new Monster('b',"enemy4",200,14,8,4,50);
        Enemy d=new Monster('d',"enemy5",200,14,8,4,50);
        Enemy f=new Monster('j',"enemy6",200,14,8,4,50);
        e.position = new Position(0,2);
        a.position = new Position(0,1);
        b.position = new Position(1,0);
        c.position = new Position(1,1);
        d.position = new Position(2,0);
        f.position = new Position(1,3);
        e.setMessageCallback((s)->{System.out.print(s);});
        a.setMessageCallback((s)->{System.out.print(s);});
        b.setMessageCallback((s)->{System.out.print(s);});
        c.setMessageCallback((s)->{System.out.print(s);});
        d.setMessageCallback((s)->{System.out.print(s);});
        f.setMessageCallback((s)->{System.out.print(s);});
        enemies.add(e);
        enemies.add(a);
        enemies.add(b);
        enemies.add(c);
        enemies.add(d);
        enemies.add(f);
        /*
        enemyList.add(tileFactory.enemiesMap.get('s').get());
        enemyList.add(tileFactory.enemiesMap.get('s').get());
        enemyList.add(tileFactory.enemiesMap.get('s').get());
        enemyList.add(tileFactory.enemiesMap.get('k').get());
        enemyList.add(tileFactory.enemiesMap.get('Q').get()); // 4 - trap
        enemyList.add(tileFactory.enemiesMap.get('w').get());
        enemyList.add(tileFactory.enemiesMap.get('z').get());
        enemyList.add(tileFactory.enemiesMap.get('q').get());

        enemyList.get(0).initialize(new Position(10,13));
        enemyList.get(1).initialize(new Position(9,9));
        enemyList.get(2).initialize(new Position(9,10));
        enemyList.get(3).initialize(new Position(10,9));
        enemyList.get(4).initialize(new Position(8,10));
        enemyList.get(5).initialize(new Position(11,10));
        enemyList.get(6).initialize(new Position(14,13));
        enemyList.get(7).initialize(new Position(13,9));*/
    }



    @BeforeEach
    void setUp() {
        player.initialize(new Position(0,0),(msg) -> System.out.println(msg),()->{} ,()->'s');
        initializeEnemies();
        //initializeBoard();

    }

    @AfterEach
    void tearDown() {
        enemies = new ArrayList<>();
    }




    @Test
    void accept_empty_tile() {
        player.visit(new Empty(new Position(10,9)));
        boolean row = player.getPosition().getRow()==10;
        boolean col = player.getPosition().getCol()==9;


        Assertions.assertEquals(row & col, true);
    }

    @Test
    void visit() {
    }

    @Test
    void testVisit() {
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

        Assertions.assertEquals(260,player.getResource().getCurrentHealth());
    }

    @Test
    void acceptAbility() {

    }

    @Test
    void resourcesOnTick() {

    }

    @Test
    void visibilityOnTick() {

    }





}