package gui;

//Importing required packages for GUI development
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Importing necessary packages for GUI design
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

//Importing user defined package
import components.*;

/**
 * This class represents the Terms and Condition Panel.
 * It contains a constructor TAC_Panel which initializes the size and the layout of the panel.
 */
public class TAC_Panel extends JPanel {
	private static final long serialVersionUID = 7L; //serialization
	
    //Attribute for TAC_Panel
	public Button btn_next;
	
    //Constructor for TAC_Panel class.
	public TAC_Panel() {
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		
        //JButton for Next
		btn_next = new Button("Next");
		btn_next.setLocation(889, 576);
		add(btn_next);
		
        //JLabel which displays the image to be used as the background.
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/7.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
	}
}
/**
 * This class is for the second panel for the hotel's terms and conditions.3
 * It contains a constructor which intializes the size and the layout of the panel.
 */
class TAC_Panel2 extends JPanel {
	private static final long serialVersionUID = 8L; //serialization
	//Attributes for TAC_Panel2.
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    Button btn_next;
    ButtonGroup G1;

    //Constructor for TAC_Panel2 class.
	public TAC_Panel2() {

        //Size and layout of the panel.
		setBounds(100, 100, 1100, 670);
		setLayout(null);
        
		
        //JRadioButton for Agree and Disagree. 
        jRadioButton1 = new JRadioButton();
        
        jRadioButton1.setSelected(true);
        jRadioButton2 = new JRadioButton();
        jRadioButton1.setBackground(new Color(236,202,162));
        jRadioButton2.setBackground(new Color(236,202,162));
        
        //JButton for Next
        btn_next = new Button("Next");
        btn_next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	
            }
        });
        btn_next.setLocation(889, 576);
		add(btn_next); //adds the next button to the panel.
		
		//Panel for the JRadioButtons
        G1 = new ButtonGroup();
        jRadioButton1.setText("I agree with the terms and conditions, and I'm alowing the Hotel to collect my data");
        jRadioButton2.setText("I disagree with the terms and conditions, and not alowing the Hotel to collect my data");
        jRadioButton1.setBounds(110, 518, 700, 50);
        jRadioButton2.setBounds(110, 550, 700, 50);
        
        add(jRadioButton1);
        add(jRadioButton2);
        
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        
        //Backgorund image for the TAC_Panel2
        JLabel lbl_image = new JLabel("");
        lbl_image.setBounds(0, 0, 1090, 635);
        //Displays the image as the panel's background.
		Image img_sample = new ImageIcon(this.getClass().getResource("/8.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
        lbl_image.setIcon(new ImageIcon(img_sample2));
        add(lbl_image);
        
        //Enable next button if user agree with terms and condition
        jRadioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	btn_next.setEnabled(true);
            }
        });
        //Disable next button if user disagree with terms and condition
        jRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	btn_next.setEnabled(false);
            }
        });
	}
	
}
