package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.*;
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
import java.util.List;
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

    @Autowired
    private StockCommentService stockCommentService;

    @Autowired
    private MedicineService medicineService;

    /**
     * 打开库存界面后显示所有的库存记录
     */
    public void viewAll(HttpServletRequest request) {
        request.setAttribute("stocks",stockService.findAll());
    }


    /**
     * 添加库存页面
     * @return
     */
    public String addPage(){
        return "add";
    }

    public String searchPage(){
        return "search";
    }

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
        User user = (User)request.getSession().getAttribute("user");
        Integer id = user.getId();
        stock.setUserId(id);
        stock.setWorkDate(new Timestamp(System.currentTimeMillis()));
        stock.setWorkType(request.getParameter("WorkType"));
        stockComment.setStockNum(stock.getStockNum());
        String medicineName = request.getParameter("MedicineName");
        Medicine medicine = new Medicine();
        medicine = medicineService.findMedicineByName(medicineName).get(0);

        stockComment.setMedicineCode(medicine.getMedicineCode());
        stockComment.setWorkNum(Integer.parseInt(request.getParameter("WorkNum")));
        Integer integer = 0;
        String number = request.getParameter("Number");
        if (number!=null&&"".equalsIgnoreCase(number)) {
            integer = Integer.parseInt(number);
        }
        integer = integer+stockComment.getWorkNum();
        stockComment.setNumber(integer);
        //Medicine medicine = new Medicine();
        //medicine=medicineService.findMedicineByCode(stockComment.getMedicineCode()).get(0);
        stockComment.setAmount(Double.parseDouble(medicine.getPrice())*Double.valueOf(stockComment.getNumber()));



        try {
            stockService.addStock(stock);
            stockCommentService.addStockComment(stockComment);
            out.print("<script>alert('添加成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/stock_stockAddPage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('添加失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/stock_stockAddPage.action'</script>");
            out.flush();
            out.close();
        }
        return "fail";
    }


    public String stockSearch() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String medicineName = request.getParameter("MedicineName");
        Medicine medicine = new Medicine();
        medicine =medicineService.findMedicineByName(medicineName).get(0);
        String medicineCode = medicine.getMedicineCode();
        List<StockComment> stockComments = stockCommentService.findStockCommentByCode(medicineCode);
        request.setAttribute("stockComments", stockComments);

        return "search";
    }

    /**
     * 库存查询页面
     * @return
     */
    public String stockSearchPage(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("stockComments",stockCommentService.findStockCommentAll());
        return "search";
    }

    /**
     * 库存添加页面
     * @return
     */
    public String stockAddPage(){
        return "add";
    }


    public String detailInf() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String stockNum = request.getParameter("StockNum");
        Integer integer = Integer.parseInt(stockNum);
        List<StockComment> stockComments = stockCommentService.findStockCommentByNum(integer);
        request.setAttribute("stockComments",stockComments);
        return "detail";
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
