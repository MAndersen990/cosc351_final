package assignment4;

/**


 @author Eric Brown, COSC 351.101, Assignment 2
 */



/**
 * Create new class Precooked inherited by ProcessedFood
 */
public class Precooked extends ProcessedFood implements Stackable{
	
	/**
	 * Private attributes for Precooked class
	 */
	private String[] ingredients;
	private boolean frozen;
	private boolean stackable;
    private int maxStackCount;
    private String stackDescription;
	
	/**
	 * Method to get Ingredients
	 * @return
	 */
	public String [] getIngredients() {
		return ingredients;
	}
	
	/**
	 * Methods to set Ingredients
	 * @param
	 */


	public boolean setIngredients(String[] ingredients) {
		try {
		for(int i = 0; i < ingredients.length; i++) {
			if(isOk(ingredients[i]) && ingredients[i].length() > 1 && ingredients[i].length() < 51) {
				this.ingredients = ingredients;
				System.out.println(ingredients);
				return true;
			}
			else if(!isOk(ingredients[i]) || ingredients[i].length() < 2 || ingredients[i].length() > 51) {
				return false;
			}
			
		}
		}
		catch(Exception e) {
			return false;
		}
		return false;
		
		
			
	}
	
	/**
	 * Method to get Frozen
	 * @return
	 */
	public boolean isFrozen() {
		return frozen;
	}
	
	/**
	 * Method to set Frozen
	 * @param frozen
	 */
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	private static boolean isOk(String test){
        return test.matches("[-a-zA-z' ]+");
    }

	public String toString() {
		return "Name: " + Name + "\n" + "Brand: " + Brand + "\n" + "Production date: " + productionDate + "\n" +
				"UPC: " + upcCode + "\n" + "Unit Weight: " + unitWeight + "\n" + "Product Age: " + productAge + "\n" +
				"Packaging: " + packaging + "\n" + "Expiration Date: " + expirationDate + "\n" + "Ingredientse: " + ingredients + "\n" +
				"Frozen: " + frozen + "\n" + "Stackable: " + stackable + "\n" + "Stack Count: " + maxStackCount + "\n" +
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
