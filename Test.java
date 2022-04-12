import java.awt.*;  
import javax.swing.*;  

public class Test{
  public Test(){
    JFrame g = new JFrame();
    
    g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    g.setTitle("Blocky 2d Art Maker");
    //g.setResizable(false);


    JPanel p = new JPanel();
    p.setPreferredSize(new Dimension(300,300));
    p.setBackground(new Color(255,200,200));

    g.getContentPane().add(p);
    g.pack();
    g.setVisible(true);
  }
}