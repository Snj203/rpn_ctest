import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Viewer{
  private JTextField textField1;
  private JTextField textField2;
  public Viewer(){
    Controller controller = new Controller(this);

    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);

    Font fontTextField= new Font("Montserrat",Font.BOLD, 25);
    textField1 = new JTextField();
    textField1.setFont(fontTextField);
    textField1.setHorizontalAlignment(JTextField.RIGHT);
    textField1.setForeground(Color.LIGHT_GRAY);
    textField1.setBackground(new Color(51,51,51));
    textField1.setPreferredSize(new Dimension(800,50));
    textField1.setBorder(border);

    textField2 = new JTextField();
    textField2.setFont(fontTextField);
    textField2.setHorizontalAlignment(JTextField.RIGHT);
    textField2.setForeground(Color.LIGHT_GRAY);
    textField2.setBackground(new Color(51,51,51));
    textField2.setPreferredSize(new Dimension(800,50));
    textField2.setBorder(border);

    MyButton btnOne = new MyButton("1","One");
    btnOne.addActionListener(controller);
    MyButton btnTwo = new MyButton("2","Two");
    btnTwo.addActionListener(controller);
    MyButton btnThree = new MyButton("3","Three");
    btnThree.addActionListener(controller);
    MyButton btnPlus = new MyButton("+","Plus");
    btnPlus.addActionListener(controller);
    MyButton btnFour = new MyButton("4","Four");
    btnFour.addActionListener(controller);
    MyButton btnFive = new MyButton("5","Five");
    btnFive.addActionListener(controller);
    MyButton btnSix = new MyButton("6","Six");
    btnSix.addActionListener(controller);
    MyButton btnMinus = new MyButton("-","Minus");
    btnMinus.addActionListener(controller);
    MyButton btnSeven = new MyButton("7","Seven");
    btnSeven.addActionListener(controller);
    MyButton btnEight = new MyButton("8","Eight");
    btnEight.addActionListener(controller);
    MyButton btnNine = new MyButton("9","Nine");
    btnNine.addActionListener(controller);
    MyButton btnMultiply = new MyButton("*","Multiply");
    btnMultiply.addActionListener(controller);
    MyButton btnOpenBracket = new MyButton("(","OpenBracket");
    btnOpenBracket.addActionListener(controller);
    MyButton btnZero = new MyButton("0","Zero");
    btnZero.addActionListener(controller);
    MyButton btnCloseBracket = new MyButton(")","CloseBracket");
    btnCloseBracket.addActionListener(controller);
    MyButton btnDivide = new MyButton("/","Divide");
    btnDivide.addActionListener(controller);
    MyButton btnPoint = new MyButton(".","Point");
    btnPoint.addActionListener(controller);
    MyButton btnEqual = new MyButton("=","Equal");
    btnEqual.addActionListener(controller);
    MyButton btnDeleteLeft = new MyButton("⌫","DeleteLeft");
    btnDeleteLeft.addActionListener(controller);
    MyButton btnClear = new MyButton("C","Clear");
    btnClear.addActionListener(controller);






    JPanel textPanel = new JPanel();
    textPanel.setPreferredSize(new Dimension(400,100));
    textPanel.setBackground(Color.GRAY);
    textPanel.setLayout(new BorderLayout());
    textPanel.add(textField1, BorderLayout.NORTH);
    textPanel.add(textField2,BorderLayout.SOUTH);

    JPanel btnPanel = new JPanel();
    btnPanel.setPreferredSize(new Dimension(400,500));
    btnPanel.setBackground(Color.GRAY);
    // btnPanel.setLayout(new GridLayout(4,4,10,10));
    btnPanel.setLayout(new FlowLayout());

    btnPanel.add(btnOne);
    btnPanel.add(btnTwo);
    btnPanel.add(btnThree);
    btnPanel.add(btnPlus);
    btnPanel.add(btnFour);
    btnPanel.add(btnFive);
    btnPanel.add(btnSix);
    btnPanel.add(btnMinus);
    btnPanel.add(btnSeven);
    btnPanel.add(btnEight);
    btnPanel.add(btnNine);
    btnPanel.add(btnMultiply);
    btnPanel.add(btnOpenBracket);
    btnPanel.add(btnZero);
    btnPanel.add(btnCloseBracket);
    btnPanel.add(btnDivide);
    btnPanel.add(btnPoint);
    btnPanel.add(btnEqual);
    btnPanel.add(btnDeleteLeft);
    btnPanel.add(btnClear);

    JFrame frame = new JFrame();
    frame.setTitle("RPN_Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(400,600);
    frame.setLocation(600,300);
    frame.setBackground(Color.GRAY);
    frame.setLayout(new BorderLayout());

    frame.add(textPanel,BorderLayout.NORTH);
    frame.add(btnPanel,BorderLayout.CENTER);
    frame.setVisible(true);
  }
  public void update(String val1,String val2){
    textField1.setText(val1);
    textField2.setText(val2);
  }
}
