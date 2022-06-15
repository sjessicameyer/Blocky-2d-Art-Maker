import java.util.*;
class Tiles{
  public static Tile GRASS = new Tile("imgs/grass.png", "dead","imgs/dead_grass.png"); 
  public static Tile ROCK = new Tile("imgs/rock.png");
  public static Tile GRANITE = new Tile("imgs/granite.png");
  public static Tile SAND = new Tile("imgs/sand.png");
  public static Tile WATER = new Tile("imgs/water.png");
  public static ArrayList<Tile> ALL= new ArrayList<Tile>(Arrays.asList(GRASS, ROCK, GRANITE, SAND, WATER));
}