/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author pi
 */
public class MAImage {
    public static ImageIcon getImageIcon(){
        try {
            Runtime rt=Runtime.getRuntime();
            System.out.println("generating pic.jpg...");
            Process pr=rt.exec("fswebcam /home/pi/pic.jpg");
            pr.waitFor();
            ImageIcon im=new ImageIcon("/home/pi/pic.jpg");
            System.out.println("sending pic.jpg...");
            return im;
            
        } catch (Exception ex) {
            //Logger.getLogger(MAImage.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
}
