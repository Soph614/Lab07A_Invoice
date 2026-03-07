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

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public void setCalculatedTotal(double calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }


    /**
     * toCSV
     * Takes data from a Product arraylist and
     * inputs it into a comma-separated value.
     *
     * @return Returns a csv record with the product's
     * ID, name, description, and cost.
     */
    public String toTabularAlignment() {
        return getItem() + "\t\t" + getQuantity() + "\t" + getUnitPrice() + "\t" + getCalculatedTotal();
    }

    /**  toJSON
     * Converts an arraylist of product data into a JSON data string
     * @return Returns a JSON data String with product data
     */
}