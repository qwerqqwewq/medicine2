package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Sale;
import com.zte.medicine.entity.SaleComment;
import com.zte.medicine.entity.User;
import com.zte.medicine.service.SaleCommentService;
import com.zte.medicine.service.SaleService;
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
 * Date:2020-02-28 12:54
 * Description:<描述>
 */
@Controller
@RequestMapping("/sale")
@SessionAttributes("sale")
public class SaleAction extends ActionSupport {
    public SaleService getSaleService() {
        return saleService;
    }

    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

    public SaleCommentService getSaleCommentService() {
        return saleCommentService;
    }

    public void setSaleCommentService(SaleCommentService saleCommentService) {
        this.saleCommentService = saleCommentService;
    }

    @Autowired
    private SaleService saleService;
    @Autowired
    private SaleCommentService saleCommentService;

    /**
     * 打开销售界面后显示所有的销售记录
     * @param request
     */
    public void viewAll(HttpServletRequest request) {
        request.setAttribute("sales",saleService.findAll());
    }

    /**
     * 插入销售信息
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

        Sale sale = new Sale();
        SaleComment saleComment = new SaleComment();
        //sale.setAmount(Double.parseDouble(request.getParameter("Amount")));
        sale.setCustomerCode(request.getParameter("CustomerCode"));

        //String saleDate = request.getParameter("SaleDate");
        //Timestamp timestamp = null;
        //if (saleDate != null && "".equalsIgnoreCase(saleDate)) {
        //    timestamp = Timestamp.valueOf(saleDate);
        //}
        sale.setSaleDate(new Timestamp(System.currentTimeMillis()));

        String saleNum = request.getParameter("SaleNum");
        Integer integer = 0;
        if (saleNum != null) {
            integer = Integer.parseInt(saleNum);
        }
        sale.setSaleNum(Integer.parseInt(request.getParameter("SaleNum")));

        User user = (User) request.getSession().getAttribute("user");
        sale.setUserByUserId(user);
        //saleComment.setAmount(Double.parseDouble(request.getParameter("Amount2")));
        sale.setAmount(Double.valueOf(integer));
        saleComment.setAmount(Double.valueOf(integer));
        saleComment.setMedicineCode(request.getParameter("MedicineCode"));

        String number = request.getParameter("Number");
        Integer integer2 = 0;
        if (number != null && "".equalsIgnoreCase(number)) {
            integer2 = Integer.parseInt(number);
        }
        saleComment.setNumber(integer2);
        saleComment.setPrice("111");
        saleComment.setSaleBySaleNum(sale);
        //saleComment.setPrice(request.getParameter("Price"));
        try {
            saleService.addSale(sale);
            saleCommentService.addSaleComment(saleComment);
            out.print("<script>alert('添加成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/sale_saleAddPage.action'</script>");
            out.flush();
            out.close();
            return "add";
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('添加成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/sale_saleAddPage.action'</script>");
            out.flush();
            out.close();
            return "fail";
        }
    }

    /**
     * 查询详情页面
     * @return
     * @throws Exception
     */
    public String detailInf() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String saleNum = request.getParameter("SaleNum");
        List<SaleComment> saleComments = saleCommentService.findSaleCommentByNum(saleNum);
        request.setAttribute("saleComments",saleComments);
        return "detail";
    }

    /**
     * 条件查询
     * @return
     * @throws Exception
     */
    public String advancedSearch() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Sale sale = new Sale();

        String saleNum = request.getParameter("saleNum");
        String userId = request.getParameter("userId");
        String customerCode = request.getParameter("customerCode");
        String saleDate = request.getParameter("saleDate");
        String saleDate2 = request.getParameter("saleDate2");
        String amount = request.getParameter("amount");
        String amount2 =  request.getParameter("amount2");
        Timestamp timestamp1 = null;
        Timestamp timestamp2 = null;
        Integer integer1 = null;
        Integer integer2 = null;
        Double double1 = null;
        Double double2 = null;

        if (saleNum!=null&&!"".equalsIgnoreCase(saleNum)){
            integer1 = Integer.parseInt(saleNum);
        }

        if (userId!=null&&!"".equalsIgnoreCase(userId)){
            integer2 = Integer.parseInt(userId);
        }

        if (saleDate!=null&&!"".equalsIgnoreCase(saleDate)){
            timestamp1 = Timestamp.valueOf(saleDate);
        }

        if (saleDate2!=null&&!"".equalsIgnoreCase(saleDate2)){
            timestamp2 = Timestamp.valueOf(saleDate2);
        }

        if (amount!=null&&!"".equalsIgnoreCase(amount)){
            double1 = Double.valueOf(amount);
        }

        if (amount2!=null&&!"".equalsIgnoreCase(amount2)){
            double2 = Double.valueOf(amount2);
        }

        if (saleNum!=null||userId!=null||customerCode!=null||saleDate!=null||saleDate2!=null|| amount!=null|| amount2!=null) {
            List<Sale> sales = saleService.findSale(integer1,integer2,customerCode,timestamp1,timestamp2,double1,double2);
            request.setAttribute("sales",sales);
            return "search";
        } else {
            out.print("<script>alert('无搜索结果！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/sale_saleSearchPage.action'</script>");
            out.flush();
            out.close();
            return "search";
        }

    }

    /**
     * 销售查询界面
     * @return
     */
    public String saleSearchPage(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("sales",saleService.findAll());
        return "search";
    }

    /**
     * 销售添加页面
     * @return
     */
    public String saleAddPage(){
        return "add";
    }


}
