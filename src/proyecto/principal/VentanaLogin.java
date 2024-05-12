/*
 * IGNORAR POR AHORA
 * 
 */
package proyecto.principal;

import javax.swing.*;

/**
 *
 * @author antonio
 */
public class VentanaLogin extends JFrame{
    private int altura;
    private int anchura;
    
    public VentanaLogin(int x, int y){
        anchura =x;
        altura = y;
    }
    
    public void setUpGUI(){
        JFrame frame = new JFrame("Title goes here");
        setSize(anchura, altura);
        JTextField text = new JTextField(20);
        JButton button = new JButton("Click me");
        JPanel panel = new JPanel();
        panel.add(text);
        panel.add(button);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*
        
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        */
    
    }
    
    
    
}
