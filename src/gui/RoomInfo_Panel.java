package gui;

//Importing user defined packages
import components.*;
import reservation.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

//Importing packages related to SQL
import java.sql.ResultSet;
import java.sql.SQLException;

//Importing required packages for GUI development
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

//Importing necessary packages for GUI design
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class rperesents the Room information window that displays the information of each room from every room classification.
 * This contains a constructor that initializes the size and the layout of the panel.
 */
public class RoomInfo_Panel extends JPanel{
	private static final long serialVersionUID = 3L; //serialization
	
    //Attributes RoomInfo_Panel
	public Button reserveButton;
	private Button nextButton;
	private Button previousButton;
	public String classification;
	private JLabel lbl_size;
	private JLabel lbl_price;
	private JLabel lbl_roomNo;
    private JPanel overallPanel;
    public JPanel cardPanel;
    public ArrayList<JPanel> resultPages;
    public int currentPage;
    public CardLayout cardLayout;
    public int currentIndex;
    
    private Reservation reservation;
    private JPanel currentResultPanel;
    public String roomNumber;
    
    public String class_ImgUrl; 
    public Image class_Img;
    private JSeparator separator;
    private JLabel lbl_ClassImg;
    public Button btn_back;
    private String imgPath;
    
    //Constructor for RoomInfo_Panel class. 
	public RoomInfo_Panel(Reservation reservation1) {
        //layout properties of room info panel
		setBounds(100, 100, 1100, 670);
		setLayout(null);
		
		reservation = reservation1;
		
		//panel for cardlayout
		overallPanel= new JPanel(null);
		cardLayout= new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        //properties of cardlayout
        cardPanel.setBounds(0, 0, 302, 397);
        cardPanel.setOpaque(false);
        cardPanel.setBackground(new Color(0, 0, 0, 0));
        overallPanel.setBounds(739, 30, 299, 400);
        resultPages = new ArrayList<>();
        currentPage = 0;
        
        //action listener if button back is clicked
        btn_back = new Button("Go Back");
        btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clearEvent();
        	}
        });
        btn_back.setBounds(739, 564, 101, 42);
        add(btn_back);
        
        overallPanel.setOpaque(false); // Set the panel to be transparent
        overallPanel.setBackground(new Color(0, 0, 0, 0)); // Set the background color to transparent
        overallPanel.add(cardPanel);
        add(overallPanel);
        
        //image properties for each classification
        imgPath="/rooms/standard.jpg"; //default path for image
        lbl_ClassImg = new JLabel("");
        ImageIcon icon = new ImageIcon(RoomInfo_Panel.class.getResource(imgPath));
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image);
        lbl_ClassImg.setIcon(newIcon);
        lbl_ClassImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_ClassImg.setBounds(61, 35, 600, 600);
        add(lbl_ClassImg);

        separator = new JSeparator();
        separator.setBounds(739, 467, 312, 22);
        add(separator);
        
		//button for next room info
		nextButton= new Button("Next");
		nextButton.setBounds(950, 564, 101, 42);
		add(nextButton);
		
		//button for previous room info
		previousButton = new Button("Previous");
		previousButton.setBounds(845, 564, 101, 42);
		add(previousButton);
		
		//button for reserve, store all necessary info to the reservation object
		reserveButton = new Button("RESERVE");
		reserveButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        currentResultPanel = resultPages.get(currentPage);
		        roomNumber = ((JLabel) currentResultPanel.getComponent(0)).getText();
		        int price = Integer.parseInt(((JLabel) currentResultPanel.getComponent(1)).getText().substring(4).replaceAll(",", ""));
		        reservation.setRoomNumber(Integer.parseInt(roomNumber));
		        reservation.setClassification(classification);
		        reservation.setPrice(price);
		        reservation.setRoomSize(Character.getNumericValue(((JLabel) currentResultPanel.getComponent(2)).getText().charAt(2)));
		    }
		});
		reserveButton.setBounds(739, 492, 309, 51);
		reserveButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		add(reserveButton);
        
		
		// action listener for previous
		previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousPage();
            }
        });
		
		//action listener for next button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextPage();
            }
        });
        
		//label for background image
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(0, 0, 1090, 635);
		Image img_sample = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		Image img_sample2 = img_sample.getScaledInstance(1090,640, Image.SCALE_DEFAULT);
		lbl_image.setIcon(new ImageIcon(img_sample2));
		add(lbl_image);
        
	}
    
	/**
     * This method is for updating the class using observers.
     *
     * @param resultSet - paramater for reservation observers.
     */
	public void updateResultPages(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            //Updating the jlabels when reservation object is changed using observers
        	JPanel resultPanel = new JPanel(null);
            lbl_roomNo = new JLabel(resultSet.getString("RoomNumber"));
    		lbl_roomNo.setBounds(45,100,214, 50); 
    		lbl_roomNo.setFont(new Font("Poppins", Font.BOLD, 50));
    		lbl_roomNo.setHorizontalAlignment(SwingConstants.CENTER);
    		resultPanel.add(lbl_roomNo);
            
            lbl_price = new JLabel("Php "+ new DecimalFormat("#,###").format(Integer.parseInt(resultSet.getString("Price"))));
    		lbl_price.setBounds(45,230,214, 50);
    		lbl_price.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_price.setFont(new Font("Poppins", Font.PLAIN, 25));
    		resultPanel.add(lbl_price);
            
    		lbl_size = new JLabel(resultSet.getString("Size")+" person");
            lbl_size.setBounds(45,350,214, 50); 
    		lbl_size.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_size.setFont(new Font("Poppins", Font.PLAIN, 25));
    		resultPanel.add(lbl_size);
    		
    		
    		resultPanel.setOpaque(false);
    		resultPanel.setBackground(new Color(0, 0, 0, 0));
    		resultPanel.setBounds(0, 0, 302, 500);
            
            cardPanel.add(resultPanel, String.valueOf(resultPages.size()));
            resultPages.add(resultPanel);
            
            currentIndex = resultPages.indexOf(resultPanel);
            
            }

        // Show first page
        if (!resultPages.isEmpty()) {
        	cardLayout.show(cardPanel, "0");
        }
    }
	
	//Method for showing next page for cardlayout
    private void showNextPage() {
        if (currentPage < resultPages.size() - 1) {
        	currentPage++;
        	cardLayout.show(cardPanel, String.valueOf(currentPage));
        }
        updateButtonStates();
    }
    
    //Method for showing previous page for cardlayout
    private void showPreviousPage() {
        if (currentPage > 0) {
        	currentPage--;
        	cardLayout.show(cardPanel, String.valueOf(currentPage));
        }
        updateButtonStates();
    }

  //Method for updating button state
    private void updateButtonStates() {
        previousButton.setEnabled(currentPage > 0);
        nextButton.setEnabled(currentPage < resultPages.size() - 1);
    }
	
  //Method for dynamically changing path of image
	public void setImagePath(String path) {
        this.imgPath = path;
        // update the JLabel icon with new image path
        lbl_ClassImg.setIcon(new ImageIcon(RoomInfo_Panel.class.getResource(imgPath)));
    }
	//clears all field in cardlayout
	public void clearEvent() {
		reservation.setClassification("");
		classification="";
		resultPages.clear();
		currentPage=0;
		currentIndex=0;
		cardLayout.show(cardPanel, "0");
		nextButton.setEnabled(true);
		previousButton.setEnabled(true);
    }
	
    
}

