import java.util.*;
import javax.swing.*;
import java.io.*;  
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Tile{
  private Dictionary<String, Image> textures = new Hashtable<String, Image>();

  public Tile (String defaultImgPath){
    setTexture("default", defaultImgPath);
  }

  public Tile (String defaultImgPath, String... otherImgs){
    setTexture("default", defaultImgPath);
    if (otherImgs.length%2==1){
      new IllegalArgumentException("Must enter valid key - tile texture pair").printStackTrace();
    }else{
      for (int i=0;i<otherImgs.length;i=i+2)
        setTexture(otherImgs[i], otherImgs[i+1]);
    }
  }

  public Image getTexture(){
    return textures.get("default");
  }

  public Image getTexture(int sizePx){
    return textures.get("default").getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
  }
  
  public Image getTexture(String name){
    if (textures.get(name)==null){
      return textures.get("default");
    }
    return textures.get(name);
  }

  public Image getTexture(String name, int sizePx){
    if (textures.get(name)==null){
      return textures.get("default").getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
    }
    return textures.get(name).getScaledInstance(sizePx, sizePx, Image.SCALE_SMOOTH);
  }

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
}