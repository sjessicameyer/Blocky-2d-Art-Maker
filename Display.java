import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


class Display extends JFrame{
  private DisplayPanel displayPanel;
  
  public Display(DisplayPanel displayPanel){
    super();  
    this.displayPanel=displayPanel;
    this.setIgnoreRepaint(true);
    //TODO: Make resizable
    //window setup
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Blocky 2d Art Maker");
    //this.setResizable(false);
    this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE));
    
    //add panel in window
    this.add(displayPanel);
    this.pack();
    this.setVisible(true);
  }

  public DisplayPanel getDisplayPanel(){
    return this.displayPanel;
  }

  public void setDisplayPanel(DisplayPanel displayPanel){
  this.displayPanel=displayPanel;  
  }
}
