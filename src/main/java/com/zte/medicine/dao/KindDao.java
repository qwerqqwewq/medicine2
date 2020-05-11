package com.zte.medicine.dao;

import com.zte.medicine.entity.Kind;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:47
 * Description:<描述>
 */
public interface KindDao {
    /**
     * 根据种类编码查询药品种类信息
     * @param code
     * @return
     */
    public Kind selectKindByCode(String code);

    /**
     * 添加药品种类
     * @param kind
     * @return
     */
    public void insertKind(Kind kind);

    /**
     * 修改药品种类信息
     * @param kind
     * @return
     */
    public void updateKind(Kind kind);

    /**
     * 根据种类编码删除药品某个种类
     * @param code
     * @return
     */
    public void deleteKindByCode(String code);
}
