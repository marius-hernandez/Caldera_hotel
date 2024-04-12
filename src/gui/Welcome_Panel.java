package gui;

//Importing required packages for GUI development
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

//Importing necessary packages for GUI design
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 * This class represents the Welcome panel.
 * It contains a cosntructor Welcome_Panel that initializes the size and the layout of the panel.
 */
public class Welcome_Panel extends JPanel {
	private static final long serialVersionUID = 1L; //serialization
	//Attribute for Welcome_Panel
	public JButton btnBookNow;
	JLabel lbl_image;

	public Welcome_Panel() {
		setBounds(100, 100, 1100,670);
		setLayout(null);
		
		//JButton for Book Now
		btnBookNow = new JButton("Book Now!");
		btnBookNow.setForeground(new Color(109, 71, 27));
		btnBookNow.setFont(new Font("Garamond", Font.BOLD, 44));
		btnBookNow.setBounds(736, 424, 251, 52);
		btnBookNow.setBackground(Color.WHITE);
		add(btnBookNow);
		
		//JLabel that displays the image as the background of the panel.
		lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
		
	}
}
