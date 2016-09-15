
/*
 * Title:  Remove Duplicate Integers from an Array
 * 
 * Revision:  1.0
 * Author:  Nick Okerberg
 * 
 * Description:  This program will ask the user to enter the number of elements
 * in the array.  Then the user will enter the integers one at a time for the 
 * Integer array.  The program will then take the Integer array and remove any
 * duplicate integer values.  It will print the new array elements back to the
 * user with such duplicates removed.  
 * 
 * Instructions:  Execute from the command line using the following steps:
 * 		1) Ensure that JRE 1.6 or later is running or that the Java compiler
 * 			is running checks against JRE 1.6 or later.  
 * 		2) Compile the program using the command line syntax: 
 * 			> set path=%path%;C:\Program Files\Java\jdk1.8.0_102\bin
 * 			> javac RemoveDuplicatesFromIntArray.java
 *  		3) Run the program using the syntax from the command line:
 *  			> java RemoveDuplicatesFromIntArray
 * This has been tested as working on Windows 10 via the command prompt.  
 * 
 * Revision History:
 * Date			Ver		Author			Description
 * 2016/09/14	1.0		Nick Okerberg	Initial Release, created on Windows 10 with jdk1.8.0_102.
 */


// Define imports.
import java.io.IOException;
import java.util.Scanner;

public class RemoveDuplicatesFromIntArray {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanIn = new Scanner(System.in);  // Scanner for accepting user input.
		
		/*
		 * Get the number of elements that is in the Integer array, from the user. 
		 */
		System.out.println("Enter the number of elements for the Integer array: ");
		int numberElements = Integer.parseInt(scanIn.next());
		
		// Initialize the Array with a size of what the user wanted.
		int[] userArray = new int[numberElements];
		
		/*
		 * Next, have the user enter the elements of the Integer array one at a time.
		 */
		System.out.println("Enter the " + numberElements + " element(s) for the Integer array: ");
		for (int i = 0; i < numberElements; i++){
			System.out.println("   Enter element #" + (i+1) + ": ");
			userArray[i] = Integer.parseInt(scanIn.next());
		}
		
		/*
		 * Initialize the new array that will have duplicates removed.
		 * Call the method that is used to remove the duplicates and assign the
		 * result to the new array. 
		 */
		int[] newArray;
		newArray = removeDuplicate(userArray);
		
		/*
		 * Print the new array, with duplicates removed, to the user.
		 */
		System.out.println("\nThe array with duplicates removed is: \n");
		for (int i = 0; i < newArray.length; i++){
			System.out.print(newArray[i] + " ");
		}
		
		scanIn.close(); // Close the scanner object.
				
	}  // End main method.
	
	
	


	/*
	 * Function that takes in an Integer array and removes any duplicate elements.
	 * It then returns back an Integer array with duplicate elements removed.
	 * 
	 * The way that it works is to first make a duplicate copy of the input array.
	 * Then it compares the input array to the duplicate array one element at a time,
	 * while recording the number of unique elements. The function initializes a new
	 * results array with a length of such unique elements.  Then the function again
	 * compares the input array elements to the duplicate array elements while 
	 * adding the unique element to the new result array.  The result array is then 
	 * returned back.  
	 */
	public static int[] removeDuplicate(int[] arrayIn) {

		/*
		 * Create a duplicate array of the input array.
		 */
		int[] arrayDup = new int[arrayIn.length];
		System.arraycopy(arrayIn, 0, arrayDup, 0, arrayIn.length); 
		
		/*
		 * Initialize function variables.
		 */
		boolean unique = true;   // Initialize the boolean for whether or not an element is unique.
		int uniqueElements = 0;  // Number of unique elements in the input array.
		
		/*
		 * Start comparing the input array to the duplicate array looking for unique elements.
		 */
		for (int i = 0; i < arrayIn.length; i++) { // Iterate through the input array.

			unique = true;   // Set the unique boolean to true for each iteration of the input array.  
	          
			for (int j = 0; j < arrayDup.length; j++) { // Iterate through the duplicate array.

				if ( (arrayIn[i] == arrayDup[j]) && (i != j) ) { // Duplicate element detected.
					unique = false;   // Found an element in the input array that is not unique.
				}
			}

			// If the unique boolean is still true, increment the uniqueElements count.
	        	if (unique){ 
	        		uniqueElements++;
	        	}
	     	}  
		
		// For debugging:
		// System.out.println("Number of unique elements found: " + uniqueElements);

		/*
		 * At this point, we know how many unique elements there are in the input Array.
		 * Now initialize a new Integer array with a length of the number of unique elements. 
		 * This new Integer array will eventually be populated with the unique elements and
		 * returned back as the result array.  
		 */
	     	int[] arrayResult = new int[uniqueElements];
	     	int n = 0;  // The new result array starting index value.

	     	/*
	      	* Iterate through the input array, adding the unique elements to it.  
	      	*/
	     	for (int i = 0; i < arrayIn.length; i++) { // Iterate through the input array.

	    	 	unique = true;   // Set the unique boolean to true for each iteration of the input array.  
		          
	    	 	for (int j = 0; j < arrayDup.length; j++) { // Iterate through the duplicate array.

	    		 	if ( (arrayIn[i] == arrayDup[j]) && (i != j) ) { // Duplicate element detected.
	    				unique = false;   // Found an element in the input array that is not unique.
	    		 	}
	    	 	}
	    	 
	    	 	// If the unique boolean is still true, assign the element to the result array.
	    	 	if (unique){ 
	    		 	arrayResult[n] = arrayIn[i];
	    		 	n++;  // Increment the result array index number.
	    	 	}
	     	}
		return arrayResult; // Return the result array back to the user.
	} // End method.

} // End class.
