import java.util.*;

class Order {
    protected String note;
    protected int orderNum, orderQtty;
    private Food food;
    private Drinks drinks;
    private Hygiene hygiene;
    Date date;
    Random random;

    public Order(Food food) {
        this.food = food;
    }

    public Order(Food food, int orderQtty, String note, Date date) {
        this.food = food;
        this.orderQtty = orderQtty;
        this.note = note;
        this.date = new Date();
        this.random = new Random();
        this.orderNum = Math.abs(random.nextInt());
        food.sellFood(orderQtty);
    }

    public Order(Drinks drinks, int orderQtty, String note, Date date) {
        this.drinks = drinks;
        this.orderQtty = orderQtty;
        this.note = note;
        this.date = new Date();
        this.random = new Random();
        this.orderNum = Math.abs(random.nextInt());
        drinks.sellDrinks(orderQtty);
    }

    public Order(Hygiene hygiene, int orderQtty, String note, Date date) {
        this.hygiene = hygiene;
        this.orderQtty = orderQtty;
        this.note = note;
        this.date = new Date();
        this.random = new Random();
        this.orderNum = Math.abs(random.nextInt());
        hygiene.sellItem(orderQtty);
    }

    public Food getFood() {
        return food;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public Hygiene getHygiene() {
        return hygiene;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderQtty(int orderQtty) {
        this.orderQtty = orderQtty;
    }

    public int getOrderQtty() {
        return orderQtty;
    }

    public String orderInfo() {
        return "Order Date: " + getDate() + "\nDelivery note: " + getNote() + "\nOrder Number: " + orderNum
                + "\nOrder Information: \n";
    }
}
