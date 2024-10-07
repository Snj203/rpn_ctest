import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
public class MyButton extends JButton{
  public MyButton(String text,String command){
    this.setPreferredSize(new Dimension(75,75));
    this.setText(text);
    this.setActionCommand(command);
    this.setFont(new Font ("Montserrat",Font.BOLD, 25));
    this.setForeground(Color.WHITE);
    this.setBackground(new Color(51,51,51));
  }
}
