package com.zte.medicine.service.impl;

import com.zte.medicine.dao.PowerDao;
import com.zte.medicine.entity.Power;
import com.zte.medicine.service.PowerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:25
 * Description:<描述>
 */
@Service("PowerService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class PowerServiceImpl implements PowerService {


    @Resource
    private PowerDao powerDao;

    @Override
    public Power findById(Integer id) {
        return powerDao.selectById(id);
    }
}
