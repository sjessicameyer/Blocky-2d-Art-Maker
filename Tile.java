import java.util.Dictionary;
import java.util.Enumeration;

public class Tile{
  private Dictionary<String, String> textures;
  
  public Tile(String defaultImgPath, String... otherImgPaths){
    textures.put("default",defaultImgPath);
    for (int i=0;i<otherImgPaths.length;i=i+2){
      textures.put(otherImgPaths[i],otherImgPaths[i+1]);
    }
  }

  public String getTexture(){
    return textures.get("default");
  }
  public String getTexture(String name){
    //TODO: Add support for if key does not exist in dictionary
    return textures.get(name);
  }

  public void setTexture(String name, String imgPath){
    textures.put(name, imgPath);
  }
}