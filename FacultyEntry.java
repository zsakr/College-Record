/**
 * Application program for the FacultyEntry class.
 * This class simualtes a college record system
 * @author Ziad Sakr
 * @version 1.0 4/29/2018
 */

// create a subclass FacultyEntry that extends the superclass
public class FacultyEntry extends Entry{
	private String rank;

     /**
      *create a constructor that has five parameters
      * use the super method to call them from the superclass
      * @param firstName
      * @param lastName
      * @param email_address
      * @param phoneNumber
      * @param department
      * @param rank
      */
	public FacultyEntry(String firstName, String lastName, String email_address, String phoneNumber, String department, String rank){
		super(firstName, lastName, email_address, phoneNumber, department);
		this.rank = rank;
	}
	/**
	* method that display using the super method to call the toString from superclass
	* the information for the faculty
	* @return information
	*/
	public String toString(){
		String temp = super.toString();
        return "--------Faculty--------\n" + temp + "\nRank: "+ rank +"\n";
}}