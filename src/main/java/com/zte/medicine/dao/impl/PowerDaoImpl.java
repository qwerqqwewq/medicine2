package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.PowerDao;
import com.zte.medicine.entity.Power;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:12
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("PowerDao")
public class PowerDaoImpl implements PowerDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Power selectById(Integer Id) {
        return (Power) sessionFactory.getCurrentSession().get(Power.class,Id);
    }
}
