import java.util.*;
import java.io.*;  
import java.awt.*;
import javax.imageio.ImageIO;

/**
 * Tile class for Blocky 2d Art Maker, which stores the textures & other info about every tile
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
public class Tile{
  /**
 * A dictionary which holds all the possible textures(an image of the tile), for every corresponding key
 */
  private Dictionary<String, Image> textures = new Hashtable<String, Image>();

  /**
  * Holds the toString return value of this object
  */
  private String name;
  
  /**
 * Builds a tile by calling on the setTexture method
 * @param name The toString value of this tile
 * @param defaultImgPath The image path to the default texture
 */
  public Tile (String name, String defaultImgPath){
    this.name = name;
    setTexture("default", defaultImgPath);
  }

   /**
 * Builds a tile by calling on the setTexture method as many times as nessesary
 * @param name The toString value of this tile
 * @param defaultImgPath The image path to the default texture.
 * @param otherImgs The image path and key in the format key, path for any other textures of this tile
 */
  public Tile (String name, String defaultImgPath, String... otherImgs){
    this.name = name;
    setTexture("default", defaultImgPath);
    if (otherImgs.length%2==1){
      new IllegalArgumentException("Must enter valid key - tile texture pair").printStackTrace();
    }else{
      for (int i=0;i<otherImgs.length;i=i+2)
        setTexture(otherImgs[i], otherImgs[i+1]);
    }
  }

   /**
   * Returns the texture of this tile
   * @return An image of the texture
   */
  public Image getTexture(){
    return textures.get("default");
  }

   /**
   * Returns the texture of this tile at the requested size
   * @param sizePix The size of the image (in pixels) which you would like
   * @return An image of the texture at the requested size
   */
  public Image getTexture(int sizePx){
    return textures.get("default").getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
  }

  /**
   * Returns a specific texture of this tile
   * @param name The key of the texture you would like
   * @return The specific image of the texture
   */
  public Image getTexture(String name){
    if (textures.get(name)==null){
      return textures.get("default");
    }
    return textures.get(name);
  }

  /**
   * Returns a specific texture of this tile at the requested size
   * @param sizePx The size of the image (in pixels) which you would like
   * @param name The key of the texture you would like
   * @return The specific image of the texture at the requested size
   */
  public Image getTexture(String name, int sizePx){
    if (textures.get(name)==null){
      return textures.get("default").getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
    }
    return textures.get(name).getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
  }

  /**
   * Sets a texture for this tile
   * @param name The key you would like to assign to this texture. Pick "default" if you would like this to be the default texture
   */
  public void setTexture(String name, String imgPath){
    try   
    {  
      textures.put(name,ImageIO.read(new File(imgPath)));
    }   
      catch (IOException ex)   
    {  
      ex.printStackTrace();  
    }  
  }

  /**
   * Returns the name of this tile
   * @return The name of this tile
   */
  public String toString(){
    return this.name;
  }
}
