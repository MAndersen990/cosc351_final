package assignment4;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class FoodItem {
	protected String Name;
	protected String Brand;
	protected String productionDate;
	protected long upcCode;
	protected double unitWeight;
	protected long productAge;

	public FoodItem() {
		this.Name = "";
		this.productionDate = "";
		this.Brand = "";
	}

	// The method used in order to set the Name of the product in the class
	public boolean setName(String Name) {
		try {
			if (Name.length() > 1 && Name.length() < 51) {
				if (isOk(Name)) {
					this.Name = Name;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// the method used to get the name of the product that is set for the class
	public String getName() {
		return Name;
	}

	// the method used to tset the UPC code for the private variable upcCode
	public void setUpc(long upcCode) {

		this.upcCode = upcCode;
	}

	// the method used to get whatever value is entered into the private variable
	// upcCode
	public long getUpc() {
		return upcCode;
	}

	// this method is used to set the unit weight for the private varible in this
	// class
	public boolean setUnitWeight(double unitWeight) {
		if (unitWeight > 0) {
			this.unitWeight = unitWeight;
			return true;
		} else {
			return false;
		}
	}

	// the method that gets whatever unit weight was entered by the user for this
	// class
	public double getUnitWeight() {
		return unitWeight;
	}

	// the method that sets the brand name
	public boolean setBrand(String Brand) {
		try {
			if (Brand.length() > 1 && Brand.length() < 51 && Brand != null) {
				if (isOk(Brand)) {
					this.Brand = Brand;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// the method that is used to get the brand name of whatever is entered
	public String getBrand() {
		return Brand;
	}

	// the method that sets the production date for the product that is being
	// entered into the system
	public boolean setProductionDate(String productionDate) {
		try {
			LocalDate production = LocalDate.parse(productionDate);

			if (production.isAfter(LocalDate.now())) {

				return false;

			} else {
				this.productionDate = productionDate;
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}

	// the method that is used to display the production date of the product that is
	// going into the system
	public String getProductionDate() {
		return productionDate;
	}

	public void setProductAge() {
		LocalDate age = LocalDate.parse(productionDate);

		LocalDate today = LocalDate.now();

		long days = DAYS.between(age, today);

		this.productAge = days;

	}

	public long getProductAge() {
		return productAge;
	}

	private boolean isOk(String test) {
		return test.matches("[-a-zA-z' ]+");
	}

}
