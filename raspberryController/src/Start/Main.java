/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    ServerSocket serverSocket;
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Move move = new Move();

    public void start() {
        try {
            serverSocket = new ServerSocket(52242);

            Thread go = new Thread(new Runnable() {

                @Override
                public void run() {

                    while (true) {

                        try {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            socket = serverSocket.accept();
                            oos = new ObjectOutputStream(socket.getOutputStream());
                            ois = new ObjectInputStream(socket.getInputStream());
                            while (true) {
                                String str = (String) ois.readObject();
                                if (str.equals("forward")) {
                                    move.forward();
                                } else if (str.equals("back")) {
                                    move.back();
                                } else if (str.equals("left")) {
                                    move.left();
                                } else if (str.equals("right")) {
                                    move.right();
                                } else if (str.equals("stop")) {
                                    move.stop();
                                } else if (str.equals("handUp")) {
                                    move.handUp();
                                } else if (str.equals("handDown")) {
                                    move.handDown();
                                } else if (str.equals("hold")) {
                                    move.hold();
                                } else if (str.equals("release")) {
                                    move.release();
                                } else if (str.equals("get picture")) {
                                    oos.writeObject(MAImage.getImageIcon());
                                }

                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            try {
                                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                                socket.close();
                                oos.close();
                                ois.close();
                            } catch (IOException ex1) {
                                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
                                //ex.printStackTrace();
                            }
                        }
                    }
                }
            });

            go.start();
        } catch (IOException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Main m = new Main();

        //m.move.waitSGD();
        //System.out.println("sgd");
        //m.move.waitSGU();
        //System.out.println("sgu");
        m.start();
    }

}
