/**
* This class simualtes a college record system
* Application program for the Entry class
* @author Ziad Sakr
* @version 1.0 4/29/2018
*/

// create a new superclass name Entry
public class Entry{
	//attributes
	protected String firstName;
	protected String lastName;
	protected String email_address;
	protected String phoneNumber;
	protected String department;

     /**
      *create a constructor that has five parameters
      * @param firstName
      * @param lastName
      * @param email_address
      * @param phoneNumber
      * @param department
      */
	public Entry(String firstName, String lastName, String email_address, String phoneNumber, String department){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email_address = email_address;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}

	// getters and other methods 

	/**
	*getters that return the last 
	*@return last_name
	*/
	public String getLastName(){
		return lastName;
	}
	/**
	* @override
	*creatr a method that compare and see if it equals
	* @return true if equlas
	* @return false otherwise
	*/

	public boolean equalsIgnoreCase(Object o){
		if(this == o)return true;
		if (o == null)return false;
		Entry entry = (Entry) o;
	   return this.getLastName() == entry.getLastName();
	}
	/**
	* method that display 
	* the information 
	*/
	public String toString(){

		return ("Name: " + firstName + " " + lastName +"\nEmail: "+email_address+"\nPhone: "+ phoneNumber +"\nDepartment: "+ department);
	}

}