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

import java.net.InetAddress;
import java.net.ServerSocket;

public class Contest extends JPanel implements ActionListener {
    private static final long serialVersionUID = -8832597883331891416L;
    private JPanel checkJPanel;
    private JButton answerJButton, serverJButton, clientJButton, historyJButton;
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
        time = new Time(this);
        initCheck();
        addElements();
        //time.start() to set time.setStop(true) to stop
    }
    private void initIp() {
        nameJLabel = new JLabel("Nombre: ");
        nameJLabel.setSize(250, 50);
        nameJTextField = new JTextField();
        nameJTextField.setSize(250, 50);
        nameJTextField.setToolTipText("Nombre");
        ipJLabel = new JLabel("Clave: ");
        ipJLabel.setSize(250, 50);
        ipJTextField = new JTextField();
        ipJTextField.setSize(250, 50);
        ipJTextField.setToolTipText("Clave");
        serverJButton = new JButton("Crear concurso");
        serverJButton.setSize(250, 50);
        serverJButton.addActionListener(this);
        clientJButton = new JButton("Unirse a un concurso");
        clientJButton.setSize(250, 50);
        clientJButton.addActionListener(this);
    }
    private void initAnswer() {
        questionJLabel = new JLabel("Pregunta");
        questionJLabel.setSize(250, 50);
        answerJTextField = new JTextField();
        answerJTextField.setSize(250, 50);
        answerJTextField.setToolTipText("Respuesta");
        answerJButton = new JButton("Responder");
        answerJButton.setSize(250, 50);
        answerJButton.addActionListener(this);
    }
    private void initCheck() {
        timerJTextField = new JTextField();
        timerJTextField.setSize(250, 50);
        timerJTextField.setEditable(false);
        time.start();
        answersCountJLabels = new ArrayList<>();
        checkJPanel = new JPanel(new GridLayout(1, 5, 1, 1));
        for(int i = 1; i < 6; i++){
            answersCountJLabels.add(new JLabel(String.valueOf(i)));
            answersCountJLabels.get(i-1).setSize(250, 50);
        }
        historyJButton = new JButton("Historial");
        historyJButton.setSize(250, 50);
        historyJButton.addActionListener(this);
    }
    private void addElements() {
        add(nameJLabel);
        add(nameJTextField);
        add(questionJLabel);
        add(ipJLabel);
        add(ipJTextField);
        add(answerJTextField);
        add(serverJButton);
        add(clientJButton);
        add(answerJButton);
        add(timerJTextField);
        add(checkJPanel);
        add(historyJButton);
    }
    private void enableAnswer() {

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(answerJButton)){

        }
        if(actionEvent.getSource().equals(serverJButton)){
            try {
                InetAddress ip = InetAddress.getLocalHost();
                String hostname = ip.getHostName();
                ipJTextField.setText(ip.toString());
                
            } catch (Exception e) {
                e.getMessage();
            } finally {}
        }
        if(actionEvent.getSource().equals(clientJButton)){

        }
        if(actionEvent.getSource().equals(historyJButton)){

        }
    }

    private void send(String message){
        
    }

}
