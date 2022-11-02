import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

/**
 * Panel class for Blocky 2d Art Maker
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
class DisplayPanel extends JPanel implements KeyListener{

  /**
   * The map being rendered by the panel.
   */
  private Map map;

  /**
   * The x Velocity (either -1, 0, or 1) used to determine right-left movement.
   */
  private int xVelocity=0;

  /**
   * The y Velocity (either -1, 0, or 1) used to determine up-down movement.
   */
  private int yVelocity=0;

  /**
   * The x Offset used to determine where the graphics should be rendered
   */
  private int xOffset=0;

  /**
   * The y Offset used to determine where the graphics should be rendered
   */
  private int yOffset=0;

  /**
   * The x value of the left edge of the screen used to determine where the graphics should be rendered
   */
  private int leftX=0;

  /**
   * The y value of the top edge of the screen used to determine where the graphics should be rendered
   */
  private int topY=0;

  /**
   * Builds the DisplayPanel, initializes its map, and and changes some key settings
   * 
   * @param map The map that will be rendered in the panel
   */
  public DisplayPanel(Map map){
    super();
    addKeyListener(this);
    setFocusable(true);
    this.map = map;
    this.setPreferredSize(new Dimension(400,400));
    requestFocusInWindow();
  }

  /**
   * Starts a loop to update the graphics
   */
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

  /**
   * Calculates window scrolling
   * 
   * @param xVelocity The left-right velocity used to calculate scrolling
   * @param yVelocity The up-down velocity used to calculate scrolling
   */
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

  /**
   * Set the map that is rendered in the panel
   * 
   * @param map The map that will be rendered in the panel
   */
  public void setMap(Map map){
    this.map=map;
  }

  /**
   * Returns the map that is rendered by the DisplayPanel
   * 
   * @return The map that is rendered by the DisplayPanel
   */
  public Map getMap(){
    return this.map;
  }

  /**
   * Handles recalculating various bits when the panel is resized (potentially still buggy)
   * 
   * @param e The event that causes this method to be run; not actually used in the method.
   */
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

  /**
   * Renders everything!
   * 
   * @param g The graphics where all this needs to be rendered.
   */
  @Override
  public void paint(Graphics g) {
    //super.paint(g);
    scrollWindow(xVelocity, yVelocity);

    //make image
    int w = map.getTileLayer()[0].length*map.getTileSizePx(); 
    int h = map.getTileLayer().length*map.getTileSizePx(); 
    
    Image image = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB); 
    Graphics imageGraphics = image.getGraphics(); 
    //Render tiles from top to bottom, left to right
    int x = 0;
    int y = 0;
    for (Image[] row: map.getTileLayer()){
      for (Image img: row){
        imageGraphics.drawImage(img, x, y, null);
        x += map.getTileSizePx();
      }
      x = 0;
      y += map.getTileSizePx();
    }

    //Render items from top to bottom, left to right
    x = -8;
    y = -16;
    for (Image[] row: map.getItemLayer()){
      for (Image img: row){
        imageGraphics.drawImage(img, x, y, null);
        x += map.getTileSizePx();
      }
      x = -8;
      y += map.getTileSizePx();
    }
    g.drawImage(image, getX()+xOffset-w/4, getY()+yOffset-h/4, null);
  }

  /**
   * Saves the render (full image of everything) to the file "saved.png"
   */
  public void saveImage(){
    //make image
    int w = map.getTileLayer()[0].length*map.getTileSizePx(); 
    int h = map.getTileLayer().length*map.getTileSizePx(); 
    BufferedImage image = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB); 
    Graphics imageGraphics = image.getGraphics(); 
    //Render tiles from top to bottom, left to right
    int x = 0;
    int y = 0;
    for (Image[] row: map.getTileLayer()){
      for (Image img: row){
        imageGraphics.drawImage(img, x, y, null);
        x += map.getTileSizePx();
      }
      x = 0;
      y += map.getTileSizePx();
    }

    //Render items from top to bottom, left to right
    x = -8;
    y = -16;
    for (Image[] row: map.getItemLayer()){
      for (Image img: row){
        imageGraphics.drawImage(img, x, y, null);
        x += map.getTileSizePx();
      }
      x = -8;
      y += map.getTileSizePx();
    }
    
    File outputfile = new File("saved.png");
    try{
      ImageIO.write(image, "png", outputfile);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  /**
   * Registers key presses and changes velocity accordingly
   * 
   * @param e The event that causes this method to be run
   */
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

  /**
   * Does nothing, just for implementing another class
   * 
   * @param e The event that causes this method to be run; not actually used in the method.
   */
  @Override
  public void keyTyped(KeyEvent e) {
  }

  /**
   * Handles key releases, turns that velocity back to 0
   * 
   * @param e The event that causes this method to be run
   */
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
  
  /**
   * Calls on the paint function without a parameter by using this.getGraphics();
   */
  public void update(){
    this.update(this.getGraphics());
  }
}