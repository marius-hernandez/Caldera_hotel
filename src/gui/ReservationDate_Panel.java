package gui;

//Importing user defined packages
import components.*;
import reservation.*;

//Importing required packages for GUI development
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

//Importing necessary packages for GUI design
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;



public class ReservationDate_Panel extends JPanel implements ReservationObserver{
	private static final long serialVersionUID = 4L; //serialization
	
	//attributes for ReservationDate_Panel
	public JButton btnNext;
	public JSpinner spr_timeIn;
	public JSpinner spr_timeOut;
	public Button btn_back;
	private JSpinner spr_noOfPeople;
	
	public DatePicker dtch_dateIn;
	public DatePicker dtch_dateOut;

	// Constructor for ReservationDate_Panel, taking a Reservation object as a parameter
	/**
	 * Creates a ReservationDate_Panel object for managing reservation date details in the GUI.
	 *
	 * @param reservation the Reservation object containing the updated reservation details
	 */
	public ReservationDate_Panel(Reservation reservation) {
		reservation.addObserver(this);
		
		// Setting the bounds and layout for the panel
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		

		// Creating and adding a back button to the panel
		btn_back = new Button("Next");
		btn_back.setText("Back");
		btn_back.setBounds(524, 520, 139, 42);
		add(btn_back);
		
		// Creating and configuring a spinner for the time out selection
		spr_timeOut = new JSpinner();
		spr_timeOut.setModel(new SpinnerListModel(new String[] {"1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 nn", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm", "11:00 pm", "12:00 mn"}));
		spr_timeOut.setBounds(767, 329, 71, 34);
		add(spr_timeOut);
		
		// Creating and configuring a spinner for the time in selection
		spr_timeIn = new JSpinner();
		spr_timeIn.setModel(new SpinnerListModel(new String[] {"1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 nn", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm", "11:00 pm", "12:00 mn"}));
		spr_timeIn.setBounds(767, 222, 71, 34);
		add(spr_timeIn);
		
		// Creating a spinner for selecting the number of people
		spr_noOfPeople = new JSpinner();
		spr_noOfPeople.setBounds(347, 434, 342, 34);
		add(spr_noOfPeople);
		
		// Creating a date picker for datein
		dtch_dateIn = new DatePicker();
		dtch_dateIn.setBounds(347, 222, 410, 34);
		add(dtch_dateIn);
		
		// Creating a date picker for dateout
		dtch_dateOut = new DatePicker();
		dtch_dateOut.setBounds(347, 329, 410, 34);
		add(dtch_dateOut);
		
		// Creating a next button and adding an action listener to it
		btnNext = new Button("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation.setNoOfPeople((int) spr_noOfPeople.getValue());
				reservation.setDateIn(dtch_dateIn.getDate());
				reservation.setDateOut(dtch_dateOut.getDate());
				reservation.setTimeIn(spr_timeIn.getValue());
				reservation.setTimeOut(spr_timeOut.getValue());
				// date In date Out computation, how much is the cost
				// Computing the number of days between date in and date out
				reservation.setPrice(reservation.getPrice() * totalComputation());
			}
		});
		btnNext.setLocation(673, 520);
		add(btnNext);
		
		// Creating a label for displaying an image
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/4.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
	}
	
	/**
	 * Updates the reservation details in the GUI based on the changes observed.
	 *
	 * @param reservation the Reservation object containing the updated reservation details
	 */
	public void updateReservation(Reservation reservation) {
	    if(reservation.getRoomSize() < 1) {
	    	spr_noOfPeople.setModel(new SpinnerNumberModel(1, 1, 1, 1));
	    }
	    else {
	    	spr_noOfPeople.setModel(new SpinnerNumberModel(1, 1, reservation.getRoomSize(), 1));
	    }
	}
	//method for computation of total based on number of days to stay
	public int totalComputation() {
		// Convert the date objects to Instant
		Instant dateInInstant = dtch_dateIn.getDate().toInstant();
		Instant dateOutInstant = dtch_dateOut.getDate().toInstant();

		// Get the LocalDate objects using the system default time zone
		LocalDate dateInLocal = dateInInstant.atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dateOutLocal = dateOutInstant.atZone(ZoneId.systemDefault()).toLocalDate();

		// Calculate the difference between the dates
		long total = ChronoUnit.DAYS.between(dateInLocal, dateOutLocal);

		if(total == 0) {
			total=1;
		}
		
		return (int) total;
	}
	
	

	
}
