package com.zte.medicine.service;

import com.zte.medicine.entity.Customer;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:14
 * Description:<描述>
 */
public interface CustomerService {

    /**
     * 添加新客户
     * @param customer
     */
    public void addCustomer(Customer customer);

    /**
     * 根据客户编码查询客户信息
     * @param code
     * @return
     */
    public List<Customer> findCustomerByCode(String  code);

    /**
     * 根据客户姓名查询客户信息
     * @param name
     * @return
     */
    public List<Customer> findCustomerByName(String name);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    public void modifyCustomer(Customer customer);

    /**
     * 根据客户编码删除客户
     * @param code
     * @return
     */
    public void removeCustomerByCode(String code);
}
