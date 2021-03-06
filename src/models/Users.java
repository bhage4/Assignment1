package models;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int postalCode;
	private String email;
	private int phoneNumber;
	private Date birthday;
	private String userType; //Turn this into enum
	private String status; //Enum also?
	private int numOfVisits;
	
	public boolean isValidEmailAddress() {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);
        if (!matcher.matches()) {
            return false;
        }
        return true;
	}
	
	public boolean validateZip(){
		int zipLength = String.valueOf(this.postalCode).length();
		if(zipLength > 9 || zipLength < 5){
			return false;
		}
		return true;
	}
	
	public Users() {
		super();
	}
	
	public Users(int id){
		this.id = id;
	}

	public Users(String userName, String password){
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Users(int id, String userName, String password, String firstName,
			String lastName, String address, String city, String state,
			int postalCode, String email, int phoneNumber, Date birthday,
			String userType, String status, int numOfVisits) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.userType = userType;
		this.status = status;
		this.numOfVisits = numOfVisits;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	//Validation occurs automatically due to phone number being an int
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumOfVisits() {
		return numOfVisits;
	}
	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}
}
