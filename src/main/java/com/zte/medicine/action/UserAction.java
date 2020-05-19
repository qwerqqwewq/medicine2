package com.zte.medicine.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Power;
import com.zte.medicine.entity.User;
import com.zte.medicine.service.UserService;
import com.zte.medicine.utils.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:53
 * Description:<描述>
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserAction extends ActionSupport {
    @Autowired
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 判断用户名是否重复
     */
    public boolean confirmName(String name){
        if (userService.findByName(name)==null){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 登录判断
     * 1、是否有此用户
     * 2、密码是否正确
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public String login()throws InvocationTargetException,IllegalAccessException,Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //Map map=new HashMap(50);
        //Gson gson =new Gson();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");


        List<User> list = userService.findByName(name);
        User user = list.get(0);
        String mpwd= MD5Util.MD5Encode(pwd);
        if (user!=null){
            if (mpwd.equals(user.getPassword())){
                String a="管理员";
                if (user.getPowerByPowerId().getPower().equals(a)) {
                    request.getSession().setAttribute("user", user);
                    return "success";
                }else {
                    request.getSession().setAttribute("user", user);
                    return "success";
                }
            }else {
                out.print("<script>alert('用户名或密码不正确！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/user_loginpage.action'</script>");
                out.flush();
                out.close();
            }
        }else {
            out.print("<script>alert('用户名不存在！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_loginpage.action'</script>");
            out.flush();
            out.close();
        }
        return "fail";
    }




    /**
     * 注册表
     * 1、判断用户输入的两次密码是否一致
     * 2、判断该用户名是否已存在
     * 3、通过提交向user表中插入用户信息
     */
    public String regist()throws InvocationTargetException,IllegalAccessException,Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //Map map = new HashMap(50);
        //Gson gson = new Gson();
        String pwd = request.getParameter("pwd");
        String tpwd = request.getParameter("tpwd");
        if (pwd != null) {
            if (pwd.equals(tpwd)) {
                User user = new User();
                BeanUtils.populate(user, request.getParameterMap());
                Power power = new Power();
                String name = request.getParameter("name");
                user.setUsername(name);
                power.setId(1);
                power.setPower("管理员");
                user.setPowerByPowerId(power);
                String mpwd = MD5Util.MD5Encode(pwd);
                user.setPassword(mpwd);
                if (name != null) {
                    if (userService.findByName(name).size() == 0) {
                        userService.addUser(user);
                        return "login";
                    } else {
                        out.print("<script>alert('该用户名已存在！')</script>");
                        out.print("<script>window.location.href='${pageContext.request.contextPath}/user_registpage.action'</script>");
                        out.flush();
                        out.close();
                    }
                } else {
                    out.print("<script>alert('用户名不能为空！')</script>");
                    out.print("<script>window.location.href='${pageContext.request.contextPath}/user_registpage.action'</script>");
                    out.flush();
                    out.close();
                }
            } else {
                out.print("<script>alert('两次输入的密码不同！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/user_registpage.action'</script>");
                out.flush();
                out.close();
            }
        }else {
            out.print("<script>alert('密码不能为空！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_registpage.action'</script>");
            out.flush();
            out.close();
        }
        return "fail";
    }

    public String changePassword() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        User user1 = (User) request.getSession().getAttribute("user");
        String name = user1.getUsername();
        String pwd = request.getParameter("pwd");
        String npwd = request.getParameter("npwd");
        String tpwd = request.getParameter("tpwd");
        if (npwd.equals(tpwd)) {
            if (userService.findByName(name).get(0).getPassword().equals(MD5Util.MD5Encode(pwd))) {
                User user = userService.findByName(name).get(0);
                user.setPassword(MD5Util.MD5Encode(npwd));
                userService.modifyUser(user);
                out.print("<script>alert('修改成功，请重新登录！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/user_loginPage.action'</script>");
                out.flush();
                out.close();
                return "login";
            } else {
                out.print("<script>alert('原密码不对！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/user_passwordPage.action'</script>");
                out.flush();
                out.close();
                return "change";
            }
        }else {
            out.print("<script>alert('原密码不对！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_passwordPage.action'</script>");
            out.flush();
            out.close();
            return "change";
        }
    }

    /**
     * 退出登录
     * @return
     */
    public String exitLogin(){
        HttpServletRequest request =ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    /**
     * 修改密码界面
     * @return
     */
    public String passwordPage(){
        return "change";
    }


    /**
     * 注册界面
     * @return
     */
    public String registpage(){
        return "regist";
    }

    /**
     * 登录界面
     * @return
     */
    public String loginpage(){
        return "login";
    }


    public String mainPage(){
        return "success";
    }





}
