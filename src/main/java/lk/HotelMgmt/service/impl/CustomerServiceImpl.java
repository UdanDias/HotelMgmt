package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.CustomerDao;
import lk.HotelMgmt.dto.CustomerDTO;
import lk.HotelMgmt.entity.CustomerEntity;
import lk.HotelMgmt.service.CustomerService;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustId(UtilData.generateCustomerId());
        CustomerEntity customerEntity=customerDao.findById(customerDTO.getCustId()).orElseThrow(()->new RuntimeException("Customer Not Found"));
        customerDao.save(customerEntity);
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
