import java.util.*;

public abstract class Client implements Discount{

	private String name;
	private String phoneNumber;
	Address address;
	private String email;
	private Vector<Order> itemList;

	public Client(String name, String phoneNumber, String email, Address address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		itemList = new Vector<Order>();
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void submitOrder(Order o) {
		itemList.add(o);
	}

	public abstract void displayInfo();
}
