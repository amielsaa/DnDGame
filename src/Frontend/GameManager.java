package Frontend;

import Backend.Tile;
import Backend.Tiles.Units.Enemies.Monster;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Tiles.Units.Players.Warrior;
import Backend.Utils.Position;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Frontend.GameLevel.fileParser;

public class GameManager {
    public static void main(String[] args) {

        //player selection
        GameLevel gameLevel = GameLevel.getInstance();
        PlayerSelectionMenu menu  = new PlayerSelectionMenu();
        menu.printMenu();
        Scanner sc = new Scanner(System.in);

        if (args.length<=0) {
            System.out.print("main is a void");
            return;
        }

        String folder=args[0];
        File levelsDir = new File(folder);
        List<File> levelFiles = null;
        if (levelsDir.exists())
            levelFiles = Arrays.stream(levelsDir.listFiles())
                    .filter(s -> s.getName().matches("^level\\d+\\.txt$"))
                    .collect(Collectors.toList());

        for(int i =0;i<levelFiles.size();i++) {
            //levels loop
            gameLevel.loadLevel(levelFiles.get(i));
            GameBoard gameBoard  = gameLevel.getBoard();


        }

//        File levelsDir = new File(folder);
//        List<File> levelFiles = null;
//        if (levelsDir.exists())
//            levelFiles = Arrays.stream(levelsDir.listFiles())
//                    .filter(s -> s.getName().matches("^level\\d+\\.txt$"))
//                    .collect(Collectors.toList());
//        GameBoard board = fileParser.parseLevel(levelFiles.get(0));
//
//        String c ="";
//        Scanner scanner= new Scanner(System.in);
//        board.Printall();
//        Player p=fileParser.player;
//        while(!c.equals("q")) {
//            c=scanner.next();
//            if(c.equals("d")) {
//                System.out.println(p.position);
//                System.out.println(p.position.getRow());
//                Tile t =board.findTile(new Position(p.position.getRow(),p.position.getCol()+1));
//                if(t!= null)
//                    p.SwitchPosition(t);
//                board.SwitchPositions(p,t);
//            }
//            board.Printall();
//
//        }
//        p.setMessageCallback((s)->{System.out.print(s);});
//
        Player x = new Warrior("ariya", 500, 500, 500,3);
        x.setMessageCallback((s)->{System.out.print(s);});
        Enemy e=new Monster('k',"fuck",500,500,500,3,3);
        e.setMessageCallback((s)->{System.out.print(s);});
        e.visit(x);
        List<Enemy> enemies= new LinkedList<Enemy>();
        enemies.add(e);
        x.CastAbility(enemies);
    }
}
