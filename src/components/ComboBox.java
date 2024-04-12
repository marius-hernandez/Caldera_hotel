package components;

import java.awt.Font;
import javax.swing.JComboBox;

public class ComboBox extends JComboBox {
	private static final long serialVersionUID = 22L; //serialization
    public ComboBox() {
    	setFont(new Font("Century Gothic", Font.PLAIN, 20));
    }
}