public class Staff extends Client {
    private String staffID;
    private int yearTeaching;

    public Staff(String name, String phoneNumber, String email, Address b2, String staffID, int yearTeaching) {
        super(name, phoneNumber, email, b2);
        this.staffID = staffID;
        this.yearTeaching = yearTeaching;
    }

    public String toString() {
        return "Staff Name: " +  getName() +
                "\nStaffID: " + staffID + "\n" +
                "Phone number: " + getPhoneNumber() + "\n" +
                "Email: " + getEmail() + "\n" +
                "building: " + address.fullAddress() + "\n" +
                "yearTeaching: " + yearTeaching;
    }
    
    public void displayInfo() {
    	toString();
    }

    public double calcDisc() {
        if (yearTeaching <= 5) {
            return 1-(STAFFj_DISCOUNT/100);
        }else if (yearTeaching > 5){
            return 1-(STAFFs_DISCOUNT/100);
        }
        return 1.0;
    }
}
