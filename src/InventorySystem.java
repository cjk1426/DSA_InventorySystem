import java.util.LinkedList;

class InventorySystem {
    private LinkedList<Stock> inventoryList;

    public InventorySystem() {
        inventoryList = new LinkedList<>();
    }

    // Add Stock to the LinkedList
    public void addStock(Stock stock) {
        inventoryList.add(stock);
        sortInventory(); // Sort inventory after adding
    }

    // Search Stock by Engine Number
    public Stock searchStock(String engineNumber) {
        for (Stock stock : inventoryList) {
            if (stock.getEngineNumber().equals(engineNumber)) {
                return stock;
            }
        }
        return null; // Return null if not found
    }

    // Search Stocks by Brand
    public LinkedList<Stock> searchByBrand(String brand) {
        LinkedList<Stock> result = new LinkedList<>();
        for (Stock stock : inventoryList) {
            if (stock.getBrand().equalsIgnoreCase(brand)) {
                result.add(stock);
            }
        }
        return result;
    }

    // Delete Stock by Engine Number
    public void deleteStockByEngineNumber(String engineNumber) {
        inventoryList.removeIf(stock -> stock.getEngineNumber().equals(engineNumber));
    }

    // Delete Stocks by Brand
    public void deleteStockByBrand(String brand) {
        inventoryList.removeIf(stock -> stock.getBrand().equalsIgnoreCase(brand));
    }

    // Delete Stocks by Status
    public void deleteStockByStatus(String status) {
        inventoryList.removeIf(stock -> stock.getStatus().equalsIgnoreCase(status));
    }

    // Update Stock by Engine Number
    public void updateStock(String engineNumber, String newBrand, String newStatus) {
        Stock stock = searchStock(engineNumber);
        if (stock != null) {
            stock.setBrand(newBrand);
            stock.setStatus(newStatus);
            sortInventory(); // Re-sort the inventory after update
        } else {
            System.out.println("Stock with Engine Number " + engineNumber + " not found.");
        }
    }
    
    // Sort Inventory by Brand using Merge Sort
    public void sortInventory() {
        if (!inventoryList.isEmpty()) {
            inventoryList = mergeSort(inventoryList);
        }
    }

    private LinkedList<Stock> mergeSort(LinkedList<Stock> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        LinkedList<Stock> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Stock> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private LinkedList<Stock> merge(LinkedList<Stock> left, LinkedList<Stock> right) {
        LinkedList<Stock> merged = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst().getBrand().compareTo(right.getFirst().getBrand()) <= 0) {
                merged.add(left.removeFirst());
            } else {
                merged.add(right.removeFirst());
            }
        }

        merged.addAll(left);
        merged.addAll(right);

        return merged;
    }

    // Display Inventory
    public void displayInventory() {
        if (inventoryList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Stock stock : inventoryList) {
                System.out.println(stock);
            }
        }
    }
}