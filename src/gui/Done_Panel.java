package gui;

//Importing necessary packages for GUI development
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Importing necessary packages for GUI design
import java.awt.Image;
import java.awt.Font;

import components.Button;

/*
 * This class represents the last window after reserving a room in the hotel. 
 * It contains a constructor that initializes the size and the layout of the Done_Panel class, the JLabel component used as the panel's background.
 * The constructor also contains a JButton component that directs the customer to the home page when clicked.
 */
public class Done_Panel extends JPanel {
	private static final long serialVersionUID = 9L; //serialization
	//attributes for Done_Panel
	public Button btn_home;
	
	//Define a constructor for Done_Panel class.
	public Done_Panel() {
		//Sets the size and the layout of the Done_Panel
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		
		//JButton with the text 'Back to Home'
		btn_home = new Button("Back to Home");
		btn_home.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btn_home.setSize(188, 58);
		btn_home.setLocation(456, 460);
		//Adds the button in the panel
		add(btn_home);
		
		//JLabel component to display and add the image to the panel to use as the background.
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/9.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
	}

}
