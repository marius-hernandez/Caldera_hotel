package gui;

//Importing user defined packages
import components.*;
import functions.ErrorHandler;
import reservation.*;

//Importing necessary packages for GUI development
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.JSpinner;

//Importing necessary packages for GUI design
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.function.BiConsumer;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.text.AbstractDocument;

/*
 * This class represents the customer information window that display variuous input components to get values from the customer.
 * It contains a constructor for initializing the size and the layout of the panel and other GUI components.
 * It contains 'ReservationObserver' which provides a way for the CustomerInfo_Panel class to obsereve changes in "Reservaion" object.
 */
class CustomerInfo_Panel extends JPanel implements ReservationObserver{
	private static final long serialVersionUID = 1L; //serialization
	
	//Attributes for CustomerInfo_Panel
	public Button btn_next;
	public Button btn_back;
	
	private JTextField txt_address;
	private JTextField txt_first;
	private JTextField txt_contact;
	private JTextField txt_last;
	private JTextField txt_middle;
	
	private JSpinner spr_age;
	private ComboBox cmb_PaymentType;
	private ComboBox cmb_gender;
	private ComboBox cmb_ValidID;
	
	private Reservation reservation;
	private JSeparator separator;
	private JSeparator separator_1;
	
	/**
     * Initializes the CustomerInfo_Panel with the specified title and dimensions.
     *
     * @param reservation - parameter for passing reservation object
     */
	public CustomerInfo_Panel(Reservation reservation) {
		reservation.addObserver(this);
		
		//Sets the size and layout of the CustomerInfor_Panel
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		
		//Creates Jseparator objects and add them to the panel.
		separator_1 = new JSeparator();
		separator_1.setBounds(71, 427, 581, 22);
		add(separator_1);
				
		separator = new JSeparator();
		separator.setBounds(71, 359, 581, 22);
		add(separator);
		
		//Text field for the customer's first name.
		txt_first = new JTextField();
		txt_first.setColumns(10);
		txt_first.setBounds(280, 176, 372, 34);
		add(txt_first);	
		
		//Text field for the customer's middle name.
		txt_middle = new JTextField();
		txt_middle.setColumns(10);
		txt_middle.setBounds(280, 221, 372, 34);
		add(txt_middle);
		
		//Text field for the customer's last name.
		txt_last = new JTextField();
		txt_last.setColumns(10);
		txt_last.setBounds(280, 266, 372, 34);
		add(txt_last);
		
		//Text field for the customer's contact number.
		//Restricts input to be only digits.
		try {
			txt_contact = new JFormattedTextField(new MaskFormatter("09##-###-####"));
			txt_contact.setColumns(11);
			((AbstractDocument) txt_contact.getDocument()).setDocumentFilter(new DocumentFilter() {
			    @Override
			    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			    	//Gets the current text of the document and append the new text.
			        String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
			        //Checks if the text matches a pattern of zero or more digits.
			        if (newText.matches("\\d{0,11}")) {
			            super.replace(fb, offset, length, text, attrs);	        
			        }
			    }
			});
		} catch (ParseException e1) {
			ErrorHandler.handle("An error occurred: " + e1.getMessage(), e1);
		}
		


		txt_contact.setColumns(10);
		txt_contact.setBounds(280, 310, 372, 34);
		add(txt_contact);
		
		//Checks if the text matches a pattern of zero or more digits.
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(280, 379, 372, 34);
		add(txt_address);

		//JComboBox object for ValidID with corresponding ID options.
		cmb_ValidID = new ComboBox();
		cmb_ValidID.setModel(new DefaultComboBoxModel(new String[] {"", "National ID", "Postal ID", "Passport", "Driver's License", "TIN ID", "UMID "}));
		cmb_ValidID.setBounds(280, 447, 372, 34);
		add(cmb_ValidID);
		
