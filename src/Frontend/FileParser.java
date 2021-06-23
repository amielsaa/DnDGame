package Frontend;

import Backend.Tiles.Empty;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Tiles.Units.Players.Warrior;
import Backend.Tiles.Wall;
import Backend.Utils.Position;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

class FileParser {
    List<String> arr;
    TileFactory tileFactory = new TileFactory();
    public Player player;
    public GameBoard parseLevel(File levelFile) {
        try {
            arr = Files.readAllLines(levelFile.toPath());
        } catch (Exception e) {
            throw new IllegalArgumentException("could not load level");
        }
        GameBoard board = new GameBoard();
        GameLevel m = GameLevel.getInstance();
        Player player;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                Position p = new Position(i, j);
                switch (arr.get(i).charAt(j)) {
                    case '#':
                        board.add(new Wall(p));
                        break;
                    case '.':
                        board.add(new Empty(p));
                        break;
                    case '@':
                        this.player = new Warrior("ariya", 500, 500, 500);
                        this.player.initialize(p);
                        this.player.setPosition(p);
                        board.add(this.player);
                        break;
                    default:
                        Enemy e = tileFactory.enemiesMap.get(arr.get(i).charAt(j)).get();
                        e.setDeathCallback(() -> m.onEnemyDeath(e));
                        e.setMessageCallback((msg) -> System.out.println(msg));
                        board.add(e);
                        e.initialize(p);
                        break;
                }
            }
            //TODO
            //clone enemy


        }
        return board;
    }
}