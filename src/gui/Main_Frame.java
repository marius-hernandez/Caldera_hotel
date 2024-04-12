package gui;
//Importing required packages
import database.*;
import reservation.*;
import functions.ComponentUtils;
import functions.DragListener;
import functions.ErrorHandler;

//Importing necessary packages for event handling and database access
import java.awt.event.ActionListener;
import java.util.Calendar;

//Importing required packages for GUI development
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//Importing necessary packages for GUI design
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


public class Main_Frame extends JFrame {
	private static final long serialVersionUID = 2L; //serialization

	private CardLayout cObjl;  
	private JPanel cPanel;
	// Declaration of panel objects for the GUI
	private Welcome_Panel pnl_welcome;
	private Classification_Panel pnl_classification;
	private RoomInfo_Panel pnl_roomInfo;
	private ReservationDate_Panel pnl_reservation;
	private CustomerInfo_Panel pnl_info;
	private Overview_Panel pnl_overview;
	private TAC_Panel pnl_tac;
	private TAC_Panel2 pnl_tac2;
	private Done_Panel pnl_done;
	
	// Declaration of reservation and database connection objects
	private Reservation reservation;
	
	//Declaration of gui variables
	private JLabel titleLabel;
	private JButton btn_minimize;
	private JPanel titleBarPanel;
	private JButton btn_close;
	
