package com.zouhari.billingservice.web;


import com.zouhari.billingservice.entities.Bill;
import com.zouhari.billingservice.feign.CustomerServiceRestClient;
import com.zouhari.billingservice.feign.InventoryServiceRestClient;
import com.zouhari.billingservice.model.Customer;
import com.zouhari.billingservice.repository.BillRepository;
import com.zouhari.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;
    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi-> {
            pi.setProduct(inventoryServiceRestClient.getProduct(pi.getProductId()));

        });
        return bill;
    }
}
