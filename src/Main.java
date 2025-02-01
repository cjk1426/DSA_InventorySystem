



public class Main {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        Stock stock1 = new Stock("Honda", "142QVTSIUR", "On-hand");
        Stock stock2 = new Stock("Yamaha", "5NGI5UZ8T2", "Sold");

        // Adding stocks
        system.addStock(stock1);
        system.addStock(stock2);

        // Display inventory
        System.out.println("Inventory:");
        system.displayInventory();

        // Searching stock by engine number
        System.out.println("\nSearching stock with Engine Number 142QVTSIUR:");
        System.out.println(system.searchStock("142QVTSIUR"));

        // Deleting stock
        system.deleteStock("142QVTSIUR");
        System.out.println("\nUpdated Inventory after deletion:");
        system.displayInventory();
    }
}
