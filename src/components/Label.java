package components;

import javax.swing.JLabel;

import java.awt.Font;

public class Label extends JLabel {
	private static final long serialVersionUID = 44L; //serialization
    public Label(String text) {
    	
        super(text);
        setFont(new Font("Poppins", Font.PLAIN, 15));
    }

}