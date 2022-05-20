import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class MapComponent extends JViewport implements KeyListener{
  private Map map;
  private int xVelocity=0;
  private int yVelocity=0;
  
  public MapComponent(Map map){
    super();
    addKeyListener(this);
    setFocusable(true);
    this.map = map;
    this.setPreferredSize(new Dimension(map.getTileLayer()[0].length*map.getTileSizePx(),map.getTileLayer().length*map.getTileSizePx()));
  }
  
  public void setMap(Map map){
    this.map=map;
  }
  
  public Map getMap(){
    return this.map;
  }
  
  @Override
  public void paint(Graphics g) {
    //super.paint(g);
    
    //calculate coordinates of top left corner
    int leftX = getX()+(int)(getSize().getWidth()-map.getTileLayer()[0].length*map.getTileSizePx())/2;
    int topY = getY()+(int)(getSize().getHeight()-map.getTileLayer().length*map.getTileSizePx())/2 ;
    
    //Render tiles from top to bottom, left to right
    int x = leftX;
    int y = topY;
    for (Image[] row: map.getTileLayer()){
      for (Image img: row){
        g.drawImage(img, x, y, this);
        x += map.getTileSizePx();
      }
      x = leftX;
      y += map.getTileSizePx();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code){
      case KeyEvent.VK_DOWN:
        yVelocity=-2;
        break;
      case KeyEvent.VK_UP:
        yVelocity=2;
        break;
      case KeyEvent.VK_RIGHT:
        xVelocity=-2;
        break;
      case KeyEvent.VK_LEFT:
        xVelocity=2;
        break;
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {
  	  // TODO Auto-generated method stub
    }
  
    @Override
    public void keyReleased(KeyEvent e) {
      int code = e.getKeyCode();
      switch (code){
        case KeyEvent.VK_DOWN:
          yVelocity=0;
          break;
        case KeyEvent.VK_UP:
          yVelocity=0;
          break;
        case KeyEvent.VK_RIGHT:
          xVelocity=0;
          break;
        case KeyEvent.VK_LEFT:
          xVelocity=0;
          break;
      }
    }

}