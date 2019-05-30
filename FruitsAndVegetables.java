package assignment4;

public class FruitsAndVegetables extends FreshFood {
	private String farm;
	private String season;
	private final String[] seasonArray = new String[] { "Summer", "Spring", "Fall", "Winter", "Mixed" };

	public FruitsAndVegetables() {
		this.farm = "";
		this.season = "";
	}

	public boolean setFarm(String farm) {
		try {
			if (farm.length() > 1 && farm.length() < 51) {
				if (isOk(farm)) {
					this.farm = farm;
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

	public String getFarm() {
		return farm;
	}

	public boolean setSeason(String season) {
		try {
			for (int i = 0; i < seasonArray.length; i++) {// loop that goes through all iterations of the seasonArray
															// trying
				// to find the correct value and if it is valid set it to that
				if (season.equalsIgnoreCase(seasonArray[i]) && season != null) {
					this.season = season;
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public String getSeason() {
		return season;
	}

	public String toString() {
		return "Name: " + Name + "\n" + "Brand: " + Brand + "\n" + "Production date: " + productionDate + "\n" + "UPC: "
				+ upcCode + "\n" + "Unit Weight: " + unitWeight + "\n" + "Product Age: " + productAge + "\n"
				+ "Expirateion Date: " + expirationDate + "\n" + "Refrigerated: " + refrigerated + "\n" + "Farm: "
				+ farm + "\n" + "Season: " + season;
	}

	private boolean isOk(String test) {
		return test.matches("[-a-zA-z' ]+");
	}
}
