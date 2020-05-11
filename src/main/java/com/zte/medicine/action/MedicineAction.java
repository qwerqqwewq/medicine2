package com.zte.medicine.action;

import com.google.gson.Gson;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.entity.Kind;
import com.zte.medicine.entity.Medicine;
import com.zte.medicine.service.FirmService;
import com.zte.medicine.service.KindService;
import com.zte.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MedicineAction {

    @Autowired
    private MedicineService medicineService;
    private FirmService firmService;
    private KindService kindService;

    /**
     * 插入药品信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String add( HttpServletRequest request, HttpServletResponse response) throws Exception{
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
        Firm firm = firmService.findFirmByCode(request.getParameter("FirmCode"));
        medicine.settFirmByFirmCode(firm);
        Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        medicine.settKindByKindCode(kind);
        try {
            medicineService.addMedicine(medicine);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "插入失败");
        }
        return gson.toJson(map);
    }

    /**
     * 修改药品信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateMedicine( HttpServletRequest request, HttpServletResponse response) throws Exception{
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
        Firm firm = firmService.findFirmByCode(request.getParameter("FirmCode"));
        medicine.settFirmByFirmCode(firm);
        Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        medicine.settKindByKindCode(kind);
        try {
            medicineService.modifyMedicine(medicine);
            map.put("msg", "修改成功");
        } catch (Exception e) {
            map.put("msg", "修改失败");
        }
        return gson.toJson(map);
    }

    /**
     * 删除药品信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String deleteMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
        Firm firm = firmService.findFirmByCode(request.getParameter("FirmCode"));
        medicine.settFirmByFirmCode(firm);
        Kind kind = kindService.findKindByCode(request.getParameter("KindCode"));
        medicine.settKindByKindCode(kind);
        try {
            medicineService.removeMedicine(medicine);
            map.put("msg", "修改成功");
        } catch (Exception e) {
            map.put("msg", "修改失败");
        }
        return gson.toJson(map);
    }


    /**
     * 初级查询（只能根据药品名称查询）
     * @return
     * @throws Exception
     */
    @RequestMapping("/search")
    public String search( HttpServletRequest request, Model model) throws Exception {
        Map map = new HashMap(50);
        Gson gson =new Gson();

        if (medicineService.findMedicineByName(request.getParameter("MedicineName")) != null) {
            List<Medicine> medicines = medicineService.findMedicineByName(request.getParameter("MedicineName"));
            model.addAttribute("medicines", medicines);
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 高级查询
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/advancedSearch")
    public String advancedSearch( HttpServletRequest request, Model model) throws Exception {
        String stock =  request.getParameter("stock2");
        if (request.getParameter("MedicineCode")!=null||request.getParameter("MedicineName")!=null|| request.getParameter("KindCode")!=null||request.getParameter("Stock")!=null|| request.getParameter("FirmCode")!=null|| request.getParameter("FirstDate")!=null||request.getParameter("UsefullDate")!=null) {
            List<Medicine> medicines = medicineService.advancedSearch(request.getParameter("MedicineCode"),request.getParameter("MedicineName"), request.getParameter("KindCode"),Integer.parseInt(request.getParameter("Stock")), stock, request.getParameter("FirmCode"), Timestamp.valueOf(request.getParameter("FirstDate")), Timestamp.valueOf(request.getParameter("UsefullDate")));
            model.addAttribute("medicines",medicines);
            return "success";
        } else {
            return "fail";
        }

    }

}
