package gui;

//Importing user defined packages
import components.*;
import reservation.*;

//Importing required packages for GUI development
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;

//Importing necessary packages for GUI design
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Overview_Panel extends JPanel implements ReservationObserver{
	private static final long serialVersionUID = 6L; //serialization
	
	// Attributes for Overview_Panel
    private Label lbl_ValidID;         // Label for displaying valid ID
    private Label lbl_Address;         // Label for displaying address
    private Label lbl_ContactNo;       // Label for displaying contact number
    private Label lbl_Name;            // Label for displaying name
    private Label lbl_Schedule;        // Label for displaying schedule
    private Label lbl_roomNo;          // Label for displaying room number
    private Label lbl_classification;  // Label for displaying classification
    private Label lbl_NoOfPeople;      // Label for displaying number of people

	private ComboBox cmb_rcpPayment;   // ComboBox for selecting payment type
	private JPanel panel;               // Panel for displaying additional information
	
	private Label lbl_rcpName;          // Label for displaying customer name
	private Label lbl_rcpRoom;          // Label for displaying room information
	private Label lbl_rcpID;            // Label for displaying valid ID
	private Label lbl_rcpDate;          // Label for displaying reservation dates
	private Label lbl_rcpTotal;         // Label for displaying total price
	
	public Button btn_confirm;           // Button for confirming the reservation
	public Button btn_back;              // Button for going back
	public Button btn_delete;			//button for deleting reservation

	//constructor
		/**
     * Creates an Overview_Panel object, which displays an overview of the reservation details.
     *
     * @param reservation Reservation object to observe and retrieve data from reservation
     */
	public Overview_Panel(Reservation reservation) {
		reservation.addObserver(this); // Adding this panel as an observer to the reservation object
		setBounds(100, 100, 1100, 670); // Setting the position and size of the panel
		setLayout(null); // Setting the layout manager to null (custom positioning of components)
		
		btn_delete = new Button("Back");
		btn_delete.setText("Delete");
		btn_delete.setBounds(908, 536, 158, 31);
		add(btn_delete);
		
		panel = new JPanel(); // Creating a new JPanel
		panel.setBounds(742, 171, 324, 326); // Setting the position and size of the panel
	    add(panel); // Adding the panel to the main panel
	    panel.setLayout(null); // Setting the layout manager of the panel to null
		
	    btn_back = new Button("Back"); // Creating a new button with the label "Back"
	    btn_back.setBounds(742, 536, 158, 31); // Setting the position and size of the button
	    add(btn_back); // Adding the button to the main panel
	    
	    btn_confirm = new Button("Confirm"); // Creating a new button with the label "Confirm"
	    btn_confirm.setBounds(742, 578, 324, 41); // Setting the position and size of the button
	    add(btn_confirm); // Adding the button to the main panel
		
		
		cmb_rcpPayment = new ComboBox();
		cmb_rcpPayment.setBounds(23, 255, 200, 34);
		cmb_rcpPayment.setModel(new DefaultComboBoxModel(new String[] {"", "Pay in Cash", "GCash", "Credit/Debit Card", "Online Bank", "PayPal"})); // Setting the model and initial options of the ComboBox
		cmb_rcpPayment.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        reservation.setPaymentType(cmb_rcpPayment.getSelectedItem()); // Updating the payment type in the reservation object when the selection changes
		    }
		});
		panel.add(cmb_rcpPayment);
		
		// properties of label for room number
		lbl_rcpRoom = new Label("Room");
		lbl_rcpRoom.setFont(new Font("Poppins", Font.PLAIN, 14));
		lbl_rcpRoom.setBounds(23, 65, 258, 34);
		panel.add(lbl_rcpRoom);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 193, 258, 11);
		panel.add(separator_2);
		
		// Creating a new Label with the text "Total: PHP hatdog"
		lbl_rcpTotal = new Label("Total: PHP ");
		lbl_rcpTotal.setFont(new Font("Poppins", Font.PLAIN, 21));
		lbl_rcpTotal.setBounds(23, 210, 258, 34);
		panel.add(lbl_rcpTotal);
		
		// Creating a new Label with the text "Name"
		lbl_rcpName = new Label("Name");
		lbl_rcpName.setFont(new Font("Poppins", Font.PLAIN, 14));
		lbl_rcpName.setBounds(23, 29, 258, 34);
		panel.add(lbl_rcpName);
		
		//creating label for datein dateout
		lbl_rcpDate = new Label("Date in to Date Out");
		lbl_rcpDate.setFont(new Font("Poppins", Font.PLAIN, 14));
		lbl_rcpDate.setBounds(23, 103, 280, 34);
		panel.add(lbl_rcpDate);
		
		//label for valid ID
		lbl_rcpID = new Label("Valid ID");
		lbl_rcpID.setFont(new Font("Poppins", Font.PLAIN, 14));
		lbl_rcpID.setBounds(23, 148, 280, 34);
		panel.add(lbl_rcpID);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(69, 511, 648, 15);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 354, 648, 15);
		add(separator);
		
		//label for schedule
		lbl_Schedule = new Label("");
		lbl_Schedule.setBounds(334, 305, 383, 34);
		add(lbl_Schedule);
		
		//label for no of people
		lbl_NoOfPeople = new Label("");
		lbl_NoOfPeople.setBounds(334, 260, 383, 34);
		add(lbl_NoOfPeople);
		
		//label for room number
		lbl_roomNo = new Label("");
		lbl_roomNo.setBounds(334, 215, 383, 34);
		add(lbl_roomNo);
		
		//label for name
		lbl_Name = new Label("");
		lbl_Name.setBounds(334, 373, 383, 34);
		add(lbl_Name);

		//label for contact number
		lbl_ContactNo = new Label("");
		lbl_ContactNo.setBounds(334, 418, 383, 34);
		add(lbl_ContactNo);

		//label for address
		lbl_Address = new Label("");
		lbl_Address.setBounds(334, 463, 383, 34);
		add(lbl_Address);

		//label for valid ID
		lbl_ValidID = new Label("");
		lbl_ValidID.setBounds(334, 533, 383, 34);
		add(lbl_ValidID);

		//label for classification
		lbl_classification = new Label("");
		lbl_classification.setBounds(334, 170, 383, 34);
		add(lbl_classification);
				
		//for background image
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/6.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
	}
	/**
	 * Updates the reservation details in the GUI.
	 *
	 * @param reservation the Reservation object containing the updated reservation details
	 */
	public void updateReservation(Reservation reservation) {
		lbl_roomNo.setText(Integer.toString(reservation.getRoomNumber())); // Setting the room number in the corresponding label
		lbl_classification.setText(reservation.getClassification()); // Setting the classification in the corresponding label
		lbl_Name.setText(reservation.getFirstName() + " " + reservation.getMiddleName() + " " + reservation.getLastName()); // Setting the full name in the corresponding label
		lbl_ContactNo.setText(reservation.getContactNo()); // Setting the contact number in the corresponding label
		lbl_Address.setText(reservation.getAddress()); // Setting the address in the corresponding label
		lbl_ValidID.setText(reservation.getValidID()); // Setting the valid ID in the corresponding label
	
		lbl_rcpName.setText(reservation.getFirstName() + " " + reservation.getMiddleName() + " " + reservation.getLastName()); // Setting the full name in the receipt name label
		lbl_rcpRoom.setText(reservation.getClassification() + " #" + reservation.getRoomNumber()); // Setting the room information in the receipt room label
		lbl_rcpID.setText(reservation.getValidID()); // Setting the valid ID in the receipt ID label
	
		lbl_rcpTotal.setText("Total: PHP " + new DecimalFormat("#,###").format(reservation.getPrice())); // Setting the total price in the receipt total label
		lbl_NoOfPeople.setText(String.valueOf(reservation.getNoOfPeople())); // Setting the number of people in the corresponding label
	
		if (reservation.getDateIn() != null && reservation.getDateOut() != null) {
			// If the check-in and check-out dates are not null, format and set the dates in the labels
			lbl_rcpDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(reservation.getDateIn()) + " to " + new SimpleDateFormat("MM/dd/yyyy").format(reservation.getDateOut())); // Setting the formatted check-in and check-out dates in the receipt date label
			lbl_Schedule.setText(new SimpleDateFormat("MM/dd/yyyy").format(reservation.getDateIn()) + " to " + new SimpleDateFormat("MM/dd/yyyy").format(reservation.getDateOut()) +"  |  Time: "+reservation.getTimeIn()+" - "+reservation.getTimeOut()); // Setting the formatted check-in and check-out dates in the schedule label
			cmb_rcpPayment.setSelectedItem(reservation.getPaymentType()); // Setting the payment type in the payment ComboBox
		} else {
			lbl_Schedule.setText("N/A"); // If the check-in or check-out dates are null, display "N/A" in the schedule label
		}
		
		
    }
}
