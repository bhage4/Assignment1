package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;

public class Users {

	private String userName;
	private String password;

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
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public void registerUser(String propFilePath) {

		Properties p = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(this.getUserName(), this.getPassword());
			p.store(new FileOutputStream(propFilePath), null);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// validateUser
	public boolean validateUser(String propFilePath) {

		Properties p = new Properties();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propFilePath);

			p.load(fis);

			// Check whether the username exists or not
			if(!p.containsKey(userName)) {
				return false;
			} else { // Check whether the password matches or not
				String pword = p.getProperty(userName);  
				if(!pword.equals(password)) {
					return false;
				} else {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//Checks unique username
	public boolean checkUniqueUser(String propFilePath){
		
		Properties p = new Properties();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propFilePath);

			p.load(fis);

			// Check whether the username exists or not
			if(p.containsKey(this.getUserName())) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
// removeUser

}
