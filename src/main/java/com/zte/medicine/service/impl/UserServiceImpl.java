package com.zte.medicine.service.impl;

import com.zte.medicine.dao.UserDao;
import com.zte.medicine.entity.User;
import com.zte.medicine.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:24
 * Description:<描述>
 */
@Service("UserService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;


    @Override
    public List<User> findByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public User findById(Integer Id) {
        return userDao.selectById(Id);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void removeUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> findAll(){
        return userDao.selectAll();
    }
}
