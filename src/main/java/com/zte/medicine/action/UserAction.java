package com.zte.medicine.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.entity.Power;
import com.zte.medicine.entity.User;
import com.zte.medicine.service.PowerService;
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

    @Autowired
    private PowerService powerService;

    public void setPowerService(PowerService powerService) {
        this.powerService = powerService;
    }

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
                    List<User> users = userService.findAll();
                    request.setAttribute("users",users);
                    return "admin";
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
                power.setId(2);
                power.setPower("用户");
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

    /**
     * 修改密码
     * @return
     * @throws Exception
     */
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

    /**
     * 主界面
     * @return
     */
    public String mainPage(){
        return "success";
    }

    /**
     * 管理员界面
     * @return
     * @throws Exception
     */
    public String adminPage() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<User> users = userService.findAll();
        request.setAttribute("users",users);

        return "admin";

    }

    /**
     * 删除用户
     * @throws Exception
     */
    public void delete() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("UserId");
        User user = new User();
        user = userService.findById(Integer.parseInt(id));
        //user.setId(-1);
        user.setUsername("-1");

        try {
            userService.modifyUser(user);
            out.print("<script>alert('删除成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print("<script>alert('删除失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
        }


    }

    /**
     * 重置密码
     * @throws Exception
     */
    public void reset() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("UserId");
        User user = userService.findById(Integer.parseInt(id));
        user.setPassword(MD5Util.MD5Encode("111111"));
        try {
            userService.modifyUser(user);
            out.print("<script>alert('重置密码成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
        }catch (Exception e){
            out.print("<script>alert('重置密码失败！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
        }

    }

    /**
     * 管理员添加用户界面
     * @return
     */
    public String adminAdd(){
        return "adminAdd";
    }

    /**
     * 管理员添加用户
     * @return
     */
    public void addUser() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String username = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String tpwd = request.getParameter("tpwd");
        String position = request.getParameter("position");
        String powerId = request.getParameter("powerId");
        Integer id = Integer.parseInt(powerId);

        if (pwd != null) {
            if (pwd.equals(tpwd)) {
                User user = new User();
                BeanUtils.populate(user, request.getParameterMap());
                Power power = new Power();
                user.setUsername(username);
                user.setName(name);
                String mpwd = MD5Util.MD5Encode(pwd);
                user.setPassword(mpwd);
                //power.setId(id);
                //power.setPower(powerService.findById(id).getPower());
                power = powerService.findById(id);
                user.setPowerByPowerId(power);
                user.setPosition(position);

                if (name != null) {
                    if (userService.findByName(name).size() == 0) {
                        userService.addUser(user);
                        out.print("<script>alert('添加成功！')</script>");
                        out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
                        out.flush();
                        out.close();
                    } else {
                        out.print("<script>alert('该用户名已存在！')</script>");
                        out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
                        out.flush();
                        out.close();
                    }
                } else {
                    out.print("<script>alert('用户名不能为空！')</script>");
                    out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
                    out.flush();
                    out.close();
                }
            } else {
                out.print("<script>alert('两次输入的密码不同！')</script>");
                out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
                out.flush();
                out.close();
            }
        }else {
            out.print("<script>alert('密码不能为空！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
        }
    }

    /**
     * 修改权限
     * @return
     * @throws Exception
     */
    public String setPower() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("UserId");
        User user = new User();
        Power power1 = new Power();
        power1 = powerService.findById(1);
        Power power2 = new Power();
        power2 = powerService.findById(2);
        user = userService.findById(Integer.parseInt(id));
        String power = user.getPowerByPowerId().getPower();
        if (power.equals("管理员")) {
            user.setPowerByPowerId(power2);
            userService.modifyUser(user);
            out.print("<script>alert('修改成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
            return "admin";
        }else {
            user.setPowerByPowerId(power1);
            userService.modifyUser(user);
            out.print("<script>alert('修改成功！')</script>");
            out.print("<script>window.location.href='${pageContext.request.contextPath}/user_adminPage.action'</script>");
            out.flush();
            out.close();
            return "admin";
        }

    }

    /**
     * 查询用户
     * @return
     * @throws Exception
     */
    public String adminSearch() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("userName");

        List<User> users = userService.findByName(username);
        request.setAttribute("users", users);
        return "admin";

    }

}
