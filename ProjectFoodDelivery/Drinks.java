import javax.swing.JOptionPane;

public enum Drinks {
    D101("Plain Water", 1.50),
    D102("7-UP", 4.00),
    D103("Milk Tea", 6.70),
    D104("Milo", 3.80),
    D105("Pepsi", 3.00),
    D106("Black Tea", 2.00),
    D107("Cappuccino", 6.00);

    private String drinksName;
    private double drinksPrice;
    private int quantity;

    Drinks(String drinksName, double drinksPrice) {
        this.drinksName = drinksName;
        this.drinksPrice = drinksPrice;
    }

    public String getDrinksName() {
        return drinksName;
    }

    public void setDrinksName(String drinksName) {
        this.drinksName = drinksName;
    }

    public double getDrinksPrice() {
        return drinksPrice;
    }

    public void setDrinksPrice(double drinksPrice) {
        this.drinksPrice = drinksPrice;
    }

    public void setDrinksQtty(int quantity) {
        this.quantity = quantity;
    }

    public int getDrinksQtty() {
        return quantity;
    }

    public void sellDrinks(int qtty) {
        int leftQtty = getDrinksQtty() - qtty;

        if (getDrinksQtty() == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, out of stock", "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else if (leftQtty < 0) {
            String msg = "Sorry, only " + getDrinksQtty() + " item left";
            JOptionPane.showConfirmDialog(null, msg, "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else {
            setDrinksQtty(leftQtty);
        }
    }

    public static String display() {
        StringBuilder output = new StringBuilder();

        for (Drinks d : Drinks.values()) {
            String info = String.format("%-8s%-20sRM %-6.2f%n", d, d.drinksName, d.drinksPrice);
            output.append(info);
        }

        return output.toString();
    }
}
