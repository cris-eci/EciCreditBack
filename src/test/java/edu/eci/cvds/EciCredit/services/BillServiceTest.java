package edu.eci.cvds.EciCredit.services;
import edu.eci.cvds.EciCredit.models.Bill;
import edu.eci.cvds.EciCredit.models.BillItem;
import edu.eci.cvds.EciCredit.repository.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;





public class BillServiceTest {
    
    @Mock
    private BillRepository billRepository;
    
    @InjectMocks
    private BillService billService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testProcessValidBill() {
        // Create test data
        Bill bill = new Bill();
        bill.setUserId(1);
        bill.setTotalAmount(100.0);
        
        List<BillItem> items = new ArrayList<>();
        BillItem item1 = new BillItem();
        item1.setUnitPrice(50.0);
        item1.setQuantity(1);
        
        BillItem item2 = new BillItem();
        item2.setUnitPrice(25.0);
        item2.setQuantity(2);
        
        items.add(item1);
        items.add(item2);
        bill.setItems(items);
        
        // Mock repository behavior
        when(billRepository.save(any(Bill.class))).thenReturn(bill);
        
        // Call the service method
        Bill result = billService.processBill(bill);
        
        // Verify the results
        assertEquals("APPROVED", result.getStatus());
        assertEquals("Transaction processed successfully", result.getResponseMessage());
        verify(billRepository, times(1)).save(bill);
    }
    
    @Test
    public void testProcessInvalidBill() {
        // Create test data with incorrect total
        Bill bill = new Bill();
        bill.setUserId(1);
        bill.setTotalAmount(110.0);  // Incorrect total
        
        List<BillItem> items = new ArrayList<>();
        BillItem item = new BillItem();
        item.setUnitPrice(50.0);
        item.setQuantity(2);
        items.add(item);
        bill.setItems(items);
        
        // Mock repository behavior
        when(billRepository.save(any(Bill.class))).thenReturn(bill);
        
        // Call the service method
        Bill result = billService.processBill(bill);
        
        // Verify the results
        assertEquals("DECLINED", result.getStatus());
        assertEquals("Total amount doesn't match the sum of items", result.getResponseMessage());
        verify(billRepository, times(1)).save(bill);
    }
    
    @Test
    public void testGetBillsByUserId() {
        // Create test data
        int userId = 1;
        List<Bill> expectedBills = Arrays.asList(new Bill(), new Bill());
        
        // Mock repository behavior
        when(billRepository.findByUserId(userId)).thenReturn(expectedBills);
        
        // Call the service method
        List<Bill> result = billService.getBillsByUserId(userId);
        
        // Verify the results
        assertEquals(expectedBills, result);
        verify(billRepository, times(1)).findByUserId(userId);
    }
}
