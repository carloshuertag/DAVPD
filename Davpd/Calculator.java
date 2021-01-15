import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.util.ArrayList;

public class Calculator extends JPanel implements ActionListener, ItemListener {
    private static final long serialVersionUID = 7872053894321484049L;
    private JPanel davpdJPanel, paramsJPanel, actionJPanel, varJPanel;
    private JButton clearJButton, calculateJButton;
    private JLabel varJLabel;
    private JTextField varJTextField;
    private JComboBox davpdJComboBox, functionJComboBox;
    private ArrayList<JLabel> paramJLabels;
    private ArrayList<JTextField> paramJTextFields;
    private ArrayList<Davpd> davpds;
    public Calculator(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        setLayout(new GridLayout(1,2,2,2));
        setDavpd();
        add(davpdJPanel);
        setCalculator();
        add(actionJPanel);
    }
    private void setDavpds() {
        davpds = new ArrayList<Davpd>();
        davpds.add(new Bernoulli());
        davpds.add(new Binomial());
        davpds.add(new NegativeBinomial());
        davpds.add(new Geometric());
        davpds.add(new Hipergeometric());
        davpds.add(new Poisson());
    }
    private void enableParams(int c){
        switch (c) {
            case 1://Bernoulli Geometric
            paramJLabels.get(0).setText("p: ");
            paramJLabels.get(0).setEnabled(true);
            break;
            case 2://Binomial
            paramJLabels.get(0).setText("p: ");
            paramJTextFields.get(0).setEnabled(true);
            paramJLabels.get(1).setText("n: ");
            paramJTextFields.get(1).setEnabled(true);
            break;
            case 3://NegativeBinomial
            paramJLabels.get(0).setText("p: ");
            paramJTextFields.get(0).setEnabled(true);
            paramJLabels.get(1).setText("k: ");
            paramJTextFields.get(1).setEnabled(true);
            break;
            case 4://Hipergeometric
            paramJLabels.get(0).setText("r1: ");
            paramJTextFields.get(0).setEnabled(true);
            paramJLabels.get(1).setText("r2: ");
            paramJTextFields.get(1).setEnabled(true);
            paramJLabels.get(2).setText("n: ");
            paramJTextFields.get(2).setEnabled(true);
            break;
            case 5://Poisson
            paramJLabels.get(0).setText("lamda: ");
            paramJTextFields.get(0).setEnabled(true);
            break;
            default://Undefined
            break;
        }
    }
    private void setParams(){
        paramJLabels.add(new JLabel());
        paramJTextFields.add(new JTextField());
        paramJLabels.add(new JLabel());
        paramJTextFields.add(new JTextField());
        paramJLabels.add(new JLabel());
        paramJTextFields.add(new JTextField());
        paramJTextFields.get(0).setEnabled(false);
        paramJTextFields.get(1).setEnabled(false);
        paramJTextFields.get(2).setEnabled(false);
        enableParams(0);
        for(int i = 0; i < paramJLabels.size(); i++){
            paramsJPanel.add(paramJLabels.get(i));
            paramsJPanel.add(paramJTextFields.get(i));
        }
        davpdJPanel.add(paramsJPanel);
    }
    private void setDavpd(){
        setDavpds();
        davpdJPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        davpdJComboBox = new JComboBox();
        davpdJComboBox.addItem("Select distribution");
        davpds.forEach( (d) -> { davpdJComboBox.addItem(d.getClass().getSimpleName()); } );
        davpdJComboBox.setSelectedIndex(0);
        davpdJComboBox.addItemListener(this);
        davpdJPanel.add(davpdJComboBox);
        paramsJPanel = new JPanel(new GridLayout(3, 2, 2, 4), true);
        paramJLabels = new ArrayList<JLabel>();
        paramJTextFields = new ArrayList<JTextField>();
        setParams();
    }
    private void setCalculator(){
        actionJPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        varJPanel = new JPanel(new GridLayout(2, 2, 2, 2));        
        varJLabel = new JLabel("X");
        varJTextField = new JTextField();
        varJPanel.add(varJLabel);
        varJPanel.add(varJTextField);
        functionJComboBox = new JComboBox();
        functionJComboBox.addItem("Select function");
        functionJComboBox.addItem("P(X = x): ");
        functionJComboBox.addItem("P(X ≤ x): ");
        functionJComboBox.addItem("P(X >= x): ");
        functionJComboBox.setSelectedIndex(0);
        functionJComboBox.addActionListener(this);
        varJPanel.add(functionJComboBox);
        clearJButton = new JButton("Clear");
        clearJButton.addActionListener(this);
        calculateJButton = new JButton("Calculate");
        calculateJButton.addActionListener(this);
        varJPanel.add(calculateJButton);
        actionJPanel.add(varJPanel);
        actionJPanel.add(clearJButton);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getActionCommand().equals("")){

        }
    }
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if(itemEvent.getItem().equals(davpds.get(0).getClass().getSimpleName()) || itemEvent.getItem().equals(davpds.get(3).getClass().getSimpleName()))
            enableParams(1);
        if(itemEvent.getItem().equals(davpds.get(1).getClass().getSimpleName()))
            enableParams(2);
        if(itemEvent.getItem().equals(davpds.get(2).getClass().getSimpleName()))
            enableParams(3);
        if(itemEvent.getItem().equals(davpds.get(4).getClass().getSimpleName()))
            enableParams(4);
        if(itemEvent.getItem().equals(davpds.get(5).getClass().getSimpleName()))
            enableParams(5);
    }
}
