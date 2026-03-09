public class Product {
    private String name;
    private double unitPrice;

    /**  Product
     * Creates a Product data record based on
     * inputted name and cost.
     * @param name is the product's name
     * @param unitPrice is the product's cost per unit
     */
    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**  getName
     * Gets a product's name from a data record
     * @return Returns the product's name
     */
    public String getName() {
        return name;
    }

    /**  getCost
     * Gets the cost of a product from a data record
     * @return Returns the cost of the product
     */
    public double getUnitPrice() {
        return unitPrice;
    }
}
