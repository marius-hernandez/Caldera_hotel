package functions;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Label;

public class ComponentUtils {
    public static void clearAll(JPanel panel_pages) {
    	
        Component[] components = panel_pages.getComponents();
        
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof Label) {
                ((JLabel) component).setText("");
            }else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedItem("");
            }
            
        }
    }
}
