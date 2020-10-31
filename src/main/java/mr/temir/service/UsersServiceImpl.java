package mr.temir.service;

import mr.temir.model.Users;
import mr.temir.repositories.UsersDAO;
import mr.temir.repositories.UsersDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO userDao;

    @Override
    public Users findUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<Users> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        return userDao.save(user);
    }

    @Override
    public void updateUser(Users user) {
        userDao.update(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
