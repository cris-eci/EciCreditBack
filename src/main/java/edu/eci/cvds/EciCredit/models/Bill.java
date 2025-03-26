package edu.eci.cvds.EciCredit.models;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bills")
public class Bill {
    @Id
    private String id;
    private int userId;
    private Date purchaseDate;
    private List<BillItem> items;
    private double totalAmount;
    private String status; // "APPROVED" or "DECLINED"
    private String responseMessage;
    
    // Constructors, getters and setters
    public Bill() {}
    
    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
    
    public List<BillItem> getItems() { return items; }
    public void setItems(List<BillItem> items) { this.items = items; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getResponseMessage() { return responseMessage; }
    public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }
}