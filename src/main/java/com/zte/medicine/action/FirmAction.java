package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:53
 * Description:<描述>
 */
@Controller
@RequestMapping("/firm")
@SessionAttributes("firm")
public class FirmAction extends ActionSupport {
    public FirmService getFirmService() {
        return firmService;
    }

    public void setFirmService(FirmService firmService) {
        this.firmService = firmService;
    }

    @Autowired
    private FirmService firmService;

    /**
     * 添加供应商信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String addFirm(HttpServletRequest request, Model model)throws Exception{

        Map map = new HashMap(50);
        Gson gson =new Gson();

        Firm firm = new Firm();

        if (firmService.findFirmByName(request.getParameter("FirmName"))!=null) {
            firm.setCity(request.getParameter("City"));
            firm.setFirmCode(request.getParameter("FirmCode"));
            firm.setFirmName(request.getParameter("FirmName"));
            firm.setLinkTel(Integer.parseInt(request.getParameter("LinkTel")));
            firm.setLink(request.getParameter("Link"));

            try {
                firmService.addFirm(firm);
                map.put("msg", "添加成功");
            } catch (Exception e) {
                map.put("msg", "插入失败");
            }
        }else {
            map.put("msg", "供应商信息已存在");
        }
        return gson.toJson(map);
    }

    /**
     * 修改供应商信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateFirm( HttpServletRequest request,Model model)throws Exception{
        Map map = new HashMap(50);
        Gson gson =new Gson();

        Firm firm = new Firm();

        firm.setCity(request.getParameter("City"));
        firm.setFirmCode(request.getParameter("FirmCode"));
        firm.setFirmName(request.getParameter("FirmName"));
        firm.setLinkTel(Integer.parseInt(request.getParameter("LinkTel")));
        firm.setLink(request.getParameter("Link"));


        try {
            firmService.modifyFirm(firm);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "插入失败");
        }

        return gson.toJson(map);
    }

    /**
     * 根据姓名显示供应商信息
     */
    @RequestMapping("/viewAll")
    public void viewByName(HttpServletRequest request){

        firmService.findFirmByName(request.getParameter("FirmName"));
    }
}
