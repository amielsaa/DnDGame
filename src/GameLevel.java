import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GameLevel {

    private GameBoard gameBoard;
    private Player player;
    private List<Enemy> enemies;
    public static FileParser fileParser=new FileParser();
    //TODO
    //המשחק בנוי על לעשות לולאת while אחת גדולה שכל עוד השחקן לא מת אני מקבל קלט  תנועה או קאסט אביליטי וכל השאר בהתאם.



    public void tick(){


    }
    public void onPlayerDeath(){

    }

    public void onEnemyDeath(Enemy e){

    }

    @Override
    public String toString() {
        return String.format("%s\n%s", gameBoard, player.describe());
    }

    public static void main(String[] args) {
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
        GameBoard board = fileParser.parseLevel(levelFiles.get(0));

        String c ="";
        Scanner scanner= new Scanner(System.in);
        board.Printall();
        Player p=fileParser.player;
        while(!c.equals("q")) {
            c=scanner.next();
            if(c.equals("d")) {
                System.out.println(p.position);
                System.out.println(p.position.getRow());
                Tile t =board.findTile(new Position(p.position.getRow(),p.position.getCol()+1));
                if(t!= null)
                p.SwitchPosition(t);
                board.SwitchPositions(p,t);
            }
                board.Printall();

        }
        p.setMessageCallback((s)->{System.out.print(s);});

        Player x = new Warrior("ariya", 500, 500, 500);
        x.setMessageCallback((s)->{System.out.print(s);});
        Enemy e=new Monster('k',"fuck",500,500,500,3,3);
        e.setMessageCallback((s)->{System.out.print(s);});
        e.visit(x);
        x.CastAbility();
    }
}
