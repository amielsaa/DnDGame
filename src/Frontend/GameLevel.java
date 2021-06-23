package Frontend;

import Backend.Tile;
import Backend.Tiles.Units.Enemies.Monster;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Tiles.Units.Players.Warrior;
import Backend.Utils.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GameLevel {

    private GameBoard gameBoard;
    private Player player;
    public List<Enemy> enemies;
    public static FileParser fileParser;

    private static GameLevel instance;
    //TODO
    //המשחק בנוי על לעשות לולאת while אחת גדולה שכל עוד השחקן לא מת אני מקבל קלט  תנועה או קאסט אביליטי וכל השאר בהתאם.

    private GameLevel() {
        fileParser = new FileParser();
        enemies = new ArrayList<>();
    }

    public static GameLevel getInstance() {
        if(instance == null) {
            instance = new GameLevel();
        }
        return instance;
    }
    public FileParser getFileParser(){
        return fileParser;
    }
    public void tick(String action){
        Action act = convertToAction(action);
        if(action.length()>1 && act!=null){
            player.setInputProvider(()->{return act;});
        }


    }
    public void onPlayerDeath(){

    }

    public void onEnemyDeath(Enemy e){

    }

    public Player getPlayer(){
        return player;
    }
    public GameBoard getBoard() {
        return gameBoard;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Action convertToAction(String action) {
        switch (action.toLowerCase().charAt(0)) {
            case 'a':
                return Action.Left;
            case 'd':
                return Action.Right;
            case 's':
                return Action.Down;
            case 'w':
                return Action.Up;
            case 'e':
                return Action.CastAbility;
            default:
                return null;
        }
    }
    public void loadLevel(File level) {




        gameBoard = fileParser.parseLevel(level, player);
        gameBoard.Printall();



//        String c ="";
//        Scanner scanner= new Scanner(System.in);
//
//        Player p=fileParser.player;
//        while(!c.equals("q")) {
//            c=scanner.next();
//            if(c.equals("d")) {
//                System.out.println(p.position);
//                System.out.println(p.position.getRow());
//                Tile t =gameBoard.findTile(new Position(p.position.getRow(),p.position.getCol()+1));
//                if(t!= null)
//                    p.SwitchPosition(t);
//                gameBoard.SwitchPositions(p,t);
//            }
//            gameBoard.Printall();
//
//        }
//        p.setMessageCallback((s)->{System.out.print(s);});
//
//        Player x = new Warrior("ariya", 500, 500, 500);
//        x.setMessageCallback((s)->{System.out.print(s);});
//        Enemy e=new Monster('k',"fuck",500,500,500,3,3);
//        e.setMessageCallback((s)->{System.out.print(s);});
//        e.visit(x);
//        x.CastAbility();


    }

    @Override
    public String toString() {
        return String.format("%s\n%s", gameBoard, player.describe());
    }

//    public static void main(String[] args) {
////        if (args.length<=0) {
////            System.out.print("main is a void");
////            return;
////        }
////        String folder=args[0];
////        File levelsDir = new File(folder);
////        List<File> levelFiles = null;
////        if (levelsDir.exists())
////            levelFiles = Arrays.stream(levelsDir.listFiles())
////                    .filter(s -> s.getName().matches("^level\\d+\\.txt$"))
////                   .collect(Collectors.toList());
////        GameBoard board = fileParser.parseLevel(levelFiles.get(0));
////
////        String c ="";
////        Scanner scanner= new Scanner(System.in);
////        board.Printall();
////        Player p=fileParser.player;
////        while(!c.equals("q")) {
////            c=scanner.next();
////            if(c.equals("d")) {
////                System.out.println(p.position);
////                System.out.println(p.position.getRow());
////                Tile t =board.findTile(new Position(p.position.getRow(),p.position.getCol()+1));
////                if(t!= null)
////                p.SwitchPosition(t);
////                board.SwitchPositions(p,t);
////            }
////                board.Printall();
////
////        }
////        p.setMessageCallback((s)->{System.out.print(s);});
////
////        Player x = new Warrior("ariya", 500, 500, 500);
////        x.setMessageCallback((s)->{System.out.print(s);});
////        Enemy e=new Monster('k',"fuck",500,500,500,3,3);
////        e.setMessageCallback((s)->{System.out.print(s);});
////        e.visit(x);
////        x.CastAbility();
////    }
}
