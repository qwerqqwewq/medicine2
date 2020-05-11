package com.zte.medicine.action;

import com.google.gson.Gson;
import com.zte.medicine.entity.Kind;
import com.zte.medicine.service.KindService;
import com.zte.medicine.service.impl.KindServiceImpl;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:55
 * Description:<描述>
 */
@Controller
@RequestMapping("kind")
@SessionAttributes("/kind")
public class KindAction {

    @RequestMapping("/add")
    public String add(ActionMapping mapping,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map map = new HashMap(50);
        Gson gson =new Gson();

        //创建类别对象
        Kind k = new Kind();
        try {
            k.setKindCode(request.getParameter("KindCode"));
            k.setKindRemark(request.getParameter("KindRemark"));
            KindService kindService = new KindServiceImpl();
            kindService.addKind(k);
            map.put("msg","添加成功");
        }catch (Exception e){
            map.put("msg", "添加失败");
        }

        return gson.toJson(map);
    }
}
