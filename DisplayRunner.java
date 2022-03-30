import java.util.Scanner;

class DisplayRunner{
  private Scanner input;
  public DisplayRunner(){
    this.input = new Scanner(System.in);
    System.out.println("How big in pixels would you like your blocks to be?");
    int blockSizePixels = input.nextInt();
    System.out.println("How many blocks wide would you like?");
    int blocksWide= input.nextInt();
    System.out.println("How many blocks tall would you like?");
    int blocksTall= input.nextInt();
    
    Display window = new Display(blockSizePixels, blocksWide, blocksTall);

     window.getSchematic().fillTileLayer("imgs/grass.png");
    window.getSchematic().setTile("imgs/test.png",9,3);
    window.updateScreen();
  }
}