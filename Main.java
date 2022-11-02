import java.util.*;
import java.awt.*;

/**
 * Main class for Blocky 2d Art Maker
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
class Main {

  /**
   * Main method for Blocky 2d Art Maker, allows you to test the program with a simple, console based UI
   */
  public static void main(String[] args) {
    DisplayRunner runner = new DisplayRunner();
    Thread run = new Thread(runner);
    run.start();

    Scanner input = new Scanner(System.in);
    System.out.print("Welcome to the Blocky 2d Art Maker! Click on the window & press on your arrow keys to scroll. Alternately, use the console to change tiles.");
    while (true){
      System.out.println("What would you like to do? \n(1) Fill tile layer \n(2) Set tile \n(3) Randomly generate tile layer \n(4) Fill item layer \n(5) Set item \n(6) Randomly generate item layer \n(7) Save as image");
      int choice = input.nextInt();
      switch (choice){
        case 1:
          System.out.println("What tile would you like to fill with?");
          for (var i = 0; i<Tiles.ALL.size(); i++){
            System.out.println(i+") "+Tiles.ALL.get(i));
          }
          int tile = input.nextInt();
          if (tile<Tiles.ALL.size())
            runner.map.fillTileLayer(Tiles.ALL.get(tile));
          else
            System.out.println("Tile not Found");
          break;
        case 2:
          System.out.println("What tile would you like to set with?");
          for (var i = 0; i<Tiles.ALL.size(); i++){
            System.out.println(i+") "+Tiles.ALL.get(i));
          }
          tile = input.nextInt();
          if (!(tile<Tiles.ALL.size()))
            System.out.println("Tile not Found");
          
          System.out.print("What row would you like to set at?");
          int row = input.nextInt();
          System.out.print("What col tile would you like to set at?");
          int col = input.nextInt();
          
          runner.map.setTile(Tiles.ALL.get(tile), row, col);
          break;
        case 3:
          runner.map.fillTileLayer(Tiles.GRASS);
          for (int i = 0; i < 500; i++){
          runner.map.setTile(Tiles.GRASS,"dead",(int)(Math.random()*50),(int)(Math.random()*50));
          }
          break;
        case 4:
          System.out.println("What item would you like to fill with?");
          for (var i = 0; i<Items.ALL.size(); i++){
            System.out.println(i+") "+Items.ALL.get(i));
          }
          int item = input.nextInt();
          if (item<Items.ALL.size())
            runner.map.fillItemLayer(Items.ALL.get(item));
          else
            System.out.println("Item not Found");
          break;
        case 5:
          System.out.println("What item would you like to set with?");
          for (var i = 0; i<Items.ALL.size(); i++){
            System.out.println(i+") "+Items.ALL.get(i));
          }
          item = input.nextInt();
          if (!(item<Items.ALL.size()))
            System.out.println("Item not Found");
          
          System.out.print("What row would you like to set at?");
          row = input.nextInt();
          System.out.print("What col would you like to set at?");
          col = input.nextInt();
          
          runner.map.setItem(Items.ALL.get(item), row, col);
          break;
        case 6:
          runner.map.setItemLayer(new Image[runner.map.getItemLayer().length][runner.map.getItemLayer()[0].length]);
          for (int i = 0; i<300; i++){
            runner.map.setItem(Items.OAK_TREE,(int)(Math.random()*50),(int)(Math.random()*50));
            runner.map.setItem(Items.MAPLE_TREE,(int)(Math.random()*50),(int)(Math.random()*50));
            runner.map.setItem(Items.PINE_TREE,(int)(Math.random()*50),(int)(Math.random()*50));
          }
          break;
        case 7:
          runner.panel.saveImage();
          break;
      }
      runner.panel.update();
    }
  }
}