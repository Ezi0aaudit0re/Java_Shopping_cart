import java.util.Scanner;


/**
 * This class consits of various helper methods 
 * Most of the methods are static so they can be called without instantiating the class
 * @author Aman Nagpal
 * @version 1.0
 */

public class Helper{

    /**
     * This function checks if the user enters Sentinal value -1 any time 
     * This is the equals method for this class
     * Quits the program if the sentical value is entered
     * @param user_in - the string of input entered by the user
     */
    public static void equalsQuit(String user_in){
        if(user_in.equals("-1")){
            System.exit(0); 
        } 
    }


    /**
     * This function checks if the priority entered by user is in range(1,7)
     * @param priority - The priority entered by the user
     * @return true/false
     */
    public static boolean checkPriority(int priority){
        if(priority < 1 || priority > 7){
            // return false if the priority is not in range(1, 7)
            System.out.println("Please enter priority between 1 and 7");
            return false; 
        
        } 
        return true;
    
    }

    /**
     * This function gets the name from the user 
     * @return name 
     */
    public static String getName(){
        Scanner sf = new Scanner(System.in);
        System.out.print("Please enter the NAME of the product: ");
        String name = sf.nextLine();
        return name;
    }

    public static int getPriority(){
        Scanner sf = new Scanner(System.in);
        System.out.print("Please enter the PRIORITY: ");     
        int priority = sf.nextInt();
        return priority;
    }

    /**
     * This function checks if the name already exists in the Items array
     * @param name - String name to check
     * @param items - Items array
     * @param itter - itterate till this value 
     * @return true/false
     */
    public static boolean checkName(String name, Item[] items, int itter){
        
        // check if value entered by the user is same as any the PREVIOUS values entered by the user
        // therefore itter2 < itter
         for(int itter2 = 0; itter2 < itter; itter2++){

            if(items[itter2].equals(name)){
                System.out.println("This item is already in the list please add another item");
                return false;
            }
          }
         return true;
    }


    /**
     * This function checks if user entered value incorrectly thrice
     */
    public static void checkCounter(int counter){
        if(counter == 3){
            System.out.println("You entered incorrect value thrice EXITING the program");
            System.exit(1); 
        
        } 
    
    }

    /**
     * This function returns the items that were not puchased
     * @param items - The array of all the items 
     * @param itter - This is a value which is used as the differentiator
     *                for which items have been purchased and which items haven't
     */
    public static Item[] getLeftItems(Item[] items, int itter){
        Item[] leftItems = new Item[7];
        // loop through the remaining items in the list
        for(int i = 0; i < leftItems.length; i++){
            // add to the leftItems Array
            if (i + itter < 7){
                // i + itter to get the corresponding value in items arraay
                leftItems[i] = items[i + itter];
            }
            else{
                // initialize empy spaces as default Items 
                leftItems[i] = new Item(); 
            }
        } 

        return leftItems;
    
    
    
    }



}
