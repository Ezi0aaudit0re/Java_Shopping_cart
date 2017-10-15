/**
 * This is the driver of the program this is the file that is compiled
 * The driver uses the logic class to perform various functions in order 
 *  * Fill array with values 
 *  * Sort the array of items 
 *  * Shop with the money we have 
 *  * Print the end result 
 *  @author Aman Nagpal
 *  @version 1.0
 *
 **/



public class Driver{

    public static void main (String[] args) {
        boolean DEBUG = false;
        Logic logic = new Logic();
        
        // instantiate an empty array of objects 
        //logic.initializeItems();

        // fill the array with values
        if(DEBUG){
            logic.fillDummyArray(); 
        }
        else{
            logic.fillItemsArray();
        }

        // Sort the Items in assendiong order
        logic.sortItems();

        // assign HardCoded Prices
        logic.assignPrice();

        // go shopping
        logic.shopping();

        // print the information
        logic.print();

        System.out.println("The program has ended quiting the program");

    }


}
