package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.service.FirmService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

    public void setFirmService(FirmService firmService) {
        this.firmService = firmService;
    }

    @Autowired
    private FirmService firmService;

    /**
     * 添加供应商信息
     * @return
     * @throws Exception
     */
    public String addFirm()throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

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
                out.print("<script>alert('添加成功！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmAddPage.action'</script>");
                out.flush();
                out.close();
                return "add";
            } catch (Exception e) {
                out.print("<script>alert('添加失败！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmAddPage.action'</script>");
                out.flush();
                out.close();
                return "add";
            }
        }else {
            out.print("<script>alert('该供应商信息已存在，请勿重复添加！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmAddPage.action'</script>");
            out.flush();
            out.close();
            return "add";
        }
    }

    /**
     * 修改供应商信息
     * @return
     * @throws Exception
     */
    public void updateFirm()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Firm firm = new Firm();

        firm.setCity(request.getParameter("City"));
        firm.setFirmCode(request.getParameter("FirmCode"));
        firm.setFirmName(request.getParameter("FirmName"));
        firm.setLinkTel(Integer.parseInt(request.getParameter("LinkTel")));
        firm.setLink(request.getParameter("Link"));


        try {
            if (firmService.findFirmByCode(firm.getFirmCode())!=null){
                out.print("<script>alert('该供应商编码已存在，请更换！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmAddPage.action'</script>");
                out.flush();
                out.close();
            }else {
                firmService.modifyFirm(firm);
            }
            //map.put("msg", "添加成功");
        } catch (Exception e) {
            //map.put("msg", "插入失败");
            out.print("<script>alert('修改失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmAddPage.action'</script>");
            out.flush();
            out.close();
        }

        //return gson.toJson(map);
    }

    /**
     * 根据姓名显示供应商信息
     */
    public String searchFirm() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String code = request.getParameter("FirmCode");
        String name = request.getParameter("FirmName");

        if (code != null || name != null) {
            //if (firmService.findFirm(code,name).size() != 0) {
                List<Firm> firms = firmService.findFirm(code, name);
                request.setAttribute("firms", firms);
            return "search";
            //} else {
            //    out.print("<script>alert('无查询结果！')</script>");
            //    out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmSearchPage.action'</script>");
            //    out.flush();
            //    out.close();
            //}
        } else {
            out.print("<script>alert('请输入查询条件！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/firm_firmSearchPage.action'</script>");
            out.flush();
            out.close();
            return "search";
        }
    }

    /**
     * 供应商查询页面
     * @return
     */
    public String firmSearchPage(){
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Firm> firms = firmService.findAll();
        request.setAttribute("firms",firms);
        return "search";
    }

    public String detailInf() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("FirmCode");
        List<Firm> firms = firmService.findFirmByCode(code);
        request.setAttribute("firms",firms);
        return "detail";
    }

    /**
     * 供应商添加页面
     * @return
     */
    public String firmAddPage(){
        return "add";
    }

    public String updatePage() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("FirmCode");
        List<Firm> firms = firmService.findFirmByCode(code);
        request.setAttribute("firms",firms);
        return "update";
    }

}
