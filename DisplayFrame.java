import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;


class DisplayFrame extends JFrame{
  private DisplayPanel displayPanel;
  
  public DisplayFrame(DisplayPanel displayPanel){
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

    this.addComponentListener(new ComponentAdapter()
    {  
      public void componentResized(ComponentEvent e) {
        displayPanel.componentResized(e);
      }
    });
  }

  public DisplayPanel getDisplayPanel(){
    return displayPanel;
  }

  public void setDisplayPanel(DisplayPanel panel){
    displayPanel=panel;
  }
}
