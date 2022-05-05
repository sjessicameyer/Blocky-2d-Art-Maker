import java.util.Scanner;

class DisplayRunner{
  private Scanner input;
  public DisplayRunner(){
    this.input = new Scanner(System.in);
    Display display = new Display(new DisplayPanel(16, 16, 16));
    
    Tile grass = new Tile("imgs/grass.png"); 
    grass.setTexture("dead grass","imgs/dead_grass.png");
    Tile test = new Tile("imgs/test.png"); 
    display.getDisplayPanel().getSchematic().fillTileLayer(grass);
    display.getDisplayPanel().getSchematic().setTile(test,9,3);
    display.getDisplayPanel().getSchematic().setTile(grass,"dead grass",10,3);
    display.update();
    display.getDisplayPanel().resize(32);
  }
}