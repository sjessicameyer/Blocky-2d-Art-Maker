import java.util.Scanner;
import java.lang.Math;

class DisplayRunner implements Runnable{
  public Map map;
  public DisplayPanel panel;
  
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