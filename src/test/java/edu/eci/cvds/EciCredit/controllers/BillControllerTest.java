package edu.eci.cvds.EciCredit.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import edu.eci.cvds.EciCredit.models.Bill;
import edu.eci.cvds.EciCredit.services.BillService;

public class BillControllerTest {

    @InjectMocks
    private BillController billController;

    @Mock
    private BillService billService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBillApproved() {
        Bill bill = new Bill();
        bill.setTotalAmount(100.0);

        Bill processedBill = new Bill();
        processedBill.setStatus("APPROVED");
        processedBill.setTotalAmount(100.0);

        when(billService.processBill(any(Bill.class))).thenReturn(processedBill);

        ResponseEntity<Bill> response = billController.createBill(bill);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("APPROVED", response.getBody().getStatus());
        verify(billService, times(1)).processBill(any(Bill.class));
    }

    @Test
    public void testCreateBillDeclined() {
        Bill bill = new Bill();
        bill.setTotalAmount(100.0);

        Bill processedBill = new Bill();
        processedBill.setStatus("DECLINED");
        processedBill.setTotalAmount(100.0);

        when(billService.processBill(any(Bill.class))).thenReturn(processedBill);

        ResponseEntity<Bill> response = billController.createBill(bill);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("DECLINED", response.getBody().getStatus());
        verify(billService, times(1)).processBill(any(Bill.class));
    }

    @Test
    public void testCreateBillException() {
        Bill bill = new Bill();
        bill.setTotalAmount(100.0);

        when(billService.processBill(any(Bill.class))).thenThrow(new RuntimeException("Service error"));

        ResponseEntity<Bill> response = billController.createBill(bill);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("DECLINED", response.getBody().getStatus());
        assertEquals("Error: Service error", response.getBody().getResponseMessage());
        verify(billService, times(1)).processBill(any(Bill.class));
    }

    @Test
    public void testGetBillsByUserId() {
        int userId = 1;
        List<Bill> bills = Arrays.asList(new Bill(), new Bill());

        when(billService.getBillsByUserId(userId)).thenReturn(bills);

        ResponseEntity<List<Bill>> response = billController.getBillsByUserId(userId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(billService, times(1)).getBillsByUserId(userId);
    }
}
