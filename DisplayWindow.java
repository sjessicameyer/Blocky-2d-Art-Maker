import java.awt.*;
import javax.swing.*;

class DisplayWindow extends JFrame{
  private DisplayPanel display;
  
  public DisplayWindow(DisplayPanel display){
    super();
    this.display=display;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setUndecorated ( true );
    //GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //this.setBounds(env.getMaximumWindowBounds());
    this.setTitle("Blocky 2d Art Maker");
    this.setResizable(false);
    //this.setLocationRelativeTo(null);
    this.getContentPane().add(this.display);
    this.pack();
    this.setVisible(true);
    System.out.println("Done");
  }
}
