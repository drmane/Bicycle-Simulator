/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.successframe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Venta que muestra un error en el caso de que haya
 * @author Daniel
 */
public class MiOptionPaneSuccess extends JOptionPane{
    
    private String texto;

    public MiOptionPaneSuccess(String texto) {
        super();
        this.texto = texto;
        
        JFrame ventana = new JFrame();
        ventana.setSize(200,100); //ajustar el tamaño de la ventana
        
        JOptionPane.showMessageDialog(ventana,texto,"SUCCESS!!",JOptionPane.INFORMATION_MESSAGE); //mostrar el mensaje
        setVisible(true);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
