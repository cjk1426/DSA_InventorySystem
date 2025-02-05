import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        // Adding stocks
        system.addStock(new Stock("Honda", "123456789", "On-hand"));
        system.addStock(new Stock("Honda", "142QVTSIUR", "On-hand"));
        system.addStock(new Stock("Yamaha", "5NGI5UZ8T2", "Sold"));
        system.addStock(new Stock("Kawasaki", "392XSUBMUW", "On-hand"));
        system.addStock(new Stock("Honda", "95AN3AWVF4", "On-hand"));



        // Display inventory
        System.out.println("Inventory:");
        system.displayInventory();


                // Update a stock item
                System.out.println("\nUpdating stock with Engine Number 142QVTSIUR...");
                system.updateStock("142QVTSIUR", "Honda", "Sold");
                system.displayInventory();

        // Searching stock by engine number
        System.out.println("\nSearching stock with Engine Number 142QVTSIUR:");
        System.out.println(system.searchStock("142QVTSIUR"));

        // Searching stocks by brand
        System.out.println("\nSearching stocks by brand Honda:");
        LinkedList<Stock> hondaStocks = system.searchByBrand("Honda");
        for (Stock stock : hondaStocks) {
            System.out.println(stock);
        }

        // Deleting stock by engine number
        system.deleteStockByEngineNumber("142QVTSIUR");
        System.out.println("\nUpdated Inventory after deleting Engine Number 142QVTSIUR:");
        system.displayInventory();

        // Deleting stocks by brand
        system.deleteStockByBrand("Honda");
        System.out.println("\nUpdated Inventory after deleting all stocks with brand Honda:");
        system.displayInventory();

        // Deleting stocks by status
        system.deleteStockByStatus("Sold");
        System.out.println("\nUpdated Inventory after deleting all sold stocks:");
        system.displayInventory();



        

    }
}
