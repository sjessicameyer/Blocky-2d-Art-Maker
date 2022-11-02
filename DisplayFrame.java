import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Frame class for Blocky 2d Art Maker
 * @author Sar2x
 * @version 1.0 17/06/2022
 */
class DisplayFrame extends JFrame{
  /**
   * The panel that is rendered in this frame
   */
  private DisplayPanel displayPanel;

  /**
   * Builds the DisplayFrame and initializes the displayPanel
   * 
   * @param displayPanel The panel rendered in the frame.
   */
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

  /**
   * Returns the DisplayPanel
   * 
   * @return The Display Panel rendered in this frame
   */
  public DisplayPanel getDisplayPanel(){
    return displayPanel;
  }

  /**
   * Sets the DisplayPanel rendered in this frame
   * 
   * @param panel The DisplayPanel that will be rendered in this frame
   */
  public void setDisplayPanel(DisplayPanel panel){
    displayPanel=panel;
  }
}
