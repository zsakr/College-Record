/**
 * Application program for the StudentEntry class.
 * This class simualtes a college record system
 * @author Ziad Sakr
 * @version 1.0 4/29/2018
 */

// create a subclass StudentEntry that extends the superclass
public class StudentEntry extends Entry{
	//attributes
	private int graduationYear;

      /**
      *create a constructor that has five parameters
      * use the super method to call them from the superclass
      * @param firstName
      * @param lastName
      * @param email_address
      * @param phoneNumber
      * @param department
      * @param graduationYear
      */
	public StudentEntry(String firstName, String lastName, String email_address, String phoneNumber, String department, int graduationYear){
		super(firstName, lastName, email_address, phoneNumber, department);
		this.graduationYear = graduationYear;
	}
	/**
	* method that display using the super method to call the toString from superclass
	* the information for the Student
	* @return information
	*/
	public String toString(){
		String temp = super.toString();
        return "--------Student--------\n" + temp+ "\nGraduation: "+ graduationYear + "\n";
	}
}