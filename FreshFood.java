package assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class FreshFood extends FoodItem {
	protected String expirationDate;
	protected boolean refrigerated;
	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public FreshFood() {
		this.expirationDate = "";
	}

	// method that returns true if the value that is passed into the method is
	// acceptable otherwise returns false/null
	public boolean setExpirationDate(String expirationDate) {
		try {
			LocalDate expiration = LocalDate.parse(expirationDate, format); // used to get the expiration date into the
																			// proper
			// format in order to perform the Dats.between call
			LocalDate production = LocalDate.parse(productionDate, format); // used to get the production date into the
																			// propwer
			// format in order to perform the Days.between call
			long days_between = DAYS.between(production, expiration); // variable that tells how many days are between
																		// the
			// expiration date and the production date

			if (expirationDate != null) {
				if (expiration.isAfter(production) && days_between <= 30 && expirationDate != null) {
					this.expirationDate = expirationDate;
					return true;
				}

				else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setRefrigerated(boolean refrigerated) {
		this.refrigerated = refrigerated;

	}

	public boolean isRefrigerated() {
		return refrigerated;
	}
}
