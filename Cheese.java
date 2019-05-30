package assignment4;

/**
 * @author Eric Brown, COSC 351.101, Assignment 2
 */

/**
 * Import File Reader
 */




/*
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

*/

/**
 * Create new class Cheese inherited by ProcessedFood
 */
public class Cheese extends ProcessedFood implements Stackable {
	
	/**
	 * Private attributes for Cheese class
	 */
	private String milkType;
	private String origin;
	private final String[] milkArray = new String[] {"Cow","Sheep","Goat","Buffalo","Mixed"};
	private boolean stackable;
    private int maxStackCount;
    private String stackDescription;
	
	public Cheese() {
		this.milkType = "";
		this.origin = "";
	}
	
	/**
	 * Method to get Milk Type
	 * @return
	 */
	public String getMilkType() {
		return milkType;
	}
	/**
	 * Method to set Milk Type
	 * @param milkType
	 */
	public boolean setMilkType(String milkType) {
		try {
	        for(int i = 0; i < milkArray.length; i++){//loop that goes through all iterations of the seasonArray trying
	        	//to find the correct value and if it is valid set it to that
	            if (milkType.equalsIgnoreCase(milkArray[i])&& milkType!= null) {
	                this.milkType = milkType;
	                return true;
	            }
	        }
        }
	        catch(Exception e) {
	        	return false;
	        }
        return false;
	}
	
	/**
	 * Method to get Country Origin
	 * @return
	*/
	public String getOrigin() {
		return origin;
	}
	/**
	 * Method to set Origin; Country code is parsed from JSON depending,
	 * on user input
	 * @param
	 */

/*
	public void setOrigin(String origin) {
		try {
			// The JSON file should be in the 'src' folder of your project.
			JSONArray a = (JSONArray) (new JSONParser()).parse(new FileReader("src/assignment3/countries.json"));
			boolean found = false;
			for (Object name : a) {
				String countryName = (String) ((JSONObject) name).get("name");
				String countryValue = (String) ((JSONObject) name).get("code");
				if (origin.equalsIgnoreCase(countryName)) {
					found = true;
					System.out.println("Country value: " + countryValue);
					break;
				}
			}
			if (found == false) {
				System.out.println("Invalid Input");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
*/
	private boolean isOk(String test){
		return test.matches("[-a-zA-z' ]+");
	}

	public String toString(){
		return "Name: " + Name + "\n" + "Brand: " + Brand + "\n" + "Production date: " + productionDate + "\n" +
				"UPC: " + upcCode + "\n" + "Unit Weight: " + unitWeight + "\n" + "Product Age: "  +  productAge + "\n" +
				"Packaging: " + packaging + "\n" + "Expiration Date: " + expirationDate + "\n" + "Milk Type: " + milkType + "\n" +
				"Origin: " + origin + "\n" + "Stackable: " + stackable + "\n" + "Stack Count: " + maxStackCount + "\n" +
				"Description: " + stackDescription;
	}

	@Override
    public boolean isStackable(){
        return stackable;
    }

    @Override
    public void setStackable(boolean stackable){
        this.stackable = stackable;
    }

    @Override
    public boolean setMaxStackCount(int maxStackCount){
    	if(maxStackCount > 1) {
    		this.maxStackCount = maxStackCount;
    		return true;
    	}
    	else {
    		return false;
    	}
        
    }

    @Override
    public int getMaxStackCount(){
        return maxStackCount;
    }

    @Override
    public boolean setStackDescription(String stackDescription){
		if (stackDescription.length() >= 2 && stackDescription.length()  <=240){
			if(isOk(stackDescription)){
				this.stackDescription = stackDescription;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

    }

    @Override
    public String getStackDescription(){
        return stackDescription;
    }

}

