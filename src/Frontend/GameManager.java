package Frontend;

import Backend.Tile;
import Backend.Tiles.Units.Enemies.Monster;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Tiles.Units.Players.Mage;
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
        Scanner sc = new Scanner(System.in);
        GameLevel gameLevel = GameLevel.getInstance();
        PlayerSelectionMenu menu  = new PlayerSelectionMenu();
        menu.printMenu();


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
        boolean won = true;



        for(int i = 0;i<levelFiles.size() & won;i++) {
            //levels loop

            gameLevel.loadLevel(levelFiles.get(i));
            Player player = gameLevel.getPlayer();

            //game loop
            while(player.alive() && gameLevel.enemies.size()>0){
                String input = sc.next();
                gameLevel.tick(input);
            }
            if(!player.alive()){
                System.out.println("\n" +
                        "██╗░░░██╗░█████╗░██╗░░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗\n" +
                        "╚██╗░██╔╝██╔══██╗██║░░░██║  ██║░░░░░██╔══██╗██╔════╝██╔════╝\n" +
                        "░╚████╔╝░██║░░██║██║░░░██║  ██║░░░░░██║░░██║╚█████╗░█████╗░░\n" +
                        "░░╚██╔╝░░██║░░██║██║░░░██║  ██║░░░░░██║░░██║░╚═══██╗██╔══╝░░\n" +
                        "░░░██║░░░╚█████╔╝╚██████╔╝  ███████╗╚█████╔╝██████╔╝███████╗\n" +
                        "░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚══════╝░╚════╝░╚═════╝░╚══════╝");
            }
            won = player.alive() & gameLevel.enemies.size()== 0;
            if(won & levelFiles.size() == i+1){
                System.out.println("\n" +
                        "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗░█████╗░███╗░░██╗\n" +
                        "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██╔══██╗████╗░██║\n" +
                        "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║░░██║██╔██╗██║\n" +
                        "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║░░██║██║╚████║\n" +
                        "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░╚█████╔╝██║░╚███║\n" +
                        "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚══╝");
            }




        }


    }


}
