package edu.eci.cvds.EciCredit.models;

public class BillItem {
    private String productName;
    private double unitPrice;
    private int quantity;
    
    public BillItem() {}
    
    public BillItem(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    // Getters and setters
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}