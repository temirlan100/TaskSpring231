package mr.temir.repositories;

import mr.temir.model.Users;

import java.util.List;

public interface UsersDAO {

    Users findById(Long id);

    List<Users> findAll();

    Users save(Users user);

    void update(Users user);

    void deleteById(Long id);
}
