package com.zte.medicine.service.impl;

import com.zte.medicine.dao.CustomerDao;
import com.zte.medicine.entity.Customer;
import com.zte.medicine.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:helloboy
 * Date:2020-02-07 17:20
 * Description:<描述>
 */
@Service("CustomerService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;


    @Override
    public void addCustomer(Customer customer) {
        customerDao.insertCustomer(customer);
    }

    @Override
    public List<Customer> findCustomerByCode(String code) {
        return customerDao.selectCustomerByCode(code);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerDao.selectCustomerByName(name);
    }

    @Override
    public void modifyCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void removeCustomerByCode(String code) {
        customerDao.deleteCustomerByCode(code);
    }
}
