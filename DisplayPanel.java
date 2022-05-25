import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

class DisplayPanel extends JPanel implements KeyListener{
  private Map map;
  private int xVelocity=0;
  private int yVelocity=0;
  private int xOffset=0;
  private int yOffset=0;
  private int leftX=0;
  private int topY=0;
  
  public DisplayPanel(Map map){
    super();
    addKeyListener(this);
    setFocusable(true);
    this.map = map;
    this.setPreferredSize(new Dimension(400,400));
    requestFocusInWindow();
  }

  public void updateLoop(){
    update(getGraphics());
    
    while (true){
      long startTime = System.currentTimeMillis();
      if (xVelocity!=0||yVelocity!=0)
        update(getGraphics());
      long elapsedTime = (new Date()).getTime() - startTime;
      try{
        Thread.sleep(Math.max(0, 20-elapsedTime));
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  public void scrollWindow(int xVelocity, int yVelocity){  
    if(leftX+xOffset+xVelocity>getX()){
      xVelocity=0;
    }else if(leftX+xOffset+xVelocity+map.getTileLayer()[0].length*map.getTileSizePx()<getX()+getSize().getWidth()){
      xVelocity=0;
    }
    
    if(topY+yOffset+yVelocity>getY()){
      yVelocity=0;
    }else if(topY+yOffset+yVelocity+map.getTileLayer().length*map.getTileSizePx()<getY()+getSize().getHeight()){
      yVelocity=0;
    }
    //this.getGraphics().translate(xVelocity, yVelocity);
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

  public void componentResized(ComponentEvent e) {
    leftX = getX()+(int)(getSize().getWidth()-map.getTileLayer()[0].length*map.getTileSizePx())/2;
    topY = getY()+(int)(getSize().getHeight()-map.getTileLayer().length*map.getTileSizePx())/2;

    if(leftX+xOffset>getX()){
      xOffset=getX()-leftX;
    }else if(leftX+xOffset+map.getTileLayer()[0].length*map.getTileSizePx()<getX()+getSize().getWidth()){
      xOffset=(int)(getX()+getSize().getWidth()-(leftX+map.getTileLayer()[0].length*map.getTileSizePx()));
    }
    
    if(topY+yOffset>getY()){
      yOffset=getY()-topY;
    }else if(topY+yOffset+map.getTileLayer().length*map.getTileSizePx()<getY()+getSize().getHeight()){
      yOffset=(int)(getY()+getSize().getHeight()-(topY+map.getTileLayer().length*map.getTileSizePx()));
    }
  }
  
  @Override
  public void paint(Graphics g) {
    //super.paint(g);
    scrollWindow(xVelocity, yVelocity);

    //make image
    int w = map.getTileLayer()[0].length*map.getTileSizePx(); 
    int h = map.getTileLayer().length*map.getTileSizePx(); 
    
    g.drawImage(map.getImage(), getX()+xOffset-w/4, getY()+yOffset-h/4, null);

    /**File outputfile = new File("saved.png");
    try{
      ImageIO.write(offScreenImage, "png", outputfile);
    }catch(Exception e){
      e.printStackTrace();
    }**/
  }

  @Override
  public void keyPressed(KeyEvent e) {
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