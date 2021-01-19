/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopye;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author FSE
 */
public class ProyectoPYE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmMenu p = new frmMenu();
        p.setSize(622, 421);
        p.setLocation(500, 200);
        p.setVisible(true);
        p.setResizable(false);
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
