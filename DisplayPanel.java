import java.awt.*;
import javax.swing.*;

class DisplayPanel extends JPanel{
  private int blockSizePixels;
  private Schematic schematic;
  
  public DisplayPanel(int blockSizePixels, int blocksWide, int blocksTall){
    super();  
    this.blockSizePixels=blockSizePixels;

    //set size & layout
    this.setSize(blockSizePixels*blocksWide, blockSizePixels*blocksTall);
    this.setLayout(new GridLayout(blocksTall,blocksWide));
    this.schematic = new Schematic(blocksTall,blocksWide);
    schematic.fillTileLayer("imgs/grass"
    );
    this.setBackground(Color.RED);
    this.updateScreen();
  }

  public void updateScreen(){
    //this.getContentPane().removeAll()
    this.removeAll();
    this.validate();
    this.repaint();
    for (int row = 0; row<this.schematic.getTileLayer().length; row++){
      for (int col = 0; col<this.schematic.getTileLayer()[row].length;col++){
        this.add(this.schematic.getTileLayer()[row][col]);
      }
    } 
    this.setVisible(true);
  }
  
  public void setBlockSizePixels(int blockSizePixels){
    //TODO: rescale images in Schematic https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel 
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
