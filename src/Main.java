



public class Main {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        Stock stock1 = new Stock("Honda", "142QVTSIUR", "On-hand");
        Stock stock2 = new Stock("Yamaha", "5NGI5UZ8T2", "Sold");
        Stock stock3 = new Stock("Yamaha", "5NGI5UZ8Y2", "On-hand");
        Stock stock4 = new Stock("Honda", "142QVTSI22", "On-hand");

        // Adding stocks
        system.addStock(stock1);
        system.addStock(stock2);
        system.addStock(stock3);
        system.addStock(stock4);

        // Display inventory
        System.out.println("Inventory:");
        system.displayInventory();

        // Searching stocks by brand
        System.out.println("\nSearching stocks by brand Honda:");
        for (Stock stock : system.searchByBrand("Honda")) {
            System.out.println(stock);
        }

        // Searching stock by engine number
        System.out.println("\nSearching stock with Engine Number 142QVTSIUR:");
        System.out.println(system.searchStock("142QVTSIUR"));

        // Deleting stock
        system.deleteStock("5NGI5UZ8T2");
        System.out.println("\nUpdated Inventory after deletion:");
        system.displayInventory();
    }
}
