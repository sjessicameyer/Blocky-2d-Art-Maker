import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class DisplayPanel extends JPanel implements KeyListener{
  private Map map;
  private int xVelocity=0;
  private int yVelocity=0;
  private int xOffset=0;
  private int yOffset=0;
  private boolean keyPressed;
  
  public DisplayPanel(Map map){
    super();
    addKeyListener(this);
    setFocusable(true);
    this.map = map;
    this.keyPressed=false;
    this.setPreferredSize(new Dimension(400,400));
  }

  public void updateLoop(){
    update(getGraphics());
    while (true){
      System.out.println("huj"+keyPressed);
      if (keyPressed){
        update(getGraphics());
        try{
          Thread.sleep(5);
        }catch(Exception e){
          e.printStackTrace();
        }
      }
      try{
        Thread.sleep(1);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  public void scrollWindow(int xVelocity, int yVelocity){
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
    scrollWindow(xVelocity, yVelocity);
      
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
  public void keyPressed(KeyEvent e) {
    keyPressed=true;
    int code = e.getKeyCode();
    switch (code){
      case KeyEvent.VK_DOWN:
        yVelocity=-1;
        break;
      case KeyEvent.VK_UP:
        yVelocity=1;
        break;
      case KeyEvent.VK_RIGHT:
        xVelocity=-1;
        break;
      case KeyEvent.VK_LEFT:
        xVelocity=1;
        break;
    }
  }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
      keyPressed=false;
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