package assignment4;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class ProcessedFood extends FoodItem implements Stackable {

	protected String packaging;
	protected String expirationDate;
	private final String[] packageArray = new String[] { "Plastic", "Metal", "Paper", "None" };
	protected boolean stackable;
	protected int maxStackCount;
	protected String stackDescription;

	public ProcessedFood() {
		this.packaging = "";
		this.expirationDate = "";
	}

	public String getPackaging() {
		return packaging;
	}

	public boolean setPackaging(String packaging) {
		try {
			for (int i = 0; i < packageArray.length; i++) {// loop that goes through all iterations of the seasonArray
															// trying
				// to find the correct value and if it is valid set it to that
				if (packaging.equalsIgnoreCase(packageArray[i]) && packaging != null) {
					this.packaging = packaging;
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public boolean setExpirationDate(String expirationDate) {
		try {
			LocalDate expiration = LocalDate.parse(expirationDate); // used to get the expiration date into the proper
			// format in order to perform the Dats.between call
			LocalDate production = LocalDate.parse(productionDate); // used to get the production date into the proper
			// format in order to perform the Days.between call
			long days_between = DAYS.between(production, expiration); // variable that tells how many days are between
																		// the
			// expiration date and the production date

			if (expirationDate != null) {
				if (expiration.isAfter(production) && days_between <= 1825 && expirationDate != null) {
					this.expirationDate = expirationDate;
					return true;
				}

				else {

					return false;
				}
			} else {
				this.expirationDate = "0000-00-00";
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isOk(String test) {
		return test.matches("[-a-zA-z' ]+");
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
