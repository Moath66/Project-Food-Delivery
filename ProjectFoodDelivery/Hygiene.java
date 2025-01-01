import javax.swing.JOptionPane;

public enum Hygiene {
    H001("Soap", 3.00),
    H002("Tissues", 5.30),
    H003("Hand Wash", 16.00),
    H004("Toilet Paper", 13.80),
    H005("Hand Sanitiser", 10.50);

    private String itemName;
    private double itemPrice;
    private int quantity;

    private Hygiene(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQtty(int quantity) {
        this.quantity = quantity;
    }

    public int getItemQtty() {
        return quantity;
    }

    public void sellItem(int qtty) {
        int leftQtty = getItemQtty() - qtty;

        if (getItemQtty() == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, out of stock", "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else if (leftQtty < 0) {
            String msg = "Sorry, only " + getItemQtty() + " item left";
            JOptionPane.showConfirmDialog(null, msg, "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else {
            setItemQtty(leftQtty);
        }
    }

    public static String display() {
        StringBuilder output = new StringBuilder();
//for-each loop.
        for (Hygiene d : Hygiene.values()) {
            String info = String.format("%-8s%-20sRM %-6.2f%n", d, d.itemName, d.itemPrice);
            output.append(info);
        }

        return output.toString();
    }
}
