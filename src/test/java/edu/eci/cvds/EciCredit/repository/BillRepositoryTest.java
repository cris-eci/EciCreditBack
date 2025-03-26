package edu.eci.cvds.EciCredit.repository;

import edu.eci.cvds.EciCredit.models.Bill;
import edu.eci.cvds.EciCredit.models.BillItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;
    
    @BeforeEach
    void setUp() {
        // Clear previous test data
        billRepository.deleteAll();
        
        // Setup test bills
        Bill bill1 = createBill(1);
        Bill bill2 = createBill(2);
        Bill bill3 = createBill(3);
        
        billRepository.save(bill1);
        billRepository.save(bill2);
        billRepository.save(bill3);
    }
    
    @Test
    void testFindAll() {
        List<Bill> bills = billRepository.findAll();
        assertEquals(3, bills.size());
    }

    
    @Test
    void testFindByUserId_WhenBillsExist_ShouldReturnBills() {
        // Create two bills for same user
        Bill userBill1 = createBill(100);
        Bill userBill2 = createBill(100);
        billRepository.save(userBill1);
        billRepository.save(userBill2);
        
        List<Bill> userBills = billRepository.findByUserId(100);
        assertEquals(2, userBills.size());
    }
    
    @Test
    void testFindByUserId_WhenNoBills_ShouldReturnEmptyList() {
        List<Bill> userBills = billRepository.findByUserId(999);
        assertTrue(userBills.isEmpty());
    }
    
    private Bill createBill(int userId) {
        Bill bill = new Bill();
        bill.setUserId(userId);
        bill.setPurchaseDate(new Date());
        
        List<BillItem> items = new ArrayList<>();
        BillItem item1 = new BillItem();
        item1.setProductName("Test Product");
        item1.setUnitPrice(10.0);
        item1.setQuantity(2);
        items.add(item1);
        
        bill.setItems(items);
        bill.setTotalAmount(20.0);
        bill.setStatus("APPROVED");
        bill.setResponseMessage("Test transaction");
        
        return bill;
    }
}