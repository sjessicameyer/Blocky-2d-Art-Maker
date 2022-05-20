import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

class Display extends JFrame{
  private JPanel p;
  private JScrollPane sp;
  private MapComponent map;
  
  public Display(Map map){
    super();  

    this.map = new MapComponent(map);
    this.sp= new JScrollPane(this.map);
    this.p = new JPanel();
    p.add(sp);
    sp.setPreferredSize(new Dimension(200,200));
    //window setup
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Blocky 2d Art Maker");
    //this.setResizable(false);
    this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE));
    
    //add panel in window
    this.add(p);
    this.pack();
    this.setVisible(true);
  }
}
