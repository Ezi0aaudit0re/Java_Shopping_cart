import java.util.Scanner;


/**
 * This class consits of various helper methods 
 * Most of the methods are static so they can be called without instantiating the class
 *
 */

public class Helper{

    /**
     * This function checks if the user enters Sentinal value -1 any time 
     * Quits the program if the sentical value is entered
     * @param user_in - the string of input entered by the user
     */
    public static void equals(String user_in){
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
        if(priority < 1 && priority > 7){
            // return false if the priority is not in range(1, 7)
            return false; 
        
        } 
        return true;
    
    }

    public static String getName(){
        Scanner sf = new Scanner(System.in);
        System.out.print("Please enter the name of the product");
        String name = sf.nextLine();
        return name;
    }

    public static int getPriority(){
        Scanner sf = new Scanner(System.in);
        System.out.print("Please enter the priority: ");     
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
        
            // Perform Validations and enter enter into the array of items
         for(int itter2 = 0; itter2 < itter; itter2++){

            if(items[itter2].getName().equals(name)){
                System.out.println("This item is already in the list please add another item");
                return false;
            }
            else{
                 System.out.println("correct name");
            }
                
          }
         return true;
    }


    public static void checkCounter(int counter){
        if(counter == 3){
            System.out.println("You entered incorrect value thrice EXITING the program");
            System.exit(1); 
        
        } 
    
    }



}
