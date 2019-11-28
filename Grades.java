/**
 * Application program for the Grades entry class.
 * This class simualtes a college record system
 * @author Ziad Sakr
 * @version 1.0 4/29/2018
 */

// create a subclass StudentEntry that extends the superclass
public class Grades extends Entry{
	//attributes
	private double stExam;
	private double ndExam;
	private double rdExam;
	private double total;

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

	public Grades(String firstName, String lastName, String email_address, String phoneNumber, String department, double stExam, double ndExam, double rdExam, double total ){
		super(firstName, lastName, email_address, phoneNumber, department);
		this.stExam = stExam;
		this.ndExam = ndExam;
		this.rdExam = rdExam;
		this.total = total;
	}
    /**
	* method that display using the super method to call the toString from superclass
	* the information for the Student
	* @return information
	*/
	public String toString(){
		String temp = super.toString();
        return "--------grades--------\n" + temp+ "\nFirst Exam: "+ stExam + "\nSeond Exam: "+ ndExam + "\n Third Exam : " + rdExam + "\n Total : "+ total ;
	}
}