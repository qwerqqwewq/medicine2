package com.zte.medicine.action;

import com.zte.medicine.service.SaleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:helloboy
 * Date:2020-04-21 20:26
 * Description:<描述>
 */
@Controller
@RequestMapping("/saleComment")
@SessionAttributes("saleComment")
public class SaleCommentAction {

    @Autowired
    SaleCommentService saleCommentService;
    /**
     * 显示所有的详细销售记录
     * @param request
     */
    @RequestMapping("/viewAll")
    public void viewAll(HttpServletRequest request) {
        request.setAttribute("sale",saleCommentService.findSaleCommentAll());
    }

    /**
     * 根据销售编码查询具体的销售信息
     * @param request
     * @throws Exception
     */
    @RequestMapping("/viewByName")
    public void viewByName(HttpServletRequest request)throws Exception{
        request.setAttribute("saleComment",saleCommentService.findSaleCommentByNum(request.getParameter("SaleNum")));
    }

    /**
     * 根据药品编码查询具体的销售信息
     * @param request
     * @throws Exception
     */
    @RequestMapping("/viewByCode")
    public void viewByCode(HttpServletRequest request)throws Exception{
        request.setAttribute("saleComment",saleCommentService.findSaleCommentByCode(request.getParameter("MedicineCode")));
    }

}
