package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.BookingDao;
import lk.HotelMgmt.dao.CustomerDao;
import lk.HotelMgmt.dto.CustomerDTO;
import lk.HotelMgmt.entity.BookingEntity;
import lk.HotelMgmt.entity.CustomerEntity;
import lk.HotelMgmt.exceptions.CustomerNotFoundException;
import lk.HotelMgmt.service.CustomerService;
import lk.HotelMgmt.util.EntityDTOConvert;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    private final BookingDao bookingDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustId(UtilData.generateCustomerId());
        CustomerEntity customerEntity=entityDTOConvert.convertCustomerDTOToCustomerEntity(customerDTO);
        customerDao.save(customerEntity);
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        CustomerEntity customerEntity=customerDao.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
        List<BookingEntity> bookingEntity=bookingDao.findAll();
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setNIC(customerDTO.getNIC());
        customerEntity.setDOB(customerDTO.getDOB());
        customerEntity.setBookingId(bookingEntity);
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setCustName(customerDTO.getCustName());
    }

    @Override
    public void deleteCustomer(String customerId) {
        CustomerEntity customerEntity = customerDao.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        customerDao.delete(customerEntity);
    }
    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        CustomerEntity customerEntity=customerDao.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        return entityDTOConvert.convertCustomerEntityToCustomerDTO(customerEntity);

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return entityDTOConvert.convertCustomerEntityListToCustomerDTOList(customerDao.findAll());
    }
}
