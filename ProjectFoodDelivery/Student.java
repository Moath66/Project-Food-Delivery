class Student extends Client {
	private String matricNumber;
	private int studyYear;
	private String b40assistance;

	public Student(String name, String phoneNumber, String email, Address b1, String matricNumber, int studyYear,
			String b40assistance) {
		super(name, phoneNumber, email, b1);
		this.matricNumber = matricNumber;
		this.studyYear = studyYear;
		this.b40assistance = b40assistance;
	}

	public String getMatricNumber() {
		return matricNumber;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public String toString() {
		return "Student Name: " + getName() + "\nStudent matric number: " + matricNumber + "\n" + "Phone number: "
				+ getPhoneNumber() + "\n" + "Email: " + getEmail() + "\n" + "building: " + address.fullAddress() + "\n"
				+ "B40 eligible: " + b40assistance + "\n" + "Study year: " + studyYear;
	}

	public void displayInfo() {
		toString();
	}

	public double calcDisc() {
		if (b40assistance.equals("Yes")) {
			return 1 - (B40_DISC / 100);
		} else if (studyYear <= 2) {
			return 1 - (STUDENTj_DISCOUNT / 100);
		} else if (studyYear > 2) {
			return 1 - (STUDENTs_DISCOUNT / 100);
		}
		return 1.0;
	}
}