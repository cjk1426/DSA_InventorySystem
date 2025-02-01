class Stock {
    private String brand;
    private String engineNumber;
    private String status;

    public Stock(String brand, String engineNumber, String status) {
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Engine Number: " + engineNumber + ", Status: " + status;
    }
}
