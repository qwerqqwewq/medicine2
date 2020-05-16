package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Medicine;
import com.zte.medicine.entity.Stock;
import com.zte.medicine.entity.StockComment;
import com.zte.medicine.service.MedicineService;
import com.zte.medicine.service.StockCommentService;
import com.zte.medicine.service.StockService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:53
 * Description:<描述>
 */
@Controller
@RequestMapping("/stock")
@SessionAttributes("stock")
public class StockAction extends ActionSupport {
    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    @Autowired
    private StockService stockService;
    private StockCommentService stockCommentService;

    @Autowired
    MedicineService medicineService;
    //
    ///**
    // * 打开库存界面后显示所有的库存记录
    // * @param request
    // */
    ////public void viewAll(HttpServletRequest request) {
    ////    request.setAttribute("sale",saleService.findAll());
    ////}

    /**
     * 插入库存信息
     * @return
     * @throws Exception
     */
    public String add() throws Exception{


        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Map map = new HashMap(50);
        Gson gson =new Gson();

        Stock stock = new Stock();
        StockComment stockComment = new StockComment();

        stock.setStockNum(Integer.parseInt(request.getParameter("StockNum")));
        stock.setUserId(Integer.parseInt(request.getParameter("UserId")));
        stock.setWorkDate(Timestamp.valueOf(request.getParameter("WorkDate")));
        stock.setWorkType(request.getParameter("WorkType"));
        stockComment.setStockNum(stock.getStockNum());
        stockComment.setMedicineCode(request.getParameter("MedicineCode"));
        stockComment.setWorkNum(Integer.parseInt(request.getParameter("WorkNum")));
        stockComment.setNumber(Integer.parseInt(request.getParameter("Number"))+stockComment.getWorkNum());
        Medicine medicine = new Medicine();
        medicine=medicineService.findMedicineByCode(stockComment.getMedicineCode());
        stockComment.setAmount(Double.parseDouble(medicine.getPrice())*Double.valueOf(stockComment.getNumber()));


        try {
            stockService.addStock(stock);
            stockCommentService.addStockComment(stockComment);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "插入失败");
        }
        return gson.toJson(map);
    }




    /**
     * 条件查询
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //public ActionForward advancedSearch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //    String amount2 =  request.getParameter("amount2");
    //    SaleForm saleForm = (SaleForm) form;
    //    Sale sale = new Sale();
    //    if (saleForm!=null) {
    //        sale = saleService.findSale(saleForm.getSaleNum(), saleForm.getUserId(),saleForm.getCustomerCode(),saleForm.getSaleDate(),sale.getAmount(),amount2);
    //        request.setAttribute("sale",sale);
    //        return mapping.findForward("success");
    //    } else {
    //        return mapping.findForward("fail");
    //    }
    //
    //}

}
