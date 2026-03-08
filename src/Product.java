public class Product {
    private String name;
    private double cost;

    /**  Product
     * Creates a Product data record based on
     * inputted name and cost.
     * @param name is the product's name
     * @param cost is the product's cost
     */
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
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
    public double getCost() {
        return cost;
    }
}
