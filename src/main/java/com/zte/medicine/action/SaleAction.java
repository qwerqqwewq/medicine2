package com.zte.medicine.action;

import com.google.gson.Gson;
import com.zte.medicine.entity.Sale;
import com.zte.medicine.entity.SaleComment;
import com.zte.medicine.service.SaleCommentService;
import com.zte.medicine.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:54
 * Description:<描述>
 */
@Controller
@RequestMapping("/sale")
@SessionAttributes("sale")
public class SaleAction {
    @Autowired
    private SaleService saleService;
    @Autowired
    private SaleCommentService saleCommentService;

    /**
     * 打开销售界面后显示所有的销售记录
     * @param request
     */
    @RequestMapping("/viewAll")
    public void viewAll(HttpServletRequest request) {
        request.setAttribute("sale",saleService.findAll());
    }

    /**
     * 插入销售信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String add( HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map map = new HashMap(50);
        Gson gson =new Gson();

        Sale sale = new Sale();
        SaleComment saleComment = new SaleComment();
        sale.setAmount(Double.parseDouble(request.getParameter("Amount")));
        sale.setCustomerCode(request.getParameter("CustomerCode"));
        sale.setSaleDate(Timestamp.valueOf(request.getParameter("SaleDate")));
        sale.setSaleNum(Integer.parseInt(request.getParameter("SaleNum")));
        sale.setUserId(Integer.parseInt(request.getParameter("UserId")));
        saleComment.setAmount(Double.parseDouble(request.getParameter("Amount2")));
        saleComment.setMedicineCode(request.getParameter("MedicineCode"));
        saleComment.setNumber(Integer.parseInt(request.getParameter("Number")));
        saleComment.setPrice(request.getParameter("Price"));

        try {
            saleService.addSale(sale);
            saleCommentService.addSaleComment(saleComment);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "插入失败");
        }
        return gson.toJson(map);
    }




    /**
     * 条件查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("advancedSearch")
    public String advancedSearch( HttpServletRequest request, HttpServletResponse response) throws Exception {
        String amount2 =  request.getParameter("amount2");

        Sale sale = new Sale();
        if (request.getParameter("SaleNum")!=null|| request.getParameter("UserId")!=null|| request.getParameter("CustomerCode")!=null|| request.getParameter("SaleDate")!=null|| request.getParameter("amount")!=null|| amount2!=null) {
            sale = saleService.findSale(Integer.parseInt(request.getParameter("SaleNum")), Integer.parseInt(request.getParameter("UserId")),request.getParameter("CustomerCode"),Timestamp.valueOf(request.getParameter("SaleDate")),Double.valueOf(request.getParameter("amount")),amount2);
            request.setAttribute("sale",sale);
            return "success";
        } else {
            return "fail";
        }

    }



}
