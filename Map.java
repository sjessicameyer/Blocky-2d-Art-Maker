import java.awt.*;

/**
 * Map class for Blocky 2d Art Maker, which stores the locations of tiles and items
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
public class Map {
  /**
 * This stores the locations of tiles
 */
  private Image[][] tileLayer;

  /**
 * This stores the locations of items
 */
  private Image[][] itemLayer;

  /**
 * This stores the size of tiles
 */
  private int tileSizePx;

  /**
   * Builds a map and initializes its data 
   * 
   * @param blocksTall Used to set the number of blocks tall in the map
   * @param blocksWide Used to set the number of blocks wide in the map
   * @param tileSizePx Used to set the size of the tiles in the map
   */
  public Map(int blocksTall, int blocksWide, int tileSizePx){
    tileLayer= new Image[blocksTall][blocksWide];
    itemLayer= new Image[blocksTall][blocksWide];
    this.tileSizePx=tileSizePx;
  }

  /**
   * Builds a map and initializes its data 
   * 
   * @param tileLayer Used to set the tileLayer
   * @param itemLayer Used to set the itemLayer
   */
  public Map(Image[][] tileLayer, Image[][] itemLayer){
    this.tileLayer= tileLayer;
    this.itemLayer= itemLayer;
  }

  /**
   * Used to fill the tile layer with a single tile 
   * 
   * @param tile The tile you would like to fill the tile layer
   */
  public void fillTileLayer(Tile tile){;
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,row,col);
      }
    }
  }

  /**
   * Used to fill the tile layer with a specific texture from a single tile 
   * 
   * @param tile The tile you would like to fill the tile layer
   * @param key The key for the texture you would like from that tile
   */
  public void fillTileLayer(Tile tile, String key){
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setTile(tile,key,row,col);
      }
    }
  }

  /**
   * Used to set the tile layer 
   * 
   * @param tileLayer The tileLayer you would like to change it to
   */
  public void setTileLayer(Image[][] tileLayer){
    this.tileLayer=tileLayer;
  }

  /**
   * Used to get the tile layer
   * 
   * @return The tile layer of this map
   */
  public Image[][] getTileLayer(){
    return this.tileLayer;
  }

  /**
   * Used to set the item layer 
   * 
   * @param itemLayer The itemLayer you would like to change it to
   */
  public void setItemLayer(Image[][] itemLayer){
    this.itemLayer=itemLayer;
  }

   /**
   * Used to get the item layer
   * 
   * @return The item layer of this map
   */
  public Image[][] getItemLayer(){
    return this.itemLayer;
  }

  /**
   * Used to fill the item layer with a specific texture from a single item 
   * 
   * @param item The item you would like to fill the item layer
   * @param key The key for the texture you would like from that item
   */
  public void fillItemLayer(Item item, String key){
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setItem(item,key,row,col);
      }
    }
  }

  /**
   * Used to fill the item layer with a single item 
   * 
   * @param item The item you would like to fill the item layer
   */
  public void fillItemLayer(Item item){
    for (int row = 0; row <this.tileLayer.length; row++){
      for (int col = 0; col <this.tileLayer[0].length; col++){
        setItem(item,row,col);
      }
    }
  }

  /**
   * Used to set a specific tile in the tileLayer
   * 
   * @param tile The tile you would like to set with
   * @param row The row where you would like to set the tile
   * @param col The column where you would like to set the tile
   */
  public void setTile(Tile tile, int row, int col){
    tileLayer[row][col]=tile.getTexture(tileSizePx);
  }

  /**
   * Used to set a specific tile in the tileLayer with a specific texture from that tile
   * 
   * @param tile The tile you would like to set with
   * @param row The row where you would like to set the tile
   * @param col The column where you would like to set the tile
   * @param key The key of the texture from the tile you would like
   */
  public void setTile(Tile tile, String key, int row, int col){
    tileLayer[row][col]=tile.getTexture(key,tileSizePx);
  }

  /**
   * Used to get a specific tile
   * 
   * @param row The row of the tile you would like to get
   * @param col The column of the tile you would like to get
   * @return The tile at the row and column you selected
   */
  public Image getTile(int row, int col){
    return tileLayer[row][col];
  }

  /**
   * Used to get the tile size
   * 
   * @return The tile size
   */
  public int getTileSizePx(){
    return tileSizePx;
  }

  /**
   * Used to set the tile size
   * 
   * @param tileSizePx The tile size you would like to change it to, in pixels
   */
  public void setTileSizePx(int tileSizePx){
    this.tileSizePx= tileSizePx;
    //needs to be fixed to update tile later
  }

  /**
   * Used to set a specific item in the itemLayer
   * 
   * @param item The item you would like to set with
   * @param row The row where you would like to set the item
   * @param col The column where you would like to set the item
   */
  public void setItem(Item item, int row, int col){
    itemLayer[row][col]=item.getTexture(tileSizePx);
  }

  /**
   * Used to set a specific item in the itemLayer with a specific texture from that item
   * 
   * @param item The item you would like to set with
   * @param row The row where you would like to set the item
   * @param col The column where you would like to set the item
   * @param key The key of the texture from the item you would like
   */
  public void setItem(Item item, String key, int row, int col){
    itemLayer[row][col]=item.getTexture(key,tileSizePx);
  }

  /**
   * Used to get a specific item
   * 
   * @param row The row of the item you would like to get
   * @param col The column of the item you would like to get
   * @return The item at the row and column you selected
   */
  public Image getItem(int row, int col){
    return itemLayer[row][col];
  }

}