import javax.swing.JOptionPane;

public enum Food {
    F101("Nasi kerabu", 10),
    F102("Nasi lemak", 12),
    F103("Laksa", 5),
    F104("Tom yam", 10), 
    F105("Ikan bakar", 15);

    private String foodName;
    private double foodPrice;
    private int quantity;

    Food(String foodName, double foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodQtty(int quantity) {
        this.quantity = quantity;
    }

    public int getFoodQtty() {
        return quantity;
    }

    public void sellFood(int qtty) {
        int leftQtty = getFoodQtty() - qtty;

        if (getFoodQtty() == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, out of stock", "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else if (leftQtty < 0) {
            String msg = "Sorry, only " + getFoodQtty() + " item left";
            JOptionPane.showConfirmDialog(null, msg, "Order Not Available", JOptionPane.ERROR_MESSAGE);
        } else {
            setFoodQtty(leftQtty);
        }
    }

    public static String display() {
        StringBuilder output = new StringBuilder();

        for (Food d : Food.values()) {
            String info = String.format("%-8s%-20sRM %-6.2f%n", d, d.foodName, d.foodPrice);
            output.append(info);
        }

        return output.toString();
    }
}
