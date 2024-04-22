package gui;

//Importing required packages for GUI development
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Importing necessary packages for GUI design
import java.awt.Image;

//Importing user defined packages
import components.*;

/**
 * This class represents the classification window that displays the room classifications that the hotel is offering, it can be modified to proper use
 * It contains a constructor for initializing the size and the layout of the panel, and the buttons.
 * It also contains four buttons for each room classification.
 */


public class Classification_Panel extends JPanel {
	private static final long serialVersionUID = 31L; //serialization
	//attributes for Classification_Panel
	public Button btnSuperior;
	public Button btnDeluxe;
	public Button btnFamily;
	public Button btnStandard;
	
	//Constructor for Classification_Panel class, which is the properties/style of the panel
	public Classification_Panel() {
		//Set the size and layout of the panel.
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		
		//Button for Superior
		btnSuperior = new Button("See all rooms...");
		btnSuperior.setBounds(817, 491, 156, 46);
		add(btnSuperior);
		
		//Button for Deluxe
		btnDeluxe = new Button("See all rooms...");
		btnDeluxe.setBounds(590, 491, 156, 46);
		add(btnDeluxe);
		
		//Button for Family
		btnFamily = new Button("See all rooms...");
		btnFamily.setBounds(356, 491, 156, 46);
		add(btnFamily);

		//Button for Standard
		btnStandard = new Button("See all rooms...");
		btnStandard.setBounds(119, 491, 156, 46);
		add(btnStandard);
		
		//JLabel component to display an image and add it to the panel to use as the background.
		JLabel lbl_image = new JLabel("New label");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
		
	}
}