	//construction for main_frame
	public Main_Frame() {
			// Modification of the main frame window properties
		    setUndecorated(true);
		    setVisible(true);
		    DragListener drag = new DragListener();
		    addMouseListener(drag);
		    addMouseMotionListener(drag);
		    getContentPane().setBackground(new Color(255, 255, 255));
		    setTitle("Caldera Hotel");
		    setBounds(140, 10, 1090, 675);
		    Image iconImage = Toolkit.getDefaultToolkit().getImage("images/icon.png");
		    setIconImage(iconImage);

		    // Instantiate the reservation class to encapsulate data
		    reservation = new Reservation();

		    // Instantiate the GUI panels
		    pnl_welcome = new Welcome_Panel();
		    pnl_classification = new Classification_Panel();
		    pnl_roomInfo = new RoomInfo_Panel(reservation);
		    pnl_reservation = new ReservationDate_Panel(reservation);
		    pnl_overview = new Overview_Panel(reservation);
		    pnl_info = new CustomerInfo_Panel(reservation);
		    pnl_tac = new TAC_Panel();
		    pnl_tac2 = new TAC_Panel2();
		    pnl_done = new Done_Panel();
		    
		    
		    // Create a title bar panel
		    titleBarPanel = new JPanel();
		    titleBarPanel.setBackground(new Color(205, 147, 27));
		    titleBarPanel.setPreferredSize(new Dimension(getWidth(), 40));
		    getContentPane().add(titleBarPanel, BorderLayout.NORTH);
		    titleBarPanel.setLayout(null);
		    

		    // Add a label to the title bar panel for the title
		    titleLabel = new JLabel("Caldera Hotel");
		    titleLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
		    titleLabel.setBounds(33, 0, 139, 40);
		    titleLabel.setForeground(new Color(0, 0, 0));
		    titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		    titleBarPanel.add(titleLabel);
		    
		    //close button
			btn_close = new JButton("");
			btn_close.setBounds(1037, 0, 53, 40);
			titleBarPanel.add(btn_close);
			Image img_close = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
			Image img_close2 = img_close.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
			btn_close.setIcon(new ImageIcon(img_close2));
			btn_close.setOpaque(false);
			btn_close.setContentAreaFilled(false);
			btn_close.setBorderPainted(false);
			btn_close.setBorder(null);
			btn_close.setBounds(1037, 11, 53, 29);
			btn_close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int closeOp = JOptionPane.showConfirmDialog(null, "Do you want to close? Any changes will be unsaved",
			                "Confirmation", JOptionPane.YES_NO_OPTION);
			        if (closeOp == JOptionPane.YES_OPTION) {
			            System.exit(0);
			        }
				}
			});
			// DELETE ActionListener for Delete button
			pnl_overview.btn_delete.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        int delResOp = JOptionPane.showConfirmDialog(null, "Do you want to delete the current reservation?",
			                "Confirmation", JOptionPane.YES_NO_OPTION);
			        if (delResOp == JOptionPane.YES_OPTION) {
			            clearFields();
			            cObjl.show(cPanel, "1"); // Navigate to the first page
			        }
			    }
			});
			
			
			
		    // Create the card layout panel
		    cPanel = new JPanel();
		    cObjl = new CardLayout();
		    cPanel.setLayout(cObjl);
		    cPanel.setSize(930, 718);

		    // Adding panels to the CardLayout panel
		    cPanel.add(pnl_welcome, "1");
		    cPanel.add(pnl_classification, "2");
		    cPanel.add(pnl_roomInfo, "3");
		    cPanel.add(pnl_reservation, "4");
		    cPanel.add(pnl_info, "5");
		    cPanel.add(pnl_overview, "6");
		    cPanel.add(pnl_tac, "7");
		    cPanel.add(pnl_tac2, "8");
		    cPanel.add(pnl_done, "9");

		    // Setting up the navigation and adding the panel to the frame
		    cardLayoutNavigation();
		    getContentPane().add(cPanel, BorderLayout.CENTER);

	}
	
	/**
     * Creates an ActionListener for the buttons in the GUI.
     *
     * @param panelNumber number of panel to switch to pages
     * @param classification classification of the reservation
     * @param path the image path for the room info panel 
     */
	public ActionListener createButtonActionListener(int panelNumber, String classification, String path) {
	    return new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            cObjl.show(cPanel, "" + panelNumber);
	            if (classification != null) {
	            	// Set the classification and image path for the reservation and room info panel
	            	reservation.setClassification(classification);	 
	                pnl_roomInfo.classification= classification;
	                pnl_roomInfo.setImagePath(path);
	                
	                //try catch for selecting data to database
	                try {
	                    String query = "SELECT * FROM room WHERE Classification='" + classification + "' AND isOccupied=''";
	                    pnl_roomInfo.updateResultPages(DBConnection.selectDataFromDB(query));
	                } catch (Exception e) {
	                    ErrorHandler.handle("An error occurred: " + e.getMessage(), e);
	                }

	            }
	            
	            else if(panelNumber==9) {
	            	// Insert the reservation into the database and clear form data
	            	DBConnection.insertReservation(reservation);
	            	
	            	clearFields();
	            	pnl_roomInfo.clearEvent();
	            }
	        }
	    };
	}
	
	
    
	//method for navigation of button to different panels
	public void cardLayoutNavigation() {
		try {
			pnl_welcome.btnBookNow.addActionListener(createButtonActionListener(2, null, null));
			pnl_classification.btnStandard.addActionListener(createButtonActionListener(3, "Standard", "/rooms/standard.jpg"));
			pnl_classification.btnFamily.addActionListener(createButtonActionListener(3, "Family", "/rooms/family.png"));
			pnl_classification.btnDeluxe.addActionListener(createButtonActionListener(3, "Deluxe Suite", "/rooms/deluxe.png"));
			pnl_classification.btnSuperior.addActionListener(createButtonActionListener(3, "Superior Executive", "/rooms/superior.jpg"));
			pnl_roomInfo.reserveButton.addActionListener(createButtonActionListener(4, null, null));
			pnl_reservation.btnNext.addActionListener(createButtonActionListener(5, null, null));
			pnl_info.btn_next.addActionListener(createButtonActionListener(6, null, null));
			pnl_overview.btn_confirm.addActionListener(createButtonActionListener(7, null, null));
			pnl_tac.btn_next.addActionListener(createButtonActionListener(8, null, null));
			pnl_tac2.btn_next.addActionListener(createButtonActionListener(9, null, null));
			pnl_done.btn_home.addActionListener(createButtonActionListener(1, null,null));
			
			//BACK
			pnl_overview.btn_back.addActionListener(createButtonActionListener(5, null, null));
			pnl_info.btn_back.addActionListener(createButtonActionListener(4, null, null));
			pnl_reservation.btn_back.addActionListener(createButtonActionListener(3, null, null));
			pnl_roomInfo.btn_back.addActionListener(createButtonActionListener(2, null, null));
			
		}
		catch(Exception e) {
			ErrorHandler.handle("There are missing components, please contact administrator: " + e.getMessage(), e);
		}
	}
	public void clearFields() {
		//clears all field after reservation
    	ComponentUtils.clearAll(pnl_info);
    	ComponentUtils.clearAll(pnl_overview);
    	//clears all variables to original state
    	pnl_roomInfo.resultPages.clear();
    	pnl_roomInfo.currentPage=0;
    	pnl_roomInfo.currentIndex=0;
    	pnl_roomInfo.cardLayout.show(pnl_roomInfo.cardPanel, "0");
    	pnl_reservation.spr_timeIn.setValue("1:00 am");
    	pnl_reservation.spr_timeOut.setValue("1:00 am");
    	Calendar defaultDate = Calendar.getInstance();
    	pnl_reservation.dtch_dateIn.setDate(defaultDate.getTime());
    	pnl_reservation.dtch_dateOut.setDate(defaultDate.getTime());
	}
	
    
	//entry point of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					ErrorHandler.handle("There's a problem executing the problem, please try again: " + e.getMessage(),
							e);
				}
			}
		});

	}
}
