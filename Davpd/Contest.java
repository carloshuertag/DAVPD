import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import java.util.ArrayList;

public class Contest extends JPanel implements ActionListener {
    private static final long serialVersionUID = -8832597883331891416L;
    private JPanel checkJPanel;
    private JButton answerJButton, ipJButton, clearJButton;
    public JTextField timerJTextField;
    private JLabel ipJLabel, nameJLabel, questionJLabel;
    private JTextField answerJTextField, nameJTextField, ipJTextField;
    private ArrayList<JLabel> answersCountJLabels;
    private Time time;

    public Contest(int width, int height) {
        setSize(width, height);
        setLayout(new GridLayout(4, 3, 4, 4));
        initElements();
    }
    private void initElements() {
        initIp();
        initAnswer();
        initCheck();
        time = new Time();//time.start() to set time.setStop(true) to stop
    }
    private void initIp() {
        nameJLabel = new JLabel("Nombre: ");
        nameJLabel.setSize(250, 50);
        add(nameJLabel);
        nameJTextField = new JTextField();
        nameJTextField.setSize(250, 50);
        nameJTextField.setToolTipText("Nombre");
        add(nameJTextField);
        ipJLabel = new JLabel("Dirección Ip: ");
        ipJLabel.setSize(250, 50);
        add(ipJLabel);
        ipJTextField = new JTextField();
        ipJTextField.setSize(250, 50);
        ipJTextField.setToolTipText("Dirección Ip");
        add(ipJTextField);
        ipJButton = new JButton("Contectar");
        ipJButton.setSize(250, 50);
        ipJButton.addActionListener(this);
        add(ipJButton);
        clearJButton = new JButton("Contectar");
        clearJButton.setSize(250, 50);
        clearJButton.addActionListener(this);
        add(clearJButton);
    }
    private void initAnswer() {
        questionJLabel = new JLabel();
        questionJLabel.setSize(250, 50);
    }
    private void initCheck() {
        checkJPanel = new JPanel(1, 5, 1, 1);
        add(checkJPanel);
    }
    private void enableAnswer() {

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(answerJButton)){

        }
        if(actionEvent.getSource().equals(ipJButton)){

        }
    }
}
