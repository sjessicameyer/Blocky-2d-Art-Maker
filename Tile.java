import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Tile{
  private Dictionary<String, ImageIcon> textures = new Hashtable<String, ImageIcon>();

  public Tile (String defaultImgPath){
    textures.put("default",new ImageIcon(defaultImgPath));
  }

  public Tile (String defaultImgPath, String... otherImgs) throws Exception{
    textures.put("default",new ImageIcon(defaultImgPath));
    if (otherImgs.length%2==1){
      throw new IllegalArgumentException("Must enter valid key - tile texture pair");
    }else{
      for (int i=0;i<otherImgs.length;i=i+2)
        textures.put(otherImgs[i],new ImageIcon(otherImgs[i+1]));
    }
  }

  public ImageIcon getTexture(){
    return textures.get("default");
  }

  public ImageIcon getTexture(int sizePx){
    return new ImageIcon(textures.get("default").getImage().getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH));
  }
  
  public ImageIcon getTexture(String name){
    if (textures.get(name)==null){
      return textures.get("default");
    }
    return textures.get(name);
  }

  public ImageIcon getTexture(String name, int sizePx){
    if (textures.get(name)==null){
      return new ImageIcon(textures.get("default").getImage().getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH));
    }
    return new ImageIcon(textures.get(name).getImage().getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH));
  }

  public void setTexture(String name, String imgPath){
    textures.put(name, new ImageIcon(imgPath));
  }
}