// imports 
import java.util.Scanner;


/**
 * This class has the main logic of the program 
 * This class has variaous instance variables 
 *  * double moneyOwned - Default 59.00 
 *  * Items[] items - The array of len 7 of items 
 *  * Items[] purchasedItems - The array of len 7 of purchased items 
 *  * Items[] leftItems - THe array of len 7 of items left after all money spent 
 * NOTE - I made a design desion that the number of elements purchased or left 
 * can in no way exceed total number of items - 7
 * @author Aman Nagpal
 * @version 1.0
 **/
public class Logic{
    private final int NUM_ITEMS = 7;
    private final boolean DEBUG = false; // for testing
    private double moneyOwn = 59.00;
    private Item[] items = new Item[NUM_ITEMS];
    private Item[] purchasedItems = new Item[NUM_ITEMS];
    private Item[] leftItems = new Item[NUM_ITEMS];

    // Getters 
    public double getMoneyOwn(){
        return this.moneyOwn; 
    }
    
    public Item[] getItems(){
        return this.items; 
    }

    public Item[] getPurchasedItems(){
        return this.purchasedItems; 
    }

    public Item[] getLeftItems(){
        return this.leftItems; 
    }

    // Setter
    public void setMoneyOwn(double amount){
        this.moneyOwn = amount; 
    }

    /**
     * We use this function to set the value of a particular item 
     * @param item - The item of Item Instance
     * @param location - the location in the items array to update 
     */
    public void setItems(Item itm, int location){
        this.items[location] = itm;
    }

    /**
     * We use this function to set the value of a particular itemPurchased 
     * @param item - The item of Item Instance
     * @param location - the location in the itemsPurchased array to update 
     */
    public void setItemsPurchased(Item itm, int location){
        this.purchasedItems[location] = itm;
    }

    
    /**
     * We use this function to set the value of a particular item 
     * @param item - The item of Item Instance
     * @param location - the location in the items left array to update 
     */
    public void setItemsLeft(Item itm, int location){
        this.leftItems[location] = itm;
    }
    /**
     * This function initializes the array items with empty objects
     **/
    public void initializeItems(){
        for(int itter = 0; itter < this.NUM_ITEMS; itter++){
            items[itter] = new Item(); 
        } 
    }

    /**
     * Fill with dummy values 
     */
    public boolean fillDummyArray(){
        items[0] = new Item("Apple", 3); 
        items[1] = new Item("Oranges", 1); 
        items[2] = new Item("Beef", 5); 
        items[3] = new Item("Fish", 5); 
        items[4] = new Item("Chicken", 6); 
        items[5] = new Item("Herbs", 4); 
        items[6] = new Item("Spices", 7); 
        return true; 
    
    }
        
    /**
     * This function asks the user for name and priority 
     * This has to be in the format <product name>, <priority>
     * Perform validations and prompts the user for correct value of the field entered wrong
     * @return true when task is completed
     */
    public boolean fillItemsArray(){

        // Create a scanner object for user input
        Scanner sf = new Scanner(System.in);
        for (int itter = 0; itter < this.NUM_ITEMS; itter++){
            
            // Get the name and priority of the item 
            // Remove all trailing white spaces    
            System.out.println("Please enter the name and priority of the item seprated by a ',': ");
            String user_in = sf.nextLine();
            String temp_name = user_in.split(",")[0].replaceAll("\\s", "");
            int temp_priority = Integer.parseInt(user_in.split(",")[1].replaceAll("\\s", ""));

            
            int counter = 0;
            
            
            // check if the name is unique else ask for name again
            do{
                if(!Helper.checkName(temp_name, items, itter)){
                    counter++;
                    Helper.checkCounter(counter);
                    temp_name = Helper.getName(); 
                    Helper.equalsQuit(temp_name);
                }
                else{
                    break; 
                }
            }while(true);

            // reset the counter to 0
            counter = 0;

            // check if the priority is between 1 and 7
            do{
                if(!Helper.checkPriority(temp_priority)){
                   counter++;
                   Helper.checkCounter(counter);
                   temp_priority = Helper.getPriority();
                }
                else{
                     break; 
                }
            }while(true);
            
            // if all the validations passed add to the array
            this.items[itter] = new Item(temp_name, temp_priority);
            
        } 


    
        return true; 
    }


    /**
     * This function checks if all the values in the array are filled 
     *      Does this by checking if the name at all the locations is not none
     *      Only does this step in Debug mode
     * if yes it sorts using bubble sort 
     * updates the items array with the sorted values 
     */
    public void sortItems(){
    
        for(int itter = 0; itter < this.NUM_ITEMS; itter++){
            if(this.items[itter].equals("None") && DEBUG){
                System.out.println("The items array is not fully filled");
                System.exit(3);
            } 
        
        } 

        // run a loop to sort thorugh bubble sort
        while(true){
            int counter = 0;
            for(int itter = 0; itter < (this.NUM_ITEMS - 1); itter++){
                // check if priority of next item is greater if yes then swap the two values
                if(items[itter].getPriority() > items[itter + 1].getPriority()){
                    Item temp = items[itter]; 
                    items[itter] = items[itter + 1];
                    items[itter + 1] = temp;
                    counter++;
                } 
        
            }
            // break out of the while loop if no changes have been made
            if(counter == 0){
                break; 
            }
        }
    
    }
    

    /**
     * This function adds items to the purchasesItems Array based on the amount of money
     * Else saves the items in the leftItens array
     * @param moneyLeft - The amount of money left default 59.00
     */
    public void shopping(){
        // loop through the items 
        for (int itter = 0; itter < this.NUM_ITEMS; itter++){
            if(this.moneyOwn > this.items[itter].getPrice()){
                this.purchasedItems[itter] = this.items[itter];
                this.moneyOwn = this.moneyOwn - this.items[itter].getPrice(); 
            } 
            else{
                this.purchasedItems[itter] = new Item();
                double money = this.moneyOwn - this.items[itter].getPrice(); 
                if(money > 0){
                    this.moneyOwn = money; 
                }

                // We fukk the leftItems array 
                // we send the value of itter-- because loop adds +1 to itter before checking the condition
                // we need to account for this 
                this.leftItems = Helper.getLeftItems(this.items, (itter -1)  );
            }
        
        
        }

    
    }

    /**
     * This function sets the price for each item in the array 
     * Total price of the items is greater than 100
     */
    public void assignPrice(){
        this.items[0].setPrice(10.45); 
        this.items[1].setPrice(20.24); 
        this.items[2].setPrice(5.45); 
        this.items[3].setPrice(10.44); 
        this.items[4].setPrice(12.00); 
        this.items[5].setPrice(30.76); 
        this.items[6].setPrice(20.99); 
    }


    /**
     * This function prints the summary 
     *    1.) Items Purchased 
     *    2.) Items Left
     *    3.) Money Left
     */
    public void print(){

        System.out.println("-------- Purchased -----------------");


        for(Item item:this.purchasedItems){
            if(item.getName() != "None"){
                System.out.println(item.toString());
            }
        }


        System.out.println("------------- Left Items---------------");

        for(Item item:this.leftItems){
             if(item.getName() != "None"){
                System.out.println(item.toString());
            }
        }

        System.out.println("------------------------------");

        System.out.println("Money left: $" + String.format( "%.2f", this.moneyOwn )  + "\n");
         
    
    
    }



}
