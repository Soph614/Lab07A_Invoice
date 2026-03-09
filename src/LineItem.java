public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getItem() {
        return product.getName();
    }

    public double getUnitPrice() {
        return product.getUnitPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCalculatedTotal() {
        return getUnitPrice() * quantity;
    }

    public String lineItemToTabularAlignment() {
        return getItem() + "\t\t" + getQuantity() + "\t" + getUnitPrice() + "\t" + getCalculatedTotal();
    }
}