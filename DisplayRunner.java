import java.util.Scanner;

class DisplayRunner{
  private Scanner input;
  public DisplayRunner(){
    this.input = new Scanner(System.in);
    /*System.out.println("How big in pixels would you like your blocks to be?");
    int blockSizePixels = input.nextInt();
    System.out.println("How many blocks wide would you like?");
    int blocksWide= input.nextInt();
    System.out.println("How many blocks tall would you like?");
    int blocksTall= input.nextInt();
    */
    Display display = new Display(16, 16, 16);
    
    Tile grass = new Tile("imgs/grass.png"); 
    grass.setTexture("dead grass","imgs/dead_grass.png");
    Tile test = new Tile("imgs/test.png"); 
    display.getSchematic().fillTileLayer(grass);
    display.getSchematic().setTile(test,9,3);
    display.getSchematic().setTile(grass,"dead grass",10,3);
    display.updateScreen();
  }
}