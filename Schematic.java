import javax.swing.*;

public class Schematic {
  private JLabel[][] tileLayer;
  private int tileSizePx;

  public Schematic(int blocksTall, int blocksWide, int tileSizePx){
    tileLayer= new JLabel[blocksTall][blocksWide];
    this.tileSizePx=tileSizePx;
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        tileLayer[row][col]=new JLabel();
      }
    }
  }
  
  public Schematic(JLabel[][] tileLayer){
    this.tileLayer= tileLayer;
  }

  public void fillTileLayer(Tile tile){;
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,row,col);
      }
    }
  }

  public void fillTileLayer(Tile tile, String key){;
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,key,row,col);
      }
    }
  }
  
  public void setTileLayer(JLabel[][] tileLayer){
    this.tileLayer=tileLayer;
  }

  public JLabel[][] getTileLayer(){
    return this.tileLayer;
  }

  public void setTile(Tile tile, int row, int col){
    //BROKEN
    tileLayer[row][col].setIcon(tile.getTexture(tileSizePx));
  }

  public void setTile(Tile tile, String key, int row, int col){
    tileLayer[row][col].setIcon(tile.getTexture(key,tileSizePx));
  }

  public JLabel getTile(int row, int col){
    return tileLayer[row][col];
  }

  public int getTileSizePx(){
    return tileSizePx;
  }

  public void setTileSizePx(int tileSizePx){
    this.tileSizePx= tileSizePx;
    //needs to be fixed to update tile later
  }
}