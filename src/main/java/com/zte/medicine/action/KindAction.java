package com.zte.medicine.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Kind;
import com.zte.medicine.service.KindService;
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
 * Date:2020-02-28 12:55
 * Description:<描述>
 */
@Controller
@RequestMapping("kind")
@SessionAttributes("/kind")
public class KindAction extends ActionSupport {

    public void setKindService(KindService kindService) {
        this.kindService = kindService;
    }

    @Autowired
    private KindService kindService;


    public String add()throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Map map = new HashMap(50);
        Gson gson =new Gson();

        //创建类别对象
        Kind k = new Kind();
        try {
            String kindCode = request.getParameter("KindCode");
            String kindRemark = request.getParameter("KindRemark");

            k.setKindCode(kindCode);
            k.setKindRemark(kindRemark);
            kindService.addKind(k);
            out.print("<script>alert('添加成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/kind_kindAddPage.action'</script>");
            out.flush();
            out.close();
        }catch (Exception e){
            out.print("<script>alert('添加失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/kind_kindAddPage.action'</script>");
            out.flush();
            out.close();
        }

        return gson.toJson(map);
    }

    public String search() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String kindCode = request.getParameter("KindCode");

        List<Kind> kinds = kindService.findKindByCode(kindCode);
        request.setAttribute("kinds",kinds);
        return "search";
    }

    public String kindSearchPage() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<Kind> kinds = kindService.findAll();
        request.setAttribute("kinds",kinds);
        return "search";
    }


    public String kindAddPage(){
        return "add";
    }

    public String updateKindPage() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("KindCode");
        List<Kind> kinds = kindService.findKindByCode(code);
        request.setAttribute("kinds",kinds);
        return "update";
    }

    public String updateKind() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Kind kind = new Kind();
        String kindCode = request.getParameter("KindCode");
        String kindRemark = request.getParameter("KindRemark");
        kind.setKindCode(kindCode);
        kind.setKindRemark(kindRemark);


        try {
            kindService.modifyKind(kind);
            out.print("<script>alert('修改成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/kind_kindSearchPage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('修改失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/kindSearchPage.action'</script>");
            out.flush();
            out.close();
        }
        return "search";
    }
}
