package com.zte.medicine.service;

import com.zte.medicine.entity.Kind;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:15
 * Description:<描述>
 */
public interface KindService {
    /**
     * 根据种类编码查询药品种类信息
     * @param code
     * @return
     */
    public List<Kind> findKindByCode(String code);

    /**
     * 添加药品种类
     * @param kind
     * @return
     */
    public void addKind(Kind kind);

    /**
     * 修改药品种类信息
     * @param kind
     * @return
     */
    public void modifyKind(Kind kind);

    /**
     * 根据种类编码删除药品某个种类
     * @param code
     * @return
     */
    public void removeKindByCode(String code);


    public List<Kind> findAll();
}
