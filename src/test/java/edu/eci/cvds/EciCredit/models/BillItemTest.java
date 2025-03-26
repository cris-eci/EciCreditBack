package edu.eci.cvds.EciCredit.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class BillItemTest {
    
    @Test
    public void testConstructorWithParameters() {
        BillItem item = new BillItem("Laptop", 1200.0, 2);
        assertEquals("Laptop", item.getProductName());
        assertEquals(1200.0, item.getUnitPrice(), 0.001);
        assertEquals(2, item.getQuantity());
    }
    
    @Test
    public void testDefaultConstructor() {
        BillItem item = new BillItem();
        assertNull(item.getProductName());
        assertEquals(0.0, item.getUnitPrice(), 0.001);
        assertEquals(0, item.getQuantity());
    }
    
    @Test
    public void testSetAndGetProductName() {
        BillItem item = new BillItem();
        item.setProductName("Mouse");
        assertEquals("Mouse", item.getProductName());
    }
    
    @Test
    public void testSetAndGetUnitPrice() {
        BillItem item = new BillItem();
        item.setUnitPrice(25.5);
        assertEquals(25.5, item.getUnitPrice(), 0.001);
    }
    
    @Test
    public void testSetAndGetQuantity() {
        BillItem item = new BillItem();
        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }
    
    @Test
    public void testGetTotalPrice() {
        BillItem item = new BillItem("Keyboard", 50.0, 3);
        assertEquals(150.0, item.getTotalPrice(), 0.001);
    }
    
    @Test
    public void testGetTotalPriceWithZeroQuantity() {
        BillItem item = new BillItem("Monitor", 200.0, 0);
        assertEquals(0.0, item.getTotalPrice(), 0.001);
    }
}
