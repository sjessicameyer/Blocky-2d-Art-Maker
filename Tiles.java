import java.util.*;

/**
   * Tiles class for Blocky 2d Art Maker, which stores public variables for different Tiles
   * @author Sar2x
   * @version 1.0 17/06/2022
   */
class Tiles{
  /**
 * A tile with a grass texture
 */
  public static Tile GRASS = new Tile("Grass", "imgs/grass.png", "dead","imgs/dead_grass.png"); 

  /**
 * A tile with a rock texture
 */
  public static Tile ROCK = new Tile("Rock", "imgs/rock.png");

  /**
   * A tile with a granite texture
   */
  public static Tile GRANITE = new Tile("Granite", "imgs/granite.png");

  /**
   * A tile with a sand texture
   */
  public static Tile SAND = new Tile("Sand", "imgs/sand.png");

  /**
   * A tile with a water texture
   */
  public static Tile WATER = new Tile("Water", "imgs/water.png");

  /**
   * A list of all possible tiles in this class
   */
  public static ArrayList<Tile> ALL= new ArrayList<Tile>(Arrays.asList(GRASS, ROCK, GRANITE, SAND, WATER));
}