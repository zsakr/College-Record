/**
 * Application program for the StaffEntry class.
 * This class simualtes a college record system
 * @author Ziad Sakr
 * @version 1.0 4/29/2018
 */

// create a subclass StaffEntry that extends the superclass
public class StaffEntry extends Entry{
	// attributes
	private String position;


      /**
      *create a constructor that has five parameters
      * use the super method to call them from the superclass
      * @param firstName
      * @param lastName
      * @param email_address
      * @param phoneNumber
      * @param department
      * @param position
      */
	public StaffEntry(String firstName, String lastName, String email_address, String phoneNumber, String department, String position){
		super(firstName, lastName, email_address, phoneNumber, department);
		this.position = position;
	}
	/**
	* method that display using the super method to call the toString from superclass
	* the information for the staff
	* @return information
	*/
	public String toString(){
		String temp = super.toString();
        return "--------Staff--------\n" + temp+ "\nPosition: "+ position + "\n";
	}
}