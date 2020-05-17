package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Customer;
import com.zte.medicine.service.CustomerService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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
     * @return
     * @throws Exception
     */
    public String addCustomer()throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

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
                out.print("<script>alert('添加成功！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/customer_addCustomer.action'</script>");
                out.flush();
                out.close();
                return "success";
            } catch (Exception e) {
                out.print("<script>alert('添加失败！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/customer_addCustomer.action'</script>");
                out.flush();
                out.close();
                return "fail";
            }
        }else {
            out.print("<script>alert('顾客信息已存在！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/customer_addCustomer.action'</script>");
            out.flush();
            out.close();
            return "back";
        }

    }

    /**
     * 修改客户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateCustomer()throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


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
    public void viewByName() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<Customer> list = customerService.findCustomerByName(request.getParameter("CustomerName"));
        Customer customer = list.get(0);
        request.setAttribute("City", customer.getCity());
        request.setAttribute("CustomerCode", customer.getCustomerCode());
        request.setAttribute("CustomerName",customer.getCustomerName());
        request.setAttribute("CustomerTel",customer.getCustomerTel());
    }

}
