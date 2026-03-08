public class LineItem {
    private String item;
    private int quantity;
    private double unitPrice;
    private double calculatedTotal;

    public LineItem(String item, int quantity, double unitPrice, double calculatedTotal) {
        this.item = item;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.calculatedTotal = calculatedTotal;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public String toTabularAlignment() {
        return item + "\t\t" + quantity + "\t" + unitPrice + "\t" + calculatedTotal;
    }
}