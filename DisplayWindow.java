import java.awt.*;
import javax.swing.*;

class DisplayWindow extends JFrame{
  private DisplayPanel display;
  
  public DisplayWindow(DisplayPanel display){
    super();
    this.display=display;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(this.display, BorderLayout.CENTER);
    this.pack();
    this.setSize(200,200);
    this.setTitle("Blocky 2d Art Maker");
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    //this.setResizable(false);
    
    System.out.println("Done");
  }
}
