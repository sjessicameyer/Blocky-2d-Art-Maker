import java.awt.*;  
import javax.swing.*;  
class TestPanel extends JPanel {
  public void paint(Graphics g) {
    g.setColor(Color.red);
    g.fillRect(10,10,100,100);
  }
}