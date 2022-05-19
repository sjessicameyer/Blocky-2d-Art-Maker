import java.awt.*;

public class Map {
  private Image[][] tileLayer;
  private Image[][] itemLayer;
  private int tileSizePx;

  public Map(int blocksTall, int blocksWide, int tileSizePx){
    tileLayer= new Image[blocksTall][blocksWide];
    itemLayer= new Image[blocksTall][blocksWide];
    this.tileSizePx=tileSizePx;
  }
  
  public Map(Image[][] tileLayer, Image[][] itemLayer){
    this.tileLayer= tileLayer;
    this.itemLayer= itemLayer;
  }

  public void fillTileLayer(Tile tile){;
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,row,col);
      }
    }
  }

  public void fillTileLayer(Tile tile, String key){
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,key,row,col);
      }
    }
  }
  
  public void setTileLayer(Image[][] tileLayer){
    this.tileLayer=tileLayer;
  }

  public Image[][] getTileLayer(){
    return this.tileLayer;
  }

  public void setItemLayer(Image[][] itemLayer){
    this.itemLayer=itemLayer;
  }

  public Image[][] getItemLayer(){
    return this.itemLayer;
  }

  public void setTile(Tile tile, int row, int col){
    tileLayer[row][col]=tile.getTexture(tileSizePx);
  }

  public void setTile(Tile tile, String key, int row, int col){
    tileLayer[row][col]=tile.getTexture(key,tileSizePx);
  }

  public Image getTile(int row, int col){
    return tileLayer[row][col];
  }

  public int getTileSizePx(){
    return tileSizePx;
  }

  public void setTileSizePx(int tileSizePx){
    this.tileSizePx= tileSizePx;
    //needs to be fixed to update tile later
  }

  /**public void setItem(Item item, int row, int col){
    itemLayer[row][col]=item.getTexture(tileSizePx);
  }

  public void setItem(Item item, String key, int row, int col){
    itemLayer[row][col]=item.getTexture(key,tileSizePx);
  }

  public Image getItem(int row, int col){
    return tileLayer[row][col];
  }*/

}