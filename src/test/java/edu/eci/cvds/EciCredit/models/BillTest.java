package edu.eci.cvds.EciCredit.models;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



public class BillTest {
    
    @Test
    public void testDefaultConstructor() {
        Bill bill = new Bill();
        assertNotNull(bill);
    }
    
    @Test
    public void testIdGetterAndSetter() {
        Bill bill = new Bill();
        String id = "bill123";
        bill.setId(id);
        assertEquals(id, bill.getId());
    }
    
    @Test
    public void testUserIdGetterAndSetter() {
        Bill bill = new Bill();
        int userId = 12345;
        bill.setUserId(userId);
        assertEquals(userId, bill.getUserId());
    }
    
    @Test
    public void testPurchaseDateGetterAndSetter() {
        Bill bill = new Bill();
        Date purchaseDate = new Date();
        bill.setPurchaseDate(purchaseDate);
        assertEquals(purchaseDate, bill.getPurchaseDate());
    }
    
    @Test
    public void testItemsGetterAndSetter() {
        Bill bill = new Bill();
        List<BillItem> items = new ArrayList<>();
        bill.setItems(items);
        assertEquals(items, bill.getItems());
    }
    
    @Test
    public void testTotalAmountGetterAndSetter() {
        Bill bill = new Bill();
        double totalAmount = 99.99;
        bill.setTotalAmount(totalAmount);
        assertEquals(totalAmount, bill.getTotalAmount(), 0.001);
    }
    
    @Test
    public void testStatusGetterAndSetter() {
        Bill bill = new Bill();
        String status = "APPROVED";
        bill.setStatus(status);
        assertEquals(status, bill.getStatus());
        
        bill.setStatus("DECLINED");
        assertEquals("DECLINED", bill.getStatus());
    }
    
    @Test
    public void testResponseMessageGetterAndSetter() {
        Bill bill = new Bill();
        String message = "Payment successful";
        bill.setResponseMessage(message);
        assertEquals(message, bill.getResponseMessage());
    }
    
    @Test
    public void testCompleteScenario() {
        Bill bill = new Bill();
        bill.setId("invoice123");
        bill.setUserId(1001);
        Date now = new Date();
        bill.setPurchaseDate(now);
        
        List<BillItem> items = new ArrayList<>();
        bill.setItems(items);
        
        bill.setTotalAmount(150.75);
        bill.setStatus("APPROVED");
        bill.setResponseMessage("Transaction completed successfully");
        
        assertEquals("invoice123", bill.getId());
        assertEquals(1001, bill.getUserId());
        assertEquals(now, bill.getPurchaseDate());
        assertEquals(items, bill.getItems());
        assertEquals(150.75, bill.getTotalAmount(), 0.001);
        assertEquals("APPROVED", bill.getStatus());
        assertEquals("Transaction completed successfully", bill.getResponseMessage());
    }
}
