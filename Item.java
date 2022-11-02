import java.awt.*;

/**
 * Item class for Blocky 2d Art Maker
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
public class Item extends Tile{
  /**
   * Builds an item by calling on the parent class
   * @param name The toString return value of this object
   * @param defaultImgPath The image path from this file to the image in question. These images must be 32*32 to render properly.
   */
  public Item (String name, String defaultImgPath){
    super(name, defaultImgPath);
  }

  /**
   * Builds an item by calling on the parent class
   * @param name The toString return value of this object
   * @param defaultImgPath The image path from this file to the image in question. These images must be 32*32 to render properly.
`` * @param otherImgs A list of keys and their corresponding image paths. Must be in this format: "key, path/img, key, path/img" etc.
   */
  public Item (String name, String defaultImgPath, String... otherImgs){
    super(name, defaultImgPath, otherImgs);
  }

  /**
   * Returns the texture of an item
   * @param name The key of the image you would like to retrieve for that item
   * @param sizePx The size you would like returned- this is disabled with items
   * @return The corresponding texture for this item
   */
  @Override
  public Image getTexture(String name, int sizePx){
    return getTexture(name);
  }

  /**
   * Returns the texture of an item
   * @param sizePx The size you would like returned- this is disabled with items
   * @return The corresponding texture for this item
   */
  @Override
  public Image getTexture(int sizePx){
    return getTexture();
  }
}