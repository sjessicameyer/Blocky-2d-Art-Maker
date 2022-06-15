import java.awt.*;

public class Item extends Tile{
  public Item (String defaultImgPath){
    super(defaultImgPath);
  }

  public Item (String defaultImgPath, String... otherImgs){
    super(defaultImgPath, otherImgs);
  }

  @Override
  public Image getTexture(String name, int sizePx){
    return getTexture(name);
  }
  
  @Override
  public Image getTexture(int sizePx){
    return getTexture();
  }
}