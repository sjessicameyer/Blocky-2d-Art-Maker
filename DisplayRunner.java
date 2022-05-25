import java.util.Scanner;
import java.lang.Math;

class DisplayRunner{
  private Scanner input;
  public DisplayRunner(){
    this.input = new Scanner(System.in);
    Map map = new Map(50,50,16);
    Display display = new Display(new DisplayPanel(map));
    
    Tile grass = new Tile("imgs/grass.png"); 
    grass.setTexture("dead grass","imgs/dead_grass.png");
    map.fillTileLayer(grass);
    for (int i = 0; i < 500; i++){
      map.setTile(grass,"dead grass",(int)(Math.random()*50),(int)(Math.random()*50));
    }
    display.getDisplayPanel().updateLoop();
    //display.getDisplayPanel().resize(32);
  }
}