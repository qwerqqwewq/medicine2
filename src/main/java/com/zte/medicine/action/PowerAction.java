package com.zte.medicine.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zte.medicine.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:helloboy
 * Date:2020-02-28 12:54
 * Description:<描述>
 */
public class PowerAction extends ActionSupport {
    public PowerService getPowerService() {
        return powerService;
    }

    public void setPowerService(PowerService powerService) {
        this.powerService = powerService;
    }

    @Autowired
    private PowerService powerService;

}
