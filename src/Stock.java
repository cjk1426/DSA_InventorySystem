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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Engine Number: " + engineNumber + ", Status: " + status;
    }
}