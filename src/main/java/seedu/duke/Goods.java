package seedu.duke;

/*
 * Class to handle the Goods information
 *
 * FOR NOW id we can manually input?
 * Ideas - id can track and give to the goods we add automatically
 */
public class Goods {
    private int id;
    private String name;
    private int quantity;
    private String description;

    public Goods(int id, String name, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return String.format("%s (%s)", name, description);
    }
}