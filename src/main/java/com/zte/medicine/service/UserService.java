package com.zte.medicine.service;

import com.zte.medicine.entity.User;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:12
 * Description:<描述>
 */
public interface UserService {
    /**
     * 根据用户姓名查询
     * @param  name
     * @return
     **/
    public User findByName(String name);
    /**
     * 根据用户编号查询
     * @param  Id
     * @return
     **/
    public User findById(Integer Id);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public void addUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    public void removeUser(Integer id);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    public void modifyUser(User user);
}
