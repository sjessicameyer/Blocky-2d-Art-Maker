import java.awt.*;
import javax.swing.*;


class Display extends JFrame{
  private int blockSizePixels;
  private Schematic schematic;
  
  public Display(int blockSizePixels, int blocksWide, int blocksTall){
    super();  
    this.blockSizePixels=blockSizePixels;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //TODO: Add back decoration
    //TODO: Make resizable
    //get rid of bar at top
    this.setUndecorated ( true );
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    this.setBounds(env.getMaximumWindowBounds());

    //set size & layout
    this.setSize(blockSizePixels*blocksWide, blockSizePixels*blocksTall);
    this.setLayout(new GridLayout(blocksTall,blocksWide));
    this.schematic = new Schematic(blocksTall,blocksWide);

    //various window settings
    this.setTitle("Blocky 2d Art Maker");
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public void updateScreen(){
    this.getContentPane().removeAll();
    this.repaint();
    for (int row = 0; row<this.schematic.getTileLayer().length; row++){
      for (int col = 0; col<this.schematic.getTileLayer()[row].length;col++){
        this.add(this.schematic.getTileLayer()[row][col]);
      }
    } 
    this.setVisible(true);
  }
  
  public void setBlockSizePixels(int blockSizePixels){
    this.blockSizePixels=blockSizePixels;
  }

  public int getBlockSizePixels(){
    return this.blockSizePixels;
  }

  public void setSchematic(Schematic schematic){
    this.schematic=schematic;
  }
  
  public Schematic getSchematic(){
    return this.schematic;
  }

}
