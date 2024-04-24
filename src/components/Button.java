package components;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

// this is for the properties of custom JButton
public class Button extends JButton {
	private static final long serialVersionUID =11L; //serialization
    public Button(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        setBackground(new Color(234, 234, 234));
        setSize(139, 42);
    }

}
