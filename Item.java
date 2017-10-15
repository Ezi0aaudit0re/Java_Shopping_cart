/**
 * This class is the blueprint of the properties and attributes an item would contain
 * Instance variables
 *  * String name - Default "None",  The name of the item EG Apple 
 *  * int priority - Default -1, Priority of an item from 1 to 7 
 *  * double price - The price of an item down to the last penny
 *  @author Aman Nagpal
 *  @version 1.0
 **/

public class Item{
    
    // Assign instance private variables with default values 
    private String name;
    private int priority;
    private double price;

    // Constructors 
    
    /**
     * Constructor with no arguments
     */
    public Item(){
        this.setName("None");
        this.setPrice(-1.0);
        this.setPriority(-1);
    }

    /**
     * Constructor that sets the instance variables 
     * @param item_name - The name of the item
     * */
    public Item(String item_name){
        this.setName(item_name);
    }

    public Item(int item_priority){
        if (item_priority > 0 && item_priority < 8){
            this.priority = item_priority; 
        }
    }

    public Item(String item_name, int item_priority){
        this.setName(item_name);
        if (item_priority > 0 && item_priority < 8){
            this.priority = item_priority; 
        }

    }
    

    // Setters 
    /**
     * All the settters take the parameter which they set equal to respective instance variables 
     */
    public void setName(String item_name){
        this.name = item_name;
    }    

    public void setPriority(int item_priority){
        this.priority = item_priority; 
    }
    
    public void setPrice(double item_price){
        this.price = item_price; 
    }

    // Getters 
    public String getName(){
        return this.name; 
    } 

    public int getPriority(){
        return this.priority;
    }

    public double getPrice(){
        return this.price; 
    }


    /**
     * This function changes the representation 
     **/
    public String toString(){
        return "Item: " + this.getName() + " Priority: " + this.getPriority() + " Price: " + this.getPrice(); 
    }

    /**
     * This function compares if the name of the item is same or different
     * to the name provided by the user 
     * @param name - the name inputed by the user 
     * @return true - if item is already in the list
     *         false - if item is not in the list
     *
     */
    public boolean equals(String name){
        // we convert both the strings to lower case so that they are not case sensitive
        if(this.getName().toLowerCase().equals(name.toLowerCase())){
            return true; 
        } 
        else{
            return false; 
        }
    
    }
        

}
