package database;

import java.sql.*;
import java.text.SimpleDateFormat;

import functions.ErrorHandler;
import reservation.*;

public class DBConnection {

    private Connection connection;
    
    public DBConnection() {
        
    }
    
    
    public void close() throws SQLException {
        connection.close();
    }
    public static ResultSet selectDataFromDB(String query) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caldera_hotel_db", "root", "");
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            ErrorHandler.handle("An error occurred: " + e.getMessage(), e);
            return null;
        }
    }
    public static void insertReservation(Reservation reservation) {
    	try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caldera_hotel_db", "root", "")){
    		String query = "INSERT INTO customer (FullName, Age, Gender, ContactNo, Address, ValidId, PaymentType) VALUES (?, ?, ?, ?, ?,?,?)";

        	// create a PreparedStatement for inserting data into the customer table
        	PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        	pstmt.setString(1, reservation.getFirstName() + " "+reservation.getMiddleName()+" "+reservation.getLastName());
            pstmt.setInt(2, reservation.getAge());
            pstmt.setString(3, reservation.getGender());
            pstmt.setString(4, reservation.getContactNo());
            pstmt.setString(5, reservation.getAddress());
            pstmt.setString(6, reservation.getValidID());
            pstmt.setString(7, reservation.getPaymentType().toString());

        	// execute the query and get the auto-generated customerID value
        	int affectedRows = pstmt.executeUpdate();
        	if (affectedRows == 0) {
        	    System.out.println("Creating customer failed, no rows affected");
        	}
        	try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        	    if (generatedKeys.next()) {
        	        int customerID = generatedKeys.getInt(1);
        	        
        	        String insertReservationQuery = "INSERT INTO reservation (customerID, DateIn, DateOut, TimeIn, TimeOut, RoomAccommodated, NoOfPeople) VALUES (?,?,?,?,?,?,?)";
        	        PreparedStatement stmt = conn.prepareStatement(insertReservationQuery);
        	        stmt.setInt(1, customerID); 
        	        stmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(reservation.getDateIn()));  
        	        stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(reservation.getDateOut()));
        	        stmt.setString(4, reservation.getTimeIn().toString());
        	        stmt.setString(5, reservation.getTimeOut().toString());
        	        stmt.setInt(6, reservation.getRoomNumber()); 
        	        stmt.setInt(7, reservation.getNoOfPeople()); 
        	        
        	        int queryRows = stmt.executeUpdate();
        	        
        	        String occupiedSql = "UPDATE room SET isOccupied='Yes' WHERE RoomNumber='"+reservation.getRoomNumber()+"'";
        	        PreparedStatement occupiedStmt = conn.prepareStatement(occupiedSql);
        	        
        	        occupiedStmt.executeUpdate();
        	        
        	        
        	        if (queryRows == 0) {
        	            System.out.println("STMT failed2");
        	        }

        	        
        	    } 
        	    else {
        	    	System.out.println("STMT failed1");
        	    }
        	}
        	catch(Exception e) {
        		ErrorHandler.handle("SQL Statement failed: " + e.getMessage(), e);
        	}
    	}
    	catch(Exception e){
    		ErrorHandler.handle("SQL Statement failed: " + e.getMessage(), e);
    	}
    }
}

