package mr.temir.service;

import mr.temir.model.Users;
import mr.temir.repositories.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepositoryImpl userDao;

    @Transactional
    @Override
    public Users findUserById(Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public List<Users> findAllUsers(int pageNumber, int rowPerPage) {
        return userDao.findAll(pageNumber, rowPerPage);
    }

    @Transactional
    @Override
    public Users saveUser(Users user) {
        return userDao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(Users user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public Long countAllUsers() {
        return userDao.count();
    }
}
