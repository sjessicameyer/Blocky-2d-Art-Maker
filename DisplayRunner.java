import java.util.Scanner;
import java.lang.Math;

/**
 * Run class for Blocky 2d Art Maker
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
class DisplayRunner implements Runnable{
  /**
	 * The instance of the map displayed by the application.
	 */
  public Map map;

  /**
	 * The instance of the panel used for running the application.
	 */
  public DisplayPanel panel;

  /**
	 * Builds an instance of DisplayFrame & DisplayPanel, with a randomly generated map composed of grass & dead grass.
	 */
  public void run(){
    map = new Map(50,50,16);
    panel = new DisplayPanel(map);
    DisplayFrame display = new DisplayFrame(panel);
    
    map.fillTileLayer(Tiles.GRASS);
    for (int i = 0; i<100; i++){
       map.setTile(Tiles.GRASS,"dead",(int)(Math.random()*50),(int)(Math.random()*50));
    }

    for (int i = 0; i<300; i++){
      for (Item item : Items.ALL){
        map.setItem(item,(int)(Math.random()*50),(int)(Math.random()*50));
      }
    }
    display.getDisplayPanel().updateLoop();
    //display.getDisplayPanel().resize(32);
  }
}