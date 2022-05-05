import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


class DisplayPanel extends JPanel{
  private Schematic schematic;
  
  public DisplayPanel(int tileSizePx, int blocksWide, int blocksTall){
    super();
    this.schematic = new Schematic(blocksTall,blocksWide,tileSizePx);
    this.setPreferredSize(new Dimension(tileSizePx*blocksWide, tileSizePx*blocksTall));
    this.setLayout(new GridLayout(blocksTall,blocksWide));
  }

  public void update(){
    removeAll();
    for (int row = 0; row<this.schematic.getTileLayer().length; row++){
      for (int col = 0; col<this.schematic.getTileLayer()[row].length;col++){
        this.add(this.schematic.getTileLayer()[row][col]);
      }
    } 
    this.setVisible(true);
  }

  public void resize(int tileSizePx){
    schematic.setTileSizePx(tileSizePx);
    this.setPreferredSize(new Dimension(tileSizePx*schematic.getTileLayer()[0].length, tileSizePx*schematic.getTileLayer().length));
  }

  public void setSchematic(Schematic schematic){
    this.schematic=schematic;
  }
  
  public Schematic getSchematic(){
    return this.schematic;
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.red);
    g.fillRect(10,10,100,100);
  }
}
