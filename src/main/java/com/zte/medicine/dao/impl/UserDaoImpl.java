package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.UserDao;
import com.zte.medicine.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author:helloboy Date:2020-03-13 9:19
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User selectByName(String name) {
        return (User)sessionFactory.getCurrentSession().get(User.class,name);
    }

    @Override
    public User selectById(Integer Id) {
        return (User)sessionFactory.getCurrentSession().get(User.class,Id);
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class,id));
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
