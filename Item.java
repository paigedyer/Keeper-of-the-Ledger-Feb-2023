public class Item {
    private boolean inInventory;
    private int weight;
    private String name;

    public Item(boolean inInventory, int weight, String name) {
        this.inInventory = inInventory;
        this.weight = weight;
        this.name = name;
    }

    public void setWeight(int weight) { this.weight = weight; }

    public int getWeight() {
        return weight;
    }

    public void setInInventory(boolean inInventory) {
        this.inInventory = inInventory;
    }

    public boolean isInInventory() {
        return inInventory;
    }

    public void setName(String name) { this.name = name;}

    public String getName() { return name; }
}
