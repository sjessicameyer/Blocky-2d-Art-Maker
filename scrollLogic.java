import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class scrollLogic extends JPanel implements KeyListener{
  private Map map;
  private int xVelocity;
  private int yVelocity;
  private int xOffset;
  private int yOffset;
  
  public scrollLogic (Map map){
    super();
    addKeyListener(this);
    setFocusable(true);
    this.map = map;
    this.xVelocity=0;
    this.yVelocity=0;
    this.xOffset=0;
    this.yOffset=0;
    this.setPreferredSize(new Dimension(400,400));
  }

  public void updateLoop(){
    while (true){
      synchronized(this) {
        this.update(this.getGraphics());
        try {
          wait();
           //Thread.sleep(6);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void scrollWindow(){
    int leftX = getX()+(int)(getSize().getWidth()-map.getTileLayer()[0].length*map.getTileSizePx())/2 + xOffset;
    int topY = getY()+(int)(getSize().getHeight()-map.getTileLayer().length*map.getTileSizePx())/2 + yOffset;
    
    if(leftX+xVelocity>getX()){
      xVelocity=0;
    }else if(leftX+xVelocity+map.getTileLayer()[0].length*map.getTileSizePx()<getX()+getSize().getWidth()){
      xVelocity=0;
    }
    
    if(topY+yVelocity>getY()){
      yVelocity=0;
    }else if(topY+yVelocity+map.getTileLayer().length*map.getTileSizePx()<getY()+getSize().getHeight()){
      yVelocity=0;
    }

    
    yOffset+=yVelocity;
    xOffset+=xVelocity;
  }
  //removed update, resize methods
  
  public void setMap(Map map){
    this.map=map;
  }
  
  public Map getMap(){
    return this.map;
  }
  
  @Override
  public void paint(Graphics g) {
    //super.paint(g);
    scrollWindow();

    //calculate coordinates of top left corner
    int leftX = getX()+(int)(getSize().getWidth()-map.getTileLayer()[0].length*map.getTileSizePx())/2 + xOffset;
    int topY = getY()+(int)(getSize().getHeight()-map.getTileLayer().length*map.getTileSizePx())/2 + yOffset;
    
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
  public synchronized void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code){
      case KeyEvent.VK_DOWN:
        yVelocity=-10;
        break;
      case KeyEvent.VK_UP:
        yVelocity=10;
        break;
      case KeyEvent.VK_RIGHT:
        xVelocity=-10;
        break;
      case KeyEvent.VK_LEFT:
        xVelocity=10;
        break;
    }
    notify();
  }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
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