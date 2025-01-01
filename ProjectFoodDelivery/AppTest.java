import javax.swing.*;
import java.awt.Dimension;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class AppTest {
	public static void main(String[] args) {

		// declaring display variables
		String code;
		int availableQtty, quantity;
		Object select, year, B40assistance;
		Order order;
		String choice;
		Client clients;

		// an arrayList containing all the client objects
		ArrayList<Client> clientList = new ArrayList<>();

		// field variables
		JTextField name = new JTextField();
		JTextField phoneNo = new JTextField();
		JTextField email = new JTextField();
		JTextField blockNo = new JTextField();
		JTextField buildingName = new JTextField();
		JTextField city = new JTextField();

		JTextField matric = new JTextField();
		JTextField staffId = new JTextField();
		JTextField yearsTeaching = new JTextField();

		JTextField code1 = new JTextField();
		JTextField note1 = new JTextField();
		JTextField qtty = new JTextField();

		// setting the quantity
		Food.F101.setFoodQtty(3);
		Food.F102.setFoodQtty(5);
		Food.F103.setFoodQtty(6);
		Food.F104.setFoodQtty(3);
		Food.F105.setFoodQtty(4);

		Drinks.D101.setDrinksQtty(5);
		Drinks.D102.setDrinksQtty(3);
		Drinks.D103.setDrinksQtty(5);
		Drinks.D104.setDrinksQtty(5);
		Drinks.D105.setDrinksQtty(5);
		Drinks.D106.setDrinksQtty(5);
		Drinks.D107.setDrinksQtty(5);

		Hygiene.H001.setItemQtty(5);
		Hygiene.H002.setItemQtty(5);
		Hygiene.H003.setItemQtty(5);
		Hygiene.H004.setItemQtty(5);
		Hygiene.H005.setItemQtty(5);

		// array of field for registration
		Object[] field = { "Enter Name:", name, "Phone number: ", phoneNo, "E-mail: ", email, "Building Name: ",
				buildingName, "Block No: ", blockNo, "City: ", city, };

		// setting display dimension
		UIManager.put("OptionPane.minimumSize", new Dimension(300, 500));

		boolean status = true;
		mainloop: while (status) {

			int a = JOptionPane.showConfirmDialog(null, field, "Delivery Registration", JOptionPane.OK_CANCEL_OPTION);
			String name1 = name.getText();
			String phoneNo1 = phoneNo.getText();
			String email1 = email.getText();
			String buildingName1 = buildingName.getText();
			String blockNo1 = blockNo.getText();
			String city1 = city.getText();
			String[] input = { name1, phoneNo1, email1, buildingName1, blockNo1, city1 };
			
			switch (a) {
			// 0 is for okay and 2 is for cancel
			case 0:
				break;
			case 2:
				System.out.println("cancelled");
				System.exit(0);
			}
			
			for (String i : input) {
				if (i.equals("")) {
					JOptionPane.showMessageDialog(null, "Fields can't be empty\nEnsure all fields are filled out",
							"Invalid Input", JOptionPane.ERROR_MESSAGE);
					continue mainloop;
				} else if (name1.matches(".*\\d.*")) {

					JOptionPane.showMessageDialog(null, "Name can't contain a number", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);

					continue mainloop;

				} else if (phoneNo1.matches(".*[a-z]+.*")) {
					JOptionPane.showMessageDialog(null, "Phone number can't contain letters", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
					continue mainloop;

				} else if (!(email1.contains("@"))) {
					JOptionPane.showMessageDialog(null, "Email must contain '@'", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
					continue mainloop;
				}

				status = false;

			}

		}

		Address address = new Address(blockNo.getText(), buildingName.getText(), city.getText());

		// array of field for client selection
		Object[] client = { "Student", "Staff" };
		select = JOptionPane.showInputDialog(null, "Select Client type", "Client selection",
				JOptionPane.QUESTION_MESSAGE, null, client, "select");
		try {
			if (select.toString().equals("Student")) {

				Object[] students = { "Enter Matric Number:", matric };
				JOptionPane.showConfirmDialog(null, students, "Student Registration", JOptionPane.OK_CANCEL_OPTION);
				Object[] years = { 1, 2, 3, 4, 5, 6 };
				year = JOptionPane.showInputDialog(null, "Select year of study", "Year of study",
						JOptionPane.QUESTION_MESSAGE, null, years, 1);

				Object[] B40 = { "Yes", "No" };
				B40assistance = JOptionPane.showInputDialog(null, "Are you under B40", "B40 assistance",
						JOptionPane.QUESTION_MESSAGE, null, B40, "No");

				clients = new Student(name.getText(), phoneNo.getText(), email.getText(), address, matric.getText(),
						(Integer) year, (String) B40assistance);
				clientList.add(clients);
			} else if (select.toString().equals("Staff")) {
				Object[] staff = { "Enter Staff ID:", staffId, "Enter years of teaching", yearsTeaching };
				JOptionPane.showConfirmDialog(null, staff, "Staff registration", JOptionPane.OK_CANCEL_OPTION);

				// to Staff object
				clients = new Staff(name.getText(), phoneNo.getText(), email.getText(), address, staffId.getText(),
						Integer.parseInt(yearsTeaching.getText()));
				clientList.add(clients);
			}
		} catch (Exception e) {
			System.out.println("You haven't selected anything");
			System.exit(0);
		}
		Vector<Order> items = new Vector<>();
		Date date = new Date();
		// to generate random order number
		Random random = new Random();

		do {

			choice = optionList();
			switch (choice) {
			case "Food":

				Object[] foodInfo = { Food.display() + "\nPlease enter the package code:", code1, "Quantity:", qtty,
						"Add a note for your order:", note1 };

				JOptionPane.showConfirmDialog(null, foodInfo, "Food Order", JOptionPane.OK_CANCEL_OPTION);
				code = code1.getText().toUpperCase();
				quantity = Integer.parseInt(qtty.getText());
				Food food = Food.valueOf(code);
				availableQtty = food.getFoodQtty();
				order = new Order(food, quantity, note1.getText(), date);
				
				if (food.getFoodQtty() < availableQtty) {	
					items.addElement(order);
				}

				break;

			case "Drinks":

				Object[] drinksInfo = { Drinks.display() + "\nPlease enter the package code:", code1, "Quantity:", qtty,
						"Add a note for your order:", note1 };

				JOptionPane.showConfirmDialog(null, drinksInfo, "Drinks Order", JOptionPane.OK_CANCEL_OPTION);
				code = code1.getText().toUpperCase();
				quantity = Integer.parseInt(qtty.getText());
				Drinks drinks = Drinks.valueOf(code);
				availableQtty = drinks.getDrinksQtty();
				order = new Order(drinks, quantity, note1.getText(), date);

				if (drinks.getDrinksQtty() < availableQtty) {
					items.addElement(order);
				}

				break;

			case "Hygiene":

				Object[] hygieneInfo = { Hygiene.display() + "\nPlease enter the package code:", code1, "Quantity:",
						qtty, "Add a note for your order:", note1 };

				JOptionPane.showConfirmDialog(null, hygieneInfo, "Hygiene Item  Order", JOptionPane.OK_CANCEL_OPTION);
				code = code1.getText().toUpperCase();
				quantity = Integer.parseInt(qtty.getText());
				Hygiene item = Hygiene.valueOf(code);
				availableQtty = item.getItemQtty();
				order = new Order(item, quantity, note1.getText(), date);

				if (item.getItemQtty() < availableQtty) {			
					items.addElement(order);
				}

				break;

			}

		} while (choice != "Complete Order");


		if (!items.isEmpty()) {
			for (Client j : clientList) {

				String title = "\t\t****Order Summary****\n\n";
				String info, dispSubtotal, dispDiscount, dispTotalPrice, output = "", output1 = "";
				double subtotal = 0.0, totalPrice;
				int totalItem = 0;

				for (Order i : items) {

					if (i.getFood() instanceof Food) {
						info = String.format("#%d%n%s%-18sRM %-6.2f%15s%-6d%n", (items.indexOf(i) + 1), i.orderInfo(),
								i.getFood().getFoodName(), i.getFood().getFoodPrice(), "Quantity: ", i.getOrderQtty());

						subtotal += (i.getFood().getFoodPrice() * i.orderQtty);
						totalItem += i.orderQtty;
					} else if (i.getDrinks() instanceof Drinks) {
						info = String.format("#%d%n%s%-18sRM %-6.2f%15s%-6d%n", (items.indexOf(i) + 1), i.orderInfo(),
								i.getDrinks().getDrinksName(), i.getDrinks().getDrinksPrice(), "Quantity: ",
								i.getOrderQtty());

						subtotal += (i.getDrinks().getDrinksPrice() * i.orderQtty);
						totalItem += i.orderQtty;

					} else {
						info = String.format("#%d%n%s%-18sRM %-6.2f%15s%-6d%n", (items.indexOf(i) + 1), i.orderInfo(),
								i.getHygiene().getItemName(), i.getHygiene().getItemPrice(), "Quantity: ",
								i.getOrderQtty());

						subtotal += (i.getHygiene().getItemPrice() * i.orderQtty);
						totalItem += i.orderQtty;
					}

					output += info;
					output += "\n";
				}

				dispSubtotal = String.format("%nSubtotal : RM %-6.2f%n", subtotal);
				dispDiscount = "Discount : " + String.format("%.0f", (1 - j.calcDisc()) * 100) + "%\n";
				totalPrice = subtotal * j.calcDisc();
				dispTotalPrice = String.format("%.2f", totalPrice);
				dispTotalPrice = "============================\n" + "Total Item: " + totalItem + dispSubtotal
						+ dispDiscount + "Total Price : RM " + dispTotalPrice + "\n============================";
				output += dispTotalPrice;
				output = title + output;
				output1 += (output + "\n\nPress 'Ok' to confirm and print order receipt");

				int z = JOptionPane.showConfirmDialog(null, output1, "Order Information", JOptionPane.OK_CANCEL_OPTION);

				switch (z) {
				case 0:
					break;
				case 2:
					items.clear();
					JOptionPane.showMessageDialog(null, "Your order has been successfully cancelled", "Order Cancelled",
							JOptionPane.OK_OPTION);
				}

				try {
					File file = new File("Receipt.txt");
					PrintWriter writer = new PrintWriter(file);
					writer.write(j.toString() + "\n\n============================\n");
					writer.write(output);
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {
			String info = "No bought item";
			JOptionPane.showMessageDialog(null, info, "Order Information", JOptionPane.ERROR_MESSAGE);
		}

		System.exit(0);
	}

	public static String optionList() {

		Object[] packages = { "Food", "Drinks", "Hygiene", "Complete Order" };
		Object packs = JOptionPane.showInputDialog(null, "select a package", "What do you want to order",
				JOptionPane.QUESTION_MESSAGE, null, packages, "Food");
		String choice = packs.toString();

		return choice;
	}
	
}