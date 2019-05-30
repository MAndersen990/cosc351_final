package assignment4;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment4 {
	private static final Scanner userInput = new Scanner(System.in);
	private static int tempInt;
	private static boolean tempBool;
	private static String tempString;
	private static long tempLong;
	private static short tempShort;
	private static double tempDouble;

	public static void main(String[] args) {
		FoodItem[] foodList = new FoodItem[5];
		boolean x = true;
		int index = 0;
		while (x) {
			try {
				String[] options = new String[] { "Create", "Show", "Edit" };
				for (int y = 0; y < options.length; y++) {
					System.out.println((y + 1) + " - " + options[y]);

				}
				System.out.println("0 - Exit");

				System.out.println("Please choose what you would like to do: ");
				tempInt = userInput.nextInt();
				userInput.nextLine();
				if (tempInt == 0) {
					x = false;
				} else {
//create
					switch (tempInt) {
					case 1:
						String[] items = new String[] { "Cheese", "Protein", "Fruits and Vegetables",
								"Precooked Foods" };
						for (int i = 0; i < items.length; i++) {
							System.out.println((i + 1) + " - " + items[i]);
						}
						System.out.println("Please choose which item you are entering: ");
						tempInt = userInput.nextInt();
						userInput.nextLine();
						switch (tempInt) {
						case 1:
							foodList[index] = (setCheeseInfo());
							index += 1;
							break;

						case 2:
							foodList[index] = (setProteinInfo());
							index += 1;
							break;

						case 3:
							foodList[index] = (setFruitsAndVeggiesInfo());
							index += 1;
							break;

						case 4:
							foodList[index] = (setPrecookedFoodInfo());
							index += 1;
							break;
						}
						break;
//Display
					case 2:
						if (foodList.length < 1) {
							System.out.println("No objects have been created!");
						} else {

							for (int i = 0; i < foodList.length; i++) {
								System.out.println("Object " + (i + 1) + ": \n" + foodList[i].toString());
							}

						}
//Edit
					case 3:
						boolean success = editEntry(foodList, index, userInput);
						break;

					default: // Invalid Input
						System.out.println("Invalid Input");
					}

				}

			} catch (InputMismatchException ime) {
				System.out.println("You cannot enter that value"); // the only catch the runs infinitely if I do not add
																	// the break
				break;

			} catch (NullPointerException npe) { // handles if the class is not stackable and has a null description

			} catch (IndexOutOfBoundsException ioobe) {
				System.out.println("You cannot add any more objects - the max has been reached");
			} catch (DateTimeParseException dtpe) {
				System.out.println("Please enter a correct date format");
			}

			catch (Exception e) {
				System.out.println("You can't do that");
			}

		}
	}

//Edit Entry
	public static boolean editEntry(FoodItem[] foodList, int index, Scanner userInput) {
		// Display objects
		if (foodList.length < 1) {
			System.out.println("No objects have been created!");
		} else {

			for (int i = 0; i < index; i++) {
				System.out.println("Object " + i + ": \n" + foodList[i].toString());
			}

		}

		System.out.println("Which object number do you wish to edit: ");
		int input;

		try {
			input = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input");
			input = -1;
		}

		if (foodList[input] instanceof Cheese) {
			foodList[input] = (setCheeseInfo());
			return true;
		}
		if (foodList[input] instanceof FruitsAndVegetables) {
			foodList[input] = setFruitsAndVeggiesInfo();
			return true;
		}
		if (foodList[input] instanceof Protein) {
			foodList[input] = setProteinInfo();
			return true;
		}
		if (foodList[input] instanceof Precooked) {
			foodList[input] = setPrecookedFoodInfo();
			return true;
		}

		return false;
	}

	private static Cheese setCheeseInfo() {
		Cheese c = new Cheese();
		System.out.println("What is the cheese name: ");
		tempString = userInput.nextLine();
		c.setName(tempString);

		System.out.println("What brand is the cheese: ");
		tempString = userInput.nextLine();
		c.setBrand(tempString);

		System.out.println("What is the UPC code: ");
		tempLong = userInput.nextLong();
		c.setUpc(tempLong);

		System.out.println("When was the production date (YYYY-MM-DD): ");
		tempString = userInput.next();
		c.setProductionDate(tempString);

		System.out.println("What is the unit weight: ");
		tempDouble = userInput.nextDouble();
		c.setUnitWeight(tempDouble);

		c.setProductAge();

		System.out.println("What kind of packaging is it in(Plastc,Metal,Paper,None): ");
		tempString = userInput.next();
		c.setPackaging(tempString);

		System.out.println("What is the expiration date(YYYY-MM-DD): ");
		tempString = userInput.next();
		c.setExpirationDate(tempString);

		System.out.println("What is the milk type(Cow,Sheep,Goat,Buffalo,Miex): ");
		tempString = userInput.next();
		c.setMilkType(tempString);

//        System.out.println("What is the country of origina: ");
		// tempString = userInput.next();
		// c.setOrigin(tempString);

		System.out.println("Is your cheese stackable(true or false): ");
		tempBool = userInput.nextBoolean();
		c.setStackable(tempBool);
		/*
		 * System.out.println("Here if the info you entered: ");
		 * System.out.println("Name: " + c.getName()); System.out.println("Brand: " +
		 * c.getBrand()); System.out.println("UPC: " + c.getUpc());
		 * System.out.println("Production Date: " + c.getProductionDate());
		 * System.out.println("Unit Weight: " + c.getUnitWeight());
		 * System.out.println("Packaging type: " + c.getPackaging());
		 * System.out.println("Expiration Date: " + c.getExpirationDate());
		 * System.out.println("Product Age: " + c.getProductAge());
		 * System.out.println("Milk Type: " + c.getMilkType());
		 * System.out.println("Country of origin: " + c.getOrigin());
		 * if(c.isStackable()){ System.out.println("Stackable: " + c.isStackable());
		 * System.out.println("Max Stack Count: " + c.getMaxStackCount());
		 * System.out.println("Stack Description: " + c.getStackDescription()); }
		 */
		return c;

	}

	private static Protein setProteinInfo() {
		Protein p = new Protein();
		System.out.println("What is the protein name: ");
		tempString = userInput.next();
		p.setName(tempString);

		System.out.println("What brand is the protein: ");
		tempString = userInput.next();
		p.setBrand(tempString);

		System.out.println("What is the UPC code: ");
		tempLong = userInput.nextLong();
		p.setUpc(tempLong);

		System.out.println("When was the production date (YYYY-MM-DD): ");
		tempString = userInput.next();
		p.setProductionDate(tempString);

		System.out.println("What is the unit weight: ");
		tempDouble = userInput.nextDouble();
		p.setUnitWeight(tempDouble);

		p.setProductAge();

		System.out.println("Is the protein refrigerated(true or false): ");
		tempBool = userInput.nextBoolean();
		p.setRefrigerated(tempBool);

		System.out.println("What is the expiration date(YYYY-MM-DD): ");
		tempString = userInput.next();
		p.setExpirationDate(tempString);

		System.out.println("What type of protein is it(Cattle,Game,Fish,Poultry): ");
		tempString = userInput.next();
		p.setType(tempString);

		System.out.println("Is it prepackaged(true or false): ");
		tempBool = userInput.nextBoolean();
		p.setPrepackaged(tempBool);

		System.out.println("Is your protein stackable(true or false): ");
		tempBool = userInput.nextBoolean();
		p.setStackable(tempBool);
		if (p.isStackable()) {
			System.out.println("What is the max stack count: ");
			tempInt = userInput.nextInt();
			userInput.nextLine();
			p.setMaxStackCount(tempInt);

			System.out.println("Set the instructions for stacking here: ");
			tempString = userInput.nextLine();
			p.setStackDescription(tempString);
		}

		return p;
		/*
		 * System.out.println("Here if the info you entered: ");
		 * System.out.println("Name: " + p.getName()); System.out.println("Brand: " +
		 * p.getBrand()); System.out.println("UPC: " + p.getUpc());
		 * System.out.println("Production Date: " + p.getProductionDate());
		 * System.out.println("Unit Weight: " + p.getUnitWeight());
		 * System.out.println("Refrigerated: " + p.isRefrigerated());
		 * System.out.println("Expiration Date: " + p.getExpirationDate());
		 * System.out.println("Product Age: " + p.getProductAge());
		 * System.out.println("Protein Type: " + p.getType());
		 * System.out.println("Prepacakged: " + p.isPrepackaged()); if(p.isStackable()){
		 * System.out.println("Stackable: " + p.isStackable());
		 * System.out.println("Max Stack Count: " + p.getMaxStackCount());
		 * System.out.println("Stack Description: " + p.getStackDescription()); }
		 */
	}

	private static FruitsAndVegetables setFruitsAndVeggiesInfo() {
		FruitsAndVegetables f = new FruitsAndVegetables();
		System.out.println("What is the Fruit or Veggie name: ");
		tempString = userInput.next();
		f.setName(tempString);

		System.out.println("What brand is the Fruit or Veggie: ");
		tempString = userInput.next();
		f.setBrand(tempString);

		System.out.println("What is the UPC code: ");
		tempLong = userInput.nextLong();
		f.setUpc(tempLong);

		System.out.println("When was the production date (YYYY-MM-DD): ");
		tempString = userInput.next();
		f.setProductionDate(tempString);

		System.out.println("What is the unit weight: ");
		tempDouble = userInput.nextDouble();
		f.setUnitWeight(tempDouble);

		f.setProductAge();

		System.out.println("Is the protein refrigerated(true or false): ");
		tempBool = userInput.nextBoolean();
		f.setRefrigerated(tempBool);

		System.out.println("What is the expiration date(YYYY-MM-DD): ");
		tempString = userInput.next();
		f.setExpirationDate(tempString);

		System.out.println("What season is it (Fall, Winter, Summer, Spring): ");
		tempString = userInput.next();
		userInput.nextLine();
		f.setSeason(tempString);

		System.out.println("What is the farm name: ");
		tempString = userInput.nextLine();
		f.setFarm(tempString);

		/*
		 * System.out.println("Here if the info you entered: ");
		 * System.out.println("Name: " + f.getName()); System.out.println("Brand: " +
		 * f.getBrand()); System.out.println("UPC: " + f.getUpc());
		 * System.out.println("Production Date: " + f.getProductionDate());
		 * System.out.println("Unit Weight: " + f.getUnitWeight());
		 * System.out.println("Refrigerated: " + f.isRefrigerated());
		 * System.out.println("Expiration Date: " + f.getExpirationDate());
		 * System.out.println("Product Age: " + f.getProductAge());
		 * System.out.println("Season: " + f.getSeason());
		 * System.out.println("Farm Name: " + f.getFarm());
		 * 
		 */
		return f;

	}

	private static Precooked setPrecookedFoodInfo() {
		Precooked p = new Precooked();
		System.out.println("What is the precooked food name: ");
		tempString = userInput.next();
		p.setName(tempString);

		System.out.println("What brand is the precooded food: ");
		tempString = userInput.next();
		p.setBrand(tempString);

		System.out.println("What is the UPC code: ");
		tempLong = userInput.nextLong();
		p.setUpc(tempLong);

		System.out.println("When was the production date (YYYY-MM-DD): ");
		tempString = userInput.next();
		p.setProductionDate(tempString);

		System.out.println("What is the unit weight: ");
		tempDouble = userInput.nextDouble();
		p.setUnitWeight(tempDouble);

		p.setProductAge();

		System.out.println("What kind of packaging is it in(Plastic,Metal,Paper,None): ");
		tempString = userInput.next();
		p.setPackaging(tempString);

		System.out.println("What is the expiration date(YYYY-MM-DD): ");
		tempString = userInput.next();
		p.setExpirationDate(tempString);

		System.out.println("Is it frozen(true or false): ");
		tempBool = userInput.nextBoolean();
		p.setFrozen(tempBool);

		System.out.println("Is your food stackable(true or false): ");
		tempBool = userInput.nextBoolean();
		p.setStackable(tempBool);
		if (p.isStackable()) {
			System.out.println("What is the max stack count: ");
			tempInt = userInput.nextInt();
			userInput.nextLine();
			p.setMaxStackCount(tempInt);

			System.out.println("Set the instructions for stacking here: ");
			tempString = userInput.nextLine();
			p.setStackDescription(tempString);
		}

		/*
		 * System.out.println("Here if the info you entered: ");
		 * System.out.println("Name: " + p.getName()); System.out.println("Brand: " +
		 * p.getBrand()); System.out.println("UPC: " + p.getUpc());
		 * System.out.println("Production Date: " + p.getProductionDate());
		 * System.out.println("Unit Weight: " + p.getUnitWeight());
		 * System.out.println("Packaging type: " + p.getPackaging());
		 * System.out.println("Expiration Date: " + p.getExpirationDate());
		 * System.out.println("Product Age: " + p.getProductAge());
		 * System.out.println("Packaging Type: " + p.getPackaging());
		 * System.out.println("Frozen: " + p.isFrozen()); if(p.isStackable()){
		 * System.out.println("Stackable: " + p.isStackable());
		 * System.out.println("Max Stack Count: " + p.getMaxStackCount());
		 * System.out.println("Stack Description: " + p.getStackDescription()); }
		 */

		return p;
	}

}
