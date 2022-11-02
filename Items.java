import java.util.*;
/**
 * Items class for Blocky 2d Art Maker, which stores public variables for different Items
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
class Items{
  /**
 * An item with an oak tree texture
 */
  public static Item OAK_TREE = new Item("Oak Tree", "imgs/oak_tree.png"); 

 /**
 * An item with a pine tree texture
 */
  public static Item PINE_TREE = new Item("Pine Tree", "imgs/pine_tree.png");

 /**
 * An item with a maple tree texture
 */
  public static Item MAPLE_TREE = new Item("Maple Tree", "imgs/maple_tree.png");

 /**
 * A list of all items
 */
  public static ArrayList<Item> ALL= new ArrayList<Item>(Arrays.asList(OAK_TREE,PINE_TREE,MAPLE_TREE));
}