import java.awt.*;
import javax.swing.*;


class Display extends JFrame{
  private int blockSizePixels;
  private Schematic schematic;
  private JPanel p;
  
  public Display(int blockSizePixels, int blocksWide, int blocksTall){
    super();  
    this.blockSizePixels=blockSizePixels;
    this.schematic = new Schematic(blocksTall,blocksWide);
    
    //TODO: Make resizable
    //window setup
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Blocky 2d Art Maker");
    this.setResizable(false);
    
    //panel setup
    p = new JPanel();
    p.setPreferredSize(new Dimension(blockSizePixels*blocksWide, blockSizePixels*blocksTall));
    p.setLayout(new GridLayout(blocksTall,blocksWide));
  
    //display in window
    this.add(p);
    this.pack();
    this.setVisible(true);
  }

  public void updateScreen(){
    p.removeAll();
    for (int row = 0; row<this.schematic.getTileLayer().length; row++){
      for (int col = 0; col<this.schematic.getTileLayer()[row].length;col++){
        p.add(this.schematic.getTileLayer()[row][col]);
      }
    } 
    p.revalidate();
    p.repaint();
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
