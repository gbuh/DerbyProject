package dao;

import entity.UserM;

import java.util.List;

public interface UserMDao extends CrudDao<Long, UserM> {

    List<UserM> readAll();
}
