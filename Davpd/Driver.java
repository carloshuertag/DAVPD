import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
    public static void main(String args[]){
        JFrame jFrame = new JFrame("DAVPD");
        JPanel calculatorJPanel = new Calculator(0,0, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        jFrame.setBounds(0, 0, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        jFrame.add(calculatorJPanel);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setTitle("DAVPD");
    }
}
