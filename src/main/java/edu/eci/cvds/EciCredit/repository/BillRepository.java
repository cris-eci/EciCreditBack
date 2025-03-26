package edu.eci.cvds.EciCredit.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.cvds.EciCredit.models.Bill;

public interface BillRepository extends MongoRepository<Bill, String> {
    public List<Bill> findAll();
    public Bill findById(int id);
}