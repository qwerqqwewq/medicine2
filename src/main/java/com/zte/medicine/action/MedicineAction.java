package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.entity.Kind;
import com.zte.medicine.entity.Medicine;
import com.zte.medicine.service.FirmService;
import com.zte.medicine.service.KindService;
import com.zte.medicine.service.MedicineService;
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
@RequestMapping("/medicine")
@SessionAttributes("medicine")
public class MedicineAction extends ActionSupport {

    public MedicineService getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @Autowired
    private MedicineService medicineService;

    public FirmService getFirmService() {
        return firmService;
    }

    public void setFirmService(FirmService firmService) {
        this.firmService = firmService;
    }

    public KindService getKindService() {
        return kindService;
    }

    public void setKindService(KindService kindService) {
        this.kindService = kindService;
    }

    private FirmService firmService;
    private KindService kindService;

    /**
     * 插入药品信息
     * @return
     * @throws Exception
     */
    public void add() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Map map = new HashMap(50);
        Gson gson =new Gson();


        Medicine medicine = new Medicine();
        medicine.setMedicineCode(request.getParameter("MedicineCode"));
        medicine.setMedicineName(request.getParameter("MedicineName"));
        medicine.setListPrice(request.getParameter("ListPrice"));
        medicine.setPrice(request.getParameter("Price"));
        medicine.setStock(Integer.parseInt(request.getParameter("Stock")));
        medicine.setFirstDate(Timestamp.valueOf(request.getParameter("FirstDate")));
        medicine.setUsefullDate(Timestamp.valueOf(request.getParameter("UsefullDate")));
        List<Firm> list= firmService.findFirmByCode(request.getParameter("FirmCode"));
        Firm firm = list.get(0);
        medicine.settFirmByFirmCode(firm);
        Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        medicine.settKindByKindCode(kind);
        try {
            medicineService.addMedicine(medicine);
            out.print("<script>alert('添加成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('添加失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        }
    }

    /**
     * 修改药品信息
     * @return
     * @throws Exception
     */
    public void updateMedicine() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Map map = new HashMap(50);
        Gson gson =new Gson();

        Medicine medicine = new Medicine();
        medicine.setMedicineCode(request.getParameter("MedicineCode"));
        medicine.setMedicineName(request.getParameter("MedicineName"));
        medicine.setListPrice(request.getParameter("ListPrice"));
        medicine.setPrice(request.getParameter("Price"));
        medicine.setStock(Integer.parseInt(request.getParameter("Stock")));
        medicine.setFirstDate(Timestamp.valueOf(request.getParameter("FirstDate")));
        medicine.setUsefullDate(Timestamp.valueOf(request.getParameter("UsefullDate")));
        List<Firm> list= firmService.findFirmByCode(request.getParameter("FirmCode"));
        Firm firm = list.get(0);
        medicine.settFirmByFirmCode(firm);
        Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        medicine.settKindByKindCode(kind);
        try {
            medicineService.modifyMedicine(medicine);
            out.print("<script>alert('修改成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('修改失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        }
    }

    /**
     * 查询药品界面
     * @return
     */
    public String medicinePage(){
        return "search";
    }

    /**
     * 添加药品界面
     * @return
     */
    public String addPage(){
        return "add";
    }

    /**
     * 编辑药品界面
     * @return
     */
    public String changePage(){
        return "change";
    }

    /**
     * 删除药品信息
     * @return
     * @throws Exception
     */
    public String deleteMedicine() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Map map = new HashMap(50);
        Gson gson =new Gson();

        Medicine medicine = new Medicine();
        medicine = medicineService.findMedicineByName(request.getParameter("MedicineName")).get(0);
        //medicine.setMedicineCode(request.getParameter("MedicineCode"));
        //medicine.setMedicineName(request.getParameter("MedicineName"));
        //medicine.setListPrice(request.getParameter("ListPrice"));
        //medicine.setPrice(request.getParameter("Price"));
        //medicine.setStock(Integer.parseInt(request.getParameter("Stock")));
        //medicine.setFirstDate(Timestamp.valueOf(request.getParameter("FirstDate")));
        //medicine.setUsefullDate(Timestamp.valueOf(request.getParameter("UsefullDate")));
        //Firm firm = firmService.findFirmByCode(request.getParameter("FirmCode"));
        //medicine.settFirmByFirmCode(firm);
        //Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        //medicine.settKindByKindCode(kind);
        try {
            medicineService.removeMedicine(medicine);
            out.print("<script>alert('删除成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('删除失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
        }
        return gson.toJson(map);
    }


    /**
     * 初级查询（只能根据药品名称查询）
     * @return
     * @throws Exception
     */
    public String search() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //
        //Map map = new HashMap(50);
        //Gson gson =new Gson();

        if (medicineService.findMedicineByName(request.getParameter("MedicineName")) != null) {
            List<Medicine> medicines = medicineService.findMedicineByName(request.getParameter("MedicineName"));
            request.setAttribute("medicines", medicines);
            return "search";
        } else {
            out.print("<script>alert('没有结果！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
            return "search";
        }

    }

    /**
     * 高级查询
     * @return
     * @throws Exception
     */
    public String advancedSearch() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String stock =  request.getParameter("stock2");
        String listPrice = request.getParameter("ListPrice");
        String listPrice2 = request.getParameter("ListPrice2");
        String price = request.getParameter("Price");
        String price2 = request.getParameter("Price2");
        String date1 = request.getParameter("FirstDate");
        String date2 = request.getParameter("FirstDate2");
        String date3 = request.getParameter("UsefullDate");
        String date4 = request.getParameter("UsefullDate2");
        if (request.getParameter("MedicineName")!=null|| request.getParameter("KindCode")!=null|| request.getParameter("FirmCode")!=null||listPrice!=null||listPrice2!=null||price!=null||price2!=null||date1!=null||date2!=null||date3!=null||date4!=null) {
            List<Medicine> medicines = medicineService.advancedSearch(request.getParameter("MedicineName"), request.getParameter("KindCode"),request.getParameter("FirmCode"),listPrice,listPrice2,price,price2,Timestamp.valueOf(date1),Timestamp.valueOf(date2),Timestamp.valueOf(date3),Timestamp.valueOf(date4));
            request.setAttribute("medicines",medicines);
            return "search";
        } else {
            out.print("<script>alert('没有搜索结果！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/medicine_medicinePage.action'</script>");
            out.flush();
            out.close();
            return "search";
        }

    }

}
