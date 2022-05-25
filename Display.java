import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;


class Display extends JFrame{
  private DisplayPanel displayPanel;
  
  public Display(DisplayPanel displayPanel){
    super();  
    this.displayPanel=displayPanel;

    
    //window setup
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Blocky 2d Art Maker");
    this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE));
    this.setBackground(Color.BLACK);
    
    //add panel in window
    this.add(displayPanel);
    this.pack();
    this.setVisible(true);
    this.setMaximumSize(new Dimension(displayPanel.getMap().getTileLayer()[0].length*displayPanel.getMap().getTileSizePx(),displayPanel.getMap().getTileLayer().length*displayPanel.getMap().getTileSizePx()));

    this.addComponentListener(new ComponentAdapter()
    {  
      public void componentResized(ComponentEvent e) {
        displayPanel.componentResized(e);
      }
    });
  }

  public DisplayPanel getDisplayPanel(){
    return this.displayPanel;
  }

  public void setDisplayPanel(DisplayPanel displayPanel){
  this.displayPanel=displayPanel;  
  }
}
