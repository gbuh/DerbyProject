package service;

import entity.UserM;

import java.util.List;

public interface UserMService {

    List<UserM> findAll();

    void insert(UserM userM);

    UserM findById(Long id);

    void update(UserM userM);

    void delete(Long id);
}
