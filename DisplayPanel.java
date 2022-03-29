import java.awt.*;
import javax.swing.*;

class DisplayPanel extends JPanel{
  private int blockSizePixels;
  private Schematic schematic;
  
  public DisplayPanel(int blockSizePixels, int blocksWide, int blocksTall){
    super();  
    this.blockSizePixels=blockSizePixels;
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //get rid of bar at top TODO: add bar back
    //this.setUndecorated ( true );
    //GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //this.setBounds(env.getMaximumWindowBounds());

    //set size & layout
    this.setSize(blockSizePixels*blocksWide, blockSizePixels*blocksTall);
    this.setLayout(new GridLayout(blocksTall,blocksWide));
    this.schematic = new Schematic(blocksTall,blocksWide);

    //various window settings
    //this.setTitle("Blocky 2d Art Maker");
    //this.setResizable(false);
    //this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public void updateScreen(){
    //this.getContentPane().removeAll()
    this.removeAll();
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
