/**
 * This is the driver of the program this is the file that is compiled
 * The driver uses the logic class to perform various functions in order 
 *  * Fill array with values 
 *  * Sort the array of items 
 *  * Shop with the money we have 
 *  * Print the end result 
 *
 **/



public class Driver{
    public static void main (String[] args) {
        Logic logic = new Logic();
        
        // instantiate an empty array of objects 
        logic.initializeItems();

        // fill the array with values
        logic.fillItemsArray();
    }


}
