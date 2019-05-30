package assignment4;

public class Protein extends FreshFood implements Stackable {
	private boolean stackable;
	private int maxStackCount;
	private String stackDescription;
	private String type;
	private boolean prepackaged;
	private final String[] proteinType = new String[] { "Cattle", "Game", "Fish", "Poultry" };

	public Protein() {
		this.type = "";
	}

	public boolean setType(String type) {
		try {
			for (int i = 0; i < proteinType.length; i++) { // loop that goes through ever iteration of the proteinType
															// array
				// validatin that the user has enteed a value correctly if they have to it to
				// that value
				if (type.equalsIgnoreCase(proteinType[i])) {
					this.type = type;
					return true;
				} else if (!type.equalsIgnoreCase(proteinType[i])) {
					return false;
				}

			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public String getType() {
		return type;
	}

	public void setPrepackaged(boolean prepackaged) {
		this.prepackaged = prepackaged;
	}

	public boolean isPrepackaged() {
		return prepackaged;
	}

	private boolean isOk(String test) {
		return test.matches("[-a-zA-z' ]+");
	}

	public String toString() {
		return "Name: " + Name + "\n" + "Brand: " + Brand + "\n" + "Production date: " + productionDate + "\n" + "UPC: "
				+ upcCode + "\n" + "Unit Weight: " + unitWeight + "\n" + "Product Age: " + productAge + "\n"
				+ "Expirateion Date: " + expirationDate + "\n" + "Refrigerated: " + refrigerated + "\n" + "Type: "
				+ type + "\n" + "Prepackaged: " + prepackaged + "\n" + "Stackable: " + stackable + "\n"
				+ "Stack Count: " + maxStackCount + "\n" + "Description: " + stackDescription;
	}

	@Override
	public boolean isStackable() {
		return stackable;
	}

	@Override
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	@Override
	public boolean setMaxStackCount(int maxStackCount) {
		if (maxStackCount > 1) {
			this.maxStackCount = maxStackCount;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int getMaxStackCount() {
		return maxStackCount;
	}

	@Override
	public boolean setStackDescription(String stackDescription) {
		if (stackDescription.length() >= 2 && stackDescription.length() <= 240) {
			if (isOk(stackDescription)) {
				this.stackDescription = stackDescription;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String getStackDescription() {

		return stackDescription;
	}

}
