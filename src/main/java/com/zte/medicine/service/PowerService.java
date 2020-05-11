package com.zte.medicine.service;

import com.zte.medicine.entity.Power;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:15
 * Description:<描述>
 */
public interface PowerService {

    /**
     * 根据id查询权限值
     * @param id
     * @return
     */
    public Power findById(Integer id);
}
