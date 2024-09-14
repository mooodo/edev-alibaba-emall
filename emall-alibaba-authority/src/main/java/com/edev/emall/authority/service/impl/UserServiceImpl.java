package com.edev.emall.authority.service.impl;

import com.edev.emall.authority.entity.User;
import com.edev.emall.authority.service.UserService;
import com.edev.emall.utils.ValidUtils;
import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;

import java.util.Collection;

public class UserServiceImpl implements UserService {
    private final BasicDao dao;
    public UserServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void valid(User user) {
        ValidUtils.isNull(user, "user");
        ValidUtils.isNull(user.getId(), "id");
        ValidUtils.isNull(user.getUsername(), "username");
        if(user.getUserType()==null) user.setUserType("guest");
    }
    @Override
    public Long register(User user) {
        valid(user);
        if(userExists(user.getUsername()))
            throw new ValidException("The username exists[%s]", user.getUsername());
        return dao.insert(user);
    }

    @Override
    public void modify(User user) {
        valid(user);
        User oldUser = load(user.getId());
        if(!user.getUsername().equals(oldUser.getUsername()))
            throw new ValidException("The username cannot modify[%s]", user.getUsername());
        dao.update(user);
    }

    @Override
    public void remove(Long userId) {
        dao.delete(userId, User.class);
    }

    @Override
    public User load(Long userId) {
        return dao.load(userId, User.class);
    }

    @Override
    public void removeByName(String username) {
        User template = new User();
        template.setUsername(username);
        dao.delete(template);
    }

    @Override
    public User loadByName(String username) {
        User template = new User();
        template.setUsername(username);
        Collection<User> users = dao.loadAll(template);
        if(users==null||users.isEmpty()) return null;
        return users.iterator().next();
    }

    @Override
    public boolean userExists(String username) {
        return loadByName(username)!=null;
    }
}
