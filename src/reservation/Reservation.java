package reservation;

import java.util.ArrayList;
import java.util.List;



public class Reservation {
	private String classification;
	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNo;
	private String address;
	
	
	private Object paymentType;
	private int age;
	private String gender;
	private int Price;
	
	private int RoomNumber;
	private java.util.Date DateIn;
	private java.util.Date DateOut;
	private Object TimeIn;
	private Object TimeOut;
	private int noOfPeople;
	private String validID;
	private int roomSize;
	
	private List<ReservationObserver> observers = new ArrayList<ReservationObserver>();
	public Reservation() {
		classification="";
		firstName="";
		middleName="";
		lastName="";
		contactNo="";
		address="";
		
		
		paymentType="";
		age=0;
		gender=null;
		Price=0;
		
		RoomNumber=0;
		DateIn=null;
		DateOut=null;
		TimeIn=null;
		TimeOut=null;
		age=0;
		noOfPeople=0;
		validID="";
		roomSize=0;
	}
	//Observers, don't change
	public void addObserver(ReservationObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(ReservationObserver observer) {
        observers.remove(observer);
    }
    
    private void notifyObservers() {
        for (ReservationObserver observer : observers) {
            observer.updateReservation(this);
        }
    }
	//Observers, don't change


	// <------------WORK HERE-------------->

	//Getters
	public int getRoomNumber() {
		return RoomNumber;
	}

	public int getPrice() {
		return Price;
	}

	public java.util.Date getDateIn() {
		return DateIn;
	}

	public java.util.Date getDateOut() {
		return DateOut;
	}
	
	public int getNoOfPeople() {
		return noOfPeople;
	}
	
	public String getContactNo() {
		
		return contactNo;
	}

	public String getAddress() {
		return address;
	}
	
	public String getValidID() {
		return validID;
	}

	public Object getPaymentType() {
		return paymentType;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getClassification() {
		return classification;
	}

	public Object getTimeIn() {
		return TimeIn;
	}

	public Object getTimeOut() {
		return TimeOut;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getRoomSize() {
		return roomSize;
	}

	//<---------SETTERS----------->

	//Setter method for roomNumber
	//Sets the room number of the reservation to the value passed as an argument and notifies observers of the change.
	public void setRoomNumber(int roomNumber2) {
        this.RoomNumber = roomNumber2;
        notifyObservers();
	}
	
	//Setter method for price
	//Sets the price of the reservation to the value passed as an argument and notifies observers of the change.
	public void setPrice(int price2) {
		this.Price = price2;
		notifyObservers();
	}

	//Setter method for dateIn
	//Sets the check-in date of the reservation to the value passed as an argument and notifies observers of the change.
	public void setDateIn(java.util.Date date) {
		this.DateIn = date;
		notifyObservers();
	}

	//Setter method for dateOut
	//Sets the check-out date of the reservation to the value passed as an argument and notifies observers of the change.
	public void setDateOut(java.util.Date date) {
		this.DateOut = date;
		notifyObservers();
	}
	//Setter method for noOfPeople
	//Sets the number of people for the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the number of people is less than the room capacity.
	public void setNoOfPeople(int noOfPeople) throws IllegalArgumentException{

		this.noOfPeople = noOfPeople;
		notifyObservers();
	}

	//Setter method for contactNo
	//Sets the contact number of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the contact number is not 11 digits.
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
		notifyObservers();
	}
	
	//Setter method for address
	//Sets the address of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the address is null or longer than 50 characters.
	public void setAddress(String address) {
		this.address = address;
		notifyObservers();
	}
	
	//Setter method for validID
	//Sets the valid ID of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the valid ID is null.
	public void setValidID(String validID) {
		this.validID = validID;
		notifyObservers();
	}

	//Setter method for paymentType
	//Sets the payment type of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the payment type is null.
	public void setPaymentType(Object paymentType) {
		this.paymentType = paymentType;
		notifyObservers();
	}
	//Setter method for age
	//Sets the age of the guest to the value passed as an argument and notifies observers of the change.
	public void setAge(int age) {
		this.age = age;
		notifyObservers();
	}
	//Setter method for gender
	//Sets the gender of the guest to the value passed as an argument and notifies observers of the change.
	public void setGender(String gender) {
		this.gender = gender;
		notifyObservers();
	}

	//Setter method for classification
	//Sets the classificatione of the reservation to the value passed as an argument and notifies observers of the change. 
	public void setClassification(String classification) {
		this.classification = classification;
		notifyObservers();
	}
	//Setter method for timeIn
	//Sets the time inof the reservation to the value passed as an argument and notifies observers of the change. 
	public void setTimeIn(Object object) {
		TimeIn = object;
	}

	//Setter method for timeOut
	//Sets the time out of the reservation to the value passed as an argument and notifies observers of the change. 
	public void setTimeOut(Object timeOut) {
		TimeOut = timeOut;
	}

	//Setter method for firstName
	//Sets the first name of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the first name is null or the characters length is above 50.
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	//Setter method for middleName
	//Sets the middle name of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the middle name is null or the characters length is above 20.
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	//Setter method for lastName
	//Sets the last name of the reservation to the value passed as an argument and notifies observers of the change. 
	//Throws an exception if the last name is null or the characters length is above 20.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//Setter method for roomSize
	//Sets the room size of the reservation to the value passed as an argument and notifies observers of the change. 
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
		notifyObservers();
	}
	
		
		
	
	public boolean emptyFieldChecker() {
		if(firstName=="" || lastName=="" || middleName=="" || contactNo=="" || address=="" || validID=="" || paymentType=="") {
			return false;
		}
		else {
			return true;
		}
	}
	
	//method for reseting reservation class
	public void reset() {
		classification=null;
		firstName="";
		middleName="";
		lastName="";
		contactNo="";
		address="";
		
		paymentType="";
		age=0;
		gender=null;
		Price=0;
		
		RoomNumber=0;
		DateIn=null;
		DateOut=null;
		TimeIn=null;
		TimeOut=null;
		noOfPeople=0;
		validID="";
		roomSize=0;
	}
}
