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
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Contest extends JPanel implements ActionListener {
    private static final long serialVersionUID = -8832597883331891416L;
    private JPanel checkJPanel;
    private JButton answerJButton, serverJButton, clientJButton, historyJButton;
    public JTextField timerJTextField;
    private JLabel ipJLabel, nameJLabel, questionJLabel;
    private JTextField answerJTextField, nameJTextField, ipJTextField;
    private ArrayList<JLabel> answersCountJLabels;
    private Time time;
    private ServerSocket ss;
    private Socket s;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Loader loader;
    private InetAddress ip;
    private String message = "";

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
        checkJPanel = new JPanel(new GridLayout(2, 5, 1, 1));
        for(int i = 1; i < 11; i++){
            answersCountJLabels.add(new JLabel(String.valueOf(i)));
            answersCountJLabels.get(i-1).setSize(250, 50);
            answersCountJLabels.get(i-1).setOpaque(true);
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
    private void enableAnswer(int ans[]) {

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(answerJButton)){
            try{
                if(s){
                    //Validacion Pregunta
                    
                } else//Consurso no hay iniciado
                    JOptionPane.showMessageDialog(null, "No se ha iniciado o unido a un concurso");
            } catch (Exception e){

            } finally {}
        }
        if(actionEvent.getSource().equals(serverJButton)){
            try {
                ip = InetAddress.getLocalHost();
                ipJTextField.setText(Encrypt.encrypt(ip.getHostAddress()));
                ipJTextField.setEnabled(false);
                ss = new ServerSocket(3333);
                s = ss.accept();
                dataInputStream = new DataInputStream(s.getInputStream());
                dataOutputStream = new DataOutputStream(s.getOutputStream());
                dataOutputStream.writeUTF("0");
                dataOutputStream.flush();
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String s = dataInputStream.readUTF();
                            int[] ans = new int[s.length];
                            try{
                                for(int i = 0; i < s.length; i++)
                                    ans[i] = Character.getNumericValue(s.charAt(0));
                                enableAnswer(ans);
                            }
                            catch(Exception e){
                                System.out.println(e.getMessage());
                            } finally {}
                            if(s.length == 5)
                                break;
                        }
                        dataInputStream.close();
                        s.close();
                        ss.close();
                    }
                });
            } catch (Exception e) {
                e.getMessage();
            } finally {}
        }
        if(actionEvent.getSource().equals(clientJButton)){
            try {
                ip = InetAddress.getByAddress(Encrypt.decrypt(ipJTextField.getText()));
                s = new Socket(ip, 3333);
                dataInputStream = new DataInputStream(s.getInputStream());
                dataOutputStream = new DataOutputStream(s.getOutputStream());
                dataOutputStream.writeUTF("0");
                dataOutputStream.flush();
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String s = dataInputStream.readUTF();
                            int[] ans = new int[s.length];
                            try{
                                for(int i = 0; i < s.length; i++)
                                    ans[i] = Character.getNumericValue(s.charAt(0));
                                enableAnswer(ans);
                            }
                            catch(Exception e){
                                System.out.println(e.getMessage());
                            } finally {}
                            if(s.length == 5)
                                break;
                        }
                        dataOutputStream.close();
                        s.close();
                    }
                });
            } catch (Exception e) {
                e.getMessage();
            } finally {}
        }
        if(actionEvent.getSource().equals(historyJButton)){

        }
    }

}
