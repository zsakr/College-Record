/**
 * Application program for the Directory class.
 * This class simualtes a college record system
 * @author Ziad Sakr
 * @version 1.0 29/4/2018
 */
public class Directory{
	// attributes
	private String organizationName;
	private static final int MAX_Number = 100; // max number of records to store
	private Entry[] entry = new Entry[MAX_Number];
	private int totalEntries = 0;

   /**
   * creates a new Directory
   * @param organizationName 
   */
	public Directory(String organizationName){
		this.organizationName = organizationName;
		int totalEntries = 0;
	}
	/**
	* Find the Index for the new record newEntry 
	* @param newEntry the new Entry object
	* @return i if true 
	* @return -1 otherwise
	*/
	private int findEntryIndex(Entry newEntry){
		for(int i = 0; i < totalEntries; i++){
			if(entry[i].equals(newEntry))
				return i;
		}
		return -1;
	}
	/**
	* Adds a new record newEntry after checking that ther is no other
	* record with the same number and there is enough space let
	* @param newEntry the new Entry object
	*/
	public boolean add(Entry newEntry){
		int search = findEntryIndex(newEntry);

		if(search ==-1 && totalEntries < MAX_Number){
			entry[totalEntries] = newEntry;
			totalEntries++;
			return true;
		} else {
			return false;
		}

	}
	/**
	* call the findEntryIndex to check for the index first
	* @return false if nothing found
	* @return true otherwise
	* @param lastName
	*/
	public boolean remove(String lastName){
		int temp = findEntryIndex(search(lastName));
        if(temp ==-1){

            return false;
        }
        totalEntries--;
		for(int i = temp; i < totalEntries; i++){
			entry[i] = entry[i+1];

        }
    return true;
   }
   /**
   * display the number of the total Entries
   * @return totalEntries
   */
	public int getTotalEntries(){
		System.out.println("There is a total of " + totalEntries);
		return totalEntries;
	}
	/**
	* search for the lastName
	* even if the search in lower case avoid that
	* @return entry[i] if true
	* @return null otherwise
	*/
	public Entry search(String lastName){
		for(int i =0; i < totalEntries; i++){
			if(entry[i].getLastName().equalsIgnoreCase(lastName)){
				return entry[i];
			}}
			return null;
              
	}
	/**
	* Uses the selection sort to sort the array by 
	* the last name
	*/
	public void sort(){

		for(int i =0; i < totalEntries; i++){
			int minIdex = i;
			for(int j = i; j < totalEntries; j++){
				if(entry[j].getLastName().compareTo(entry[minIdex].getLastName()) < 0){
					minIdex = j;
				}
				
			}
			Entry minEntry = entry[minIdex]; // minindex == pos of char
			entry [minIdex] = entry[i];    // remember the swap with hands that the prof did
 			entry[i] = minEntry;

		}
              
	}
	/**
	* Create a new variable called fullDirectory to create a new line 
	* called the toString function to Display all the information
	* @return fullDirectory 
	*/
	public String toString(){
		String fullDirectory = ""; 
		for (int i =0; i < totalEntries; i++){
			 fullDirectory+=entry[i].toString();
			 fullDirectory+="\n"; 			
		}
		return fullDirectory;

		
	}
}

