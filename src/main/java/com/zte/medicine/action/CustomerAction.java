package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Customer;
import com.zte.medicine.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:53
 * Description:<描述>
 */
@Controller("CustomerAction")
@Scope("prototype")
@RequestMapping("/customer")
@SessionAttributes("customer")
public class CustomerAction extends ActionSupport {
    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    private CustomerService customerService;

    /**
     * 添加顾客信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String addCustomer( HttpServletRequest request)throws Exception{

        Map map = new HashMap(50);
        Gson gson =new Gson();

        Customer customer = new Customer();

        if (customerService.findCustomerByName(request.getParameter("CustomerName"))!=null) {
            customer.setCity(request.getParameter("City"));
            customer.setCustomerCode(request.getParameter("CustomerCode"));
            customer.setCustomerName(request.getParameter("CustomerName"));
            customer.setCustomerTel(Integer.parseInt(request.getParameter("CustomerTel")));

            try {
                customerService.addCustomer(customer);
                map.put("msg", "添加成功");
            } catch (Exception e) {
                map.put("msg", "插入失败");
            }
        }else {
            map.put("msg", "顾客信息已存在");
        }
        return gson.toJson(map);
    }

    /**
     * 修改客户信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateCustomer(HttpServletRequest request)throws Exception{
        Map map = new HashMap(50);
        Gson gson =new Gson();

        Customer customer = new Customer();

        customer.setCity(request.getParameter("City"));
        customer.setCustomerCode(request.getParameter("CustomerCode"));
        customer.setCustomerName(request.getParameter("CustomerName"));
        customer.setCustomerTel(Integer.parseInt(request.getParameter("CustomerTel")));

        try {
            customerService.modifyCustomer(customer);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "插入失败");
        }

        return gson.toJson(map);
    }

    /**
     * 根据姓名显示客户信息
     */
    @RequestMapping("/viewAll")
    public void viewByName(HttpServletRequest request){

        customerService.findCustomerByName(request.getParameter("CustomerName"));
    }

}
