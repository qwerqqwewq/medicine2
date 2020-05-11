package com.zte.medicine.dao;

import com.zte.medicine.entity.Customer;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:46
 * Description:<描述>
 */
public interface CustomerDao {
    /**
     * 添加客户信息
     * @param customer
     * @return
     */
    public void insertCustomer(Customer customer);

    /**
     * 根据客户编码查询客户信息
     * @param code
     * @return
     */
    public Customer selectCustomerByCode(String  code);

    /**
     * 根据客户姓名查询客户信息
     * @param name
     * @return
     */
    public Customer selectCustomerByName(String name);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    public void updateCustomer(Customer customer);

    /**
     * 根据客户编码删除客户
     * @param code
     * @return
     */
    public void deleteCustomerByCode(String code);
}
