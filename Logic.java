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
 **/
public class Logic{
    private final int NUM_ITEMS = 7;
    private final boolean DEBUG = true; // for testing
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

            // start validation from second name
            int counter = 0;
            if(true){
                
                // check if the name is unique else ask for name again
                do{
                    if(!Helper.checkName(temp_name, items, itter)){
                        counter++;
                        Helper.checkCounter(counter);
                        temp_name = Helper.getName(); 
                    }
                    else{
                        break; 
                    }
                }while(true);
            }   

                // reset the counter to 0
            counter = 0;

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

            this.items[itter] = new Item(temp_name, temp_priority);
            
            

        if(DEBUG){
            for(int i = 0; i < this.NUM_ITEMS; i++){
                 System.out.println(this.items[i].toString());
            } 
        }

                    

        } 


    
        return true; 
    }





}
