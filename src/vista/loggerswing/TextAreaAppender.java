/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.loggerswing;

/**
 * Clase que permite establecer el logger en el tect area
 * @author Daniel
 */
import javax.swing.JTextArea;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class TextAreaAppender extends AppenderSkeleton {

    private static final String DEFAULT_PATTERN = "%d{ABSOLUTE} %5p %c{1}:%L - %m%n";
    private JTextArea jTextArea;

    /**
     * Permite unir el jTextArea al Logger
     * @param jTextArea  el jTextArea
     */
    public TextAreaAppender(JTextArea jTextArea) {
            if (jTextArea == null) {
                    throw new IllegalArgumentException("El jTextArea no puede ser nulo");
            }

            this.jTextArea = jTextArea;
    }

    /**
     * Cierra
     */
    public void close() {
            //no hacer nada
    }

    /**
     * Permite ver si el jTextArea necesita una disposicion para mostrarlo
     * @return si la necesita o no
     */
    public boolean requiresLayout() {
            return true;
    }

    @Override
    public Layout getLayout() {
            if (layout == null) {
                    layout = new PatternLayout(DEFAULT_PATTERN);
            }

            return super.getLayout();
    }

    @Override
    protected void append(LoggingEvent event) {
            String formatted = getLayout().format(event);

            jTextArea.append(formatted);
    }
}