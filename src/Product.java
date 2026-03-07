public class Product {
    private String name;
    double cost;

    /**  getName
     * Gets a product's name from a data record
     * @return Returns the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes a product's name to an inputted String value
     * @param name is what the product's name is supposed to change to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**  getCost
     * Gets the cost of a product from a data record
     * @return Returns the cost of the product
     */
    public double getCost() {
        return cost;
    }

    /**  setCost
     * Changes a product's cost to an inputted value
     * @param cost is what the cost is supposed to change to
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**  toString
     * Converts product data into a human-readable String
     * @return Returns a human-readable string of product data
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                "cost=" + cost +
                '}';
    }

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

    /** getNameAlignedWithCost
     * Takes data from a Product arraylist and
     * inputs it into a nicely aligned table.
     * @return Returns a record with
     * the product's name and cost.
     */
    public String getNameAlignedWithCost() {
        return getName() + "\t\t" + getCost();
    }
}
