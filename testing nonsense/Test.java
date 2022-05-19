import java.awt.*;  
import javax.swing.*;  

public class Test extends JFrame{
  public Test(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Blocky 2d Art Maker");
    
    TestPanel p = new TestPanel();
    p.setPreferredSize(new Dimension(300,300));
    p.setBackground(new Color(255,200,200));

    getContentPane().add(p);
    pack();
    setVisible(true);
  }
}