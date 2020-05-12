package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.UserDao;
import com.zte.medicine.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy Date:2020-03-13 9:19
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<User> selectByName(String name) {
        return (List<User>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_user where username=" + name + ";").list();
    }

    @Override
    public User selectById(Integer Id) {
        return (User)sessionFactory.getCurrentSession().createSQLQuery("select * from t_user where id=" + Id + ";");
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().createSQLQuery("insert into t_user(username,password,powerId) values ('"+user.getUsername()+"','"+user.getPassword()+"',"+1+");");
    }

    @Override
    public void deleteUser(Integer id) {
        sessionFactory.getCurrentSession().delete(selectById(id));
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