		//JComboBox object for PaymentType with corresponding payment options.
		cmb_PaymentType = new ComboBox();
		cmb_PaymentType.setModel(new DefaultComboBoxModel(new String[] {"", "Pay in Cash", "GCash", "Credit/Debit Card", "Online Bank", "PayPal"}));
		//ActionListener is added to the ComboBox to set the payment type of reservation when a selection is made.
		cmb_PaymentType.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        reservation.setPaymentType(cmb_PaymentType.getSelectedItem());
		    }
		});
		cmb_PaymentType.setBounds(280, 493, 372, 34);
		add(cmb_PaymentType);
		
		//JComboBox for Gender with corresponding options.
		cmb_gender = new ComboBox();
		cmb_gender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Non-binary", "Transgender", "Not Specified"}));
		cmb_gender.setBounds(847, 220, 180, 34);
		add(cmb_gender);
		
		//JSpinner for customer's age with a default value of 18, and a range from 18 to 100 incremented by 1.
		spr_age = new JSpinner();
		spr_age.setModel(new SpinnerNumberModel(18, 18, 100, 1));
		spr_age.setBounds(847, 176, 180, 34);
		add(spr_age);
	
		//JButton for back/previous
		btn_back = new Button("Back");
		btn_back.setLocation(739, 564);
		add(btn_back);
		
		//JButton for Next with added ActionListener
		btn_next = new Button("Next");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets the values entered by the user from various text fields and input components.
				//Sets the values as properties of the 'reservation' object.
				reservation.setFirstName(txt_first.getText());
				reservation.setLastName(txt_last.getText());
				reservation.setMiddleName(txt_middle.getText());
				reservation.setContactNo(txt_contact.getText());
				reservation.setAddress(txt_address.getText());
				reservation.setValidID((String) cmb_ValidID.getSelectedItem());
				reservation.setPaymentType((String) cmb_PaymentType.getSelectedItem());
				reservation.setAge((int) spr_age.getValue());
				reservation.setGender((String) cmb_gender.getSelectedItem());
				
			}
		});
		btn_next.setLocation(888, 564);
		add(btn_next);
			
		//JLabel component to display an image and add it to the panel to use as the background.
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/5.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
		
		//To call addComoponentListener method to each textfield.
		addComponentListener(txt_first, (component, value) -> {
		    reservation.setFirstName((String) value);
		});
		addComponentListener(txt_last, (component, value) -> {
		    reservation.setLastName((String) value);
		});
		addComponentListener(txt_middle, (component, value) -> {
		    reservation.setMiddleName((String) value);
		});
		addComponentListener(txt_address, (component, value) -> {
		    reservation.setAddress((String) value);
		});
		addComponentListener(txt_contact, (component, value) -> {
		    reservation.setContactNo((String) value);
		});
		addComponentListener(cmb_PaymentType, (component, value) -> {
		    reservation.setPaymentType((String) value);
		});
		addComponentListener(cmb_gender, (component, value) -> {
		    reservation.setGender((String) value);
		});
		addComponentListener(cmb_ValidID, (component, value) -> {
		    reservation.setValidID((String) value);
		});
		
	}
	/**
     * This method is called when btn_next is clicked
     *
     * @param e - parameter for action listener
     */
	//This method is called when the 'next' button is clicked.
	public void btn_nextAction(ActionEvent e) {
		//Updates the reservation object with the user inputs in the various input components.
		reservation.setFirstName(txt_first.getText());
		reservation.setMiddleName(txt_middle.getText());
		reservation.setLastName(txt_last.getText());
		reservation.setNoOfPeople(Integer.parseInt(txt_last.getText()));
		reservation.setContactNo(txt_contact.getText());
		reservation.setAddress(txt_address.getText());
		reservation.setValidID((String) cmb_ValidID.getSelectedItem());
		reservation.setPaymentType(cmb_PaymentType.getSelectedItem());
		reservation.setAge((int) spr_age.getValue());
		reservation.setGender((String) cmb_gender.getSelectedItem());
    }

	/**
     * This method is for restricting the JTextFields and JComboBoxes when they are active.
     *
     * @param component - parameter for JTextField and JComboBox constraints
     * @param consumer - parameter for JTextField and JComboBox constraints
     */
	public static void addComponentListener(JComponent component, BiConsumer<JComponent, Object> consumer) {
	    if (component instanceof JTextField) {
	        component.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                consumer.accept(component, ((JTextField) component).getText());
	            }
	        });
	    } else if (component instanceof JComboBox) {
	        ((JComboBox<?>) component).addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(((JComboBox<?>) component).getSelectedItem() != "") {
	            		consumer.accept(component, ((JComboBox<?>) component).getSelectedItem());
	            	}
	                
	            }
	        });
	    }
	}

	/**
     * This method is for observers
     *
     * @param reservation - parameter for reservation object
     */
	//This method updates the payment type to match the payment type in the reservation object.
	public void updateReservation(Reservation reservation) {
		cmb_PaymentType.setSelectedItem(reservation.getPaymentType());
		btn_next.setEnabled(false);
		
		if(reservation.emptyFieldChecker()==false) {
			btn_next.setEnabled(false);
		}
		else {
			btn_next.setEnabled(true);
		}
		
    }
	
	
}
