package com.zte.medicine.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.service.SaleCommentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author:helloboy
 * Date:2020-04-21 20:26
 * Description:<描述>
 */
@Controller
@RequestMapping("/saleComment")
@SessionAttributes("saleComment")
public class SaleCommentAction extends ActionSupport {

    public SaleCommentService getSaleCommentService() {
        return saleCommentService;
    }

    public void setSaleCommentService(SaleCommentService saleCommentService) {
        this.saleCommentService = saleCommentService;
    }

    @Autowired
    SaleCommentService saleCommentService;
    /**
     * 显示所有的详细销售记录
     */
    public void viewAll() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("sale",saleCommentService.findSaleCommentAll());
    }

    /**
     * 根据销售编码查询具体的销售信息
     * @throws Exception
     */
    public void viewByName()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.setAttribute("saleComment",saleCommentService.findSaleCommentByNum(request.getParameter("SaleNum")));
    }

    /**
     * 根据药品编码查询具体的销售信息
     * @throws Exception
     */
    public void viewByCode()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.setAttribute("saleComment",saleCommentService.findSaleCommentByCode(request.getParameter("MedicineCode")));
    }

}
