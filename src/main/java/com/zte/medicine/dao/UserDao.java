package com.zte.medicine.dao;

import com.zte.medicine.entity.User;

import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-28 10:48
 * Description:<描述>
 * @author pj19980729
 */
public interface UserDao {
    /**
     * 根据用户姓名查询
     * @param  name
     * @return
    **/
    public List<User> selectByName(String name);
    /**
    * 根据用户编号查询
    * @param  Id
    * @return
    **/
    public User selectById(Integer Id);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public void insertUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    public void deleteUser(Integer id);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    public void updateUser(User user);
}
