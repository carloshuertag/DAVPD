import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
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
    private JButton answerJButton, clearJButton, startJButton, historyJButton;
    public JTextField timerJTextField;
    private JLabel ipJLabel, nameJLabel, questionJLabel;
    private JTextField answerJTextField, nameJTextField, ipJTextField;
    private ArrayList<JLabel> answersCountJLabels;
    private ArrayList<String> questions, answers;
    private Time time;
    private Loader loader;
    private int contest;
    /*
    private ServerSocket ss;
    private Socket s;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private InetAddress ip;
    
    private String message = "";
    */

    public Contest(int width, int height) {
        setSize(width, height);
        setLayout(new GridLayout(4, 3, 4, 4));
        initElements();
    }
    private void initElements() {
        initIp();
        initAnswer();
        time = new Time(this);
        loader = new Loader();
        contest = -1;
        initCheck();
        loader.input();
        addElements();
        setContest();
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
        clearJButton = new JButton("Limpiar");
        clearJButton.setSize(250, 50);
        clearJButton.addActionListener(this);
        startJButton = new JButton("Iniciar");
        startJButton.setSize(250, 50);
        startJButton.addActionListener(this);
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
        answersCountJLabels = new ArrayList<>();
        checkJPanel = new JPanel(new GridLayout(1, 5, 1, 1));
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
        add(clearJButton);
        add(startJButton);
        add(answerJButton);
        add(timerJTextField);
        add(checkJPanel);
        add(historyJButton);
    }
    private void enableAnswer(boolean correct) {
        if(correct) {
            answersCountJLabels.get(contest).setBackground(Color.GREEN);
            JOptionPane.showMessageDialog(null, "Respuesta correcta");
        }
        else {
            answersCountJLabels.get(contest).setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
        }
    }
    public void setContest(){
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        questions.add("Dada una distribución de Poisson, elegir la afirmación falsa.\na. Media y varianza coinciden.\nb. Tiene un sólo parámetro.\nc. La media sólo puede tomar valores enteros.\nd. La variable nunca toma valores negativos.");
        answers.add("c");
        questions.add("Un valor x de la variable aleatoria es posible si tiene probabilidad de ocurrencia diferente a:\na. Infinito.\nb. La covarianza.\nc. Cero.\nd. El primer momento.");
        answers.add("c");
        questions.add("La varianza de una _____________ nos da como resultado cero:\na. Variable.\nb. Constante.\nc. Esperanza.\nd. Desviacion.");
        answers.add("b");
        questions.add("La n-ésima derivada de la f.g.m evaluada en cero es el n-ésimo ___________.\na. Infinito.\nb. Integrador.\nc. Origen.\nd. Momento.");
        answers.add("d");
        questions.add("La función de probabilidad acumulada será 1 en cualquier caso cuando x es menor a:\na. n.\nb. La covarianza.\nc. Cero.\nd. Infinito.");
        answers.add("d");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(answerJButton)){
            try{
                if(contest != -1){
                    enableAnswer(answerJTextField.getText().equalsIgnoreCase(answers.get(contest)));
                    contest++;
                    if(contest == 5){
                        contest = -1;
                        JOptionPane.showMessageDialog(null, String.format("El concurso ha terminado en %s segundos", timerJTextField.getText()));
                        loader.newOpponent(new User(nameJTextField.getText(), ipJTextField.getText()));
                        loader.output();
                        time.stop();
                        timerJTextField.setText("0");
                    } else 
                        questionJLabel.setText(questions.get(contest));
                    answerJTextField.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "No ha iniciado el concurso");
                /*
                if(s != null){
                    //Validacion Pregunta
                    dataOutputStream.writeUTF(message);  
                    dataOutputStream.flush(); 
                } else//Consurso no hay iniciado
                    JOptionPane.showMessageDialog(null, "No se ha iniciado o unido a un concurso");
                */
            } catch (Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Formato de entrada inválido");
            } finally {}
        }
        if(actionEvent.getSource().equals(clearJButton)){
            try {
                answerJTextField.setText("");
                questionJLabel.setText("");
                nameJTextField.setText("");
                ipJTextField.setText("");
                time.stop();
                timerJTextField.setText("0");
                /*
                ip = InetAddress.getLocalHost();
                ipJTextField.setText(Encrypt.encrypt(ip.toString()));
                ipJTextField.setEnabled(false);
                ss = new ServerSocket(3333);
                s = ss.accept();
                dataInputStream = new DataInputStream(s.getInputStream());
                dataOutputStream = new DataOutputStream(s.getOutputStream());
                dataOutputStream.writeUTF("");
                dataOutputStream.flush();
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        try{
                            while(true){
                                String str = dataInputStream.readUTF();
                                int[] ans = new int[str.length()];
                                for(int i = 0; i < str.length(); i++)
                                    ans[i] = Character.getNumericValue(str.charAt(0));
                                enableAnswer(ans);
                                if(str.length() == 5)
                                    break;
                            }
                            dataInputStream.close();
                            s.close();
                            ss.close();
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        } finally {}
                    }
                });
                */
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Formato de entrada inválido");
            } finally {}
        }
        if(actionEvent.getSource().equals(startJButton)){
            try {
                if(contest == -1 && !nameJTextField.getText().equals("")){
                    contest++;
                    questionJLabel.setText(questions.get(contest));
                    JOptionPane.showMessageDialog(null, "Empieza ahora");
                    time.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al inicar concurso");
                }
                /*
                ip = InetAddress.getByName(Encrypt.decrypt(ipJTextField.getText()));
                s = new Socket(ip, 3333);
                loader.newOpponent(new User(nameJTextField.getText(), ipJTextField.getText()));
                dataInputStream = new DataInputStream(s.getInputStream());
                dataOutputStream = new DataOutputStream(s.getOutputStream());
                dataOutputStream.writeUTF("");
                dataOutputStream.flush();
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        try{
                            while(true){
                                String str = dataInputStream.readUTF();
                                int[] ans = new int[str.length()];
                                for(int i = 0; i < str.length(); i++)
                                    ans[i] = Character.getNumericValue(str.charAt(0));
                                enableAnswer(ans);
                                if(str.length() == 5)
                                    break;
                            }
                            dataOutputStream.close();
                            s.close();
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        } finally {}
                        
                    }
                });
                */
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Formato de entrada inválido");
            } finally {}
        }
        if(actionEvent.getSource().equals(historyJButton)){
            String str = loader.getOpponents().toString();
            JOptionPane.showMessageDialog(null, "Tu historial de partidas: \n" + str);
        }
    }

}
