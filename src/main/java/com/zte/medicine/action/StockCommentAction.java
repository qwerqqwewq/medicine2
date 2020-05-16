package com.zte.medicine.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.service.StockCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:helloboy
 * Date:2020-04-21 20:25
 * Description:<描述>
 */
@Controller
@RequestMapping("/stockComment")
@SessionAttributes("StockComment")
public class StockCommentAction extends ActionSupport {
    public StockCommentService getStockCommentService() {
        return stockCommentService;
    }

    public void setStockCommentService(StockCommentService stockCommentService) {
        this.stockCommentService = stockCommentService;
    }

    @Autowired
    StockCommentService stockCommentService;
    /**
     * 显示所有的详细销售记录
     * @param request
     */
    public void viewAll(HttpServletRequest request) {
        request.setAttribute("sale",stockCommentService.findStockCommentAll());
    }

    /**
     * 根据操作编码查询具体的库存信息
     * @param request
     * @throws Exception
     */
    public void viewByName(HttpServletRequest request)throws Exception{
        request.setAttribute("saleComment",stockCommentService.findStockCommentByNum(Integer.parseInt(request.getParameter("StockNum"))));
    }

    /**
     * 根据药品编码查询具体的库存信息
     * @param request
     * @throws Exception
     */
    public void viewByCode(HttpServletRequest request)throws Exception{
        request.setAttribute("saleComment",stockCommentService.findStockCommentByCode(request.getParameter("MedicineCode")));
    }
}
