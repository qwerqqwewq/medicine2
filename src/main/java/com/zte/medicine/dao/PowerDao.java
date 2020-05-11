package com.zte.medicine.dao;

import com.zte.medicine.entity.Power;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:47
 * Description:<描述>
 */
public interface PowerDao {
    /**
     * 根据Id查询权限值
     * @param Id
     * @return
     */
    public Power selectById(Integer Id);
}
