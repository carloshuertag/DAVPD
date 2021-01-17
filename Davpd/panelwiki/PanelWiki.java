/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelwiki;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author FSE
 */
public class PanelWiki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wiki p = new Wiki();
        JFrame f = new JFrame();
        f.setSize(605, 421);
        f.setLocation(500, 200);
        f.getContentPane().add(p);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
