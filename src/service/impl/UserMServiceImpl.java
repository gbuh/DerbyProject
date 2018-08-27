package service.impl;

import dao.UserMDao;
import entity.UserM;
import service.UserMService;

import java.util.List;

public class UserMServiceImpl implements UserMService {

    private UserMDao userMDao;

    public void setUserMDao(UserMDao userMDao) {
        this.userMDao = userMDao;
    }

    @Override
    public List<UserM> findAll() {
        return userMDao.readAll();
    }

    @Override
    public void insert(UserM userM) {
        userMDao.create(userM);
    }

    @Override
    public UserM findById(Long id) {
        return userMDao.read(id);
    }

    @Override
    public void update(UserM userM) {
        userMDao.update(userM);
    }

    @Override
    public void delete(Long id) {
        userMDao.delete(id);
    }
}
