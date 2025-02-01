import java.util.HashMap;
import java.util.LinkedList;

class InventorySystem {
    // HashMap to store inventory by engine number
    private HashMap<String, Stock> inventoryMap;
    // LinkedList to maintain ordered inventory (by brand, for example)
    private LinkedList<Stock> inventoryList;

    public InventorySystem() {
        inventoryMap = new HashMap<>();
        inventoryList = new LinkedList<>();
    }

    // Add Stock to HashMap and LinkedList
    public void addStock(Stock stock) {
        inventoryMap.put(stock.getEngineNumber(), stock);
        inventoryList.add(stock); // Add to LinkedList (order maintained)
        sortInventory(); // Sort inventory if needed (e.g., by brand)
    }

    // Search Stock by Engine Number
    public Stock searchStock(String engineNumber) {
        return inventoryMap.get(engineNumber);
    }

    // Delete Stock by Engine Number
    public void deleteStock(String engineNumber) {
        Stock stock = inventoryMap.remove(engineNumber);
        if (stock != null) {
            inventoryList.remove(stock);
        }
    }

    // Sort Inventory by Brand (using Merge Sort)
    public void sortInventory() {
        mergeSort(inventoryList, 0, inventoryList.size() - 1);
    }

    private void mergeSort(LinkedList<Stock> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(LinkedList<Stock> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        LinkedList<Stock> leftList = new LinkedList<>();
        LinkedList<Stock> rightList = new LinkedList<>();

        for (int i = 0; i < n1; ++i) {
            leftList.add(list.get(left + i));
        }
        for (int i = 0; i < n2; ++i) {
            rightList.add(list.get(mid + 1 + i));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getBrand().compareTo(rightList.get(j).getBrand()) <= 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    // Display Inventory
    public void displayInventory() {
        for (Stock stock : inventoryList) {
            System.out.println(stock);
        }
    }
}