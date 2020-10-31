package mr.temir.service;

import mr.temir.model.Users;

import java.util.List;

public interface UsersService {
    Users findUserById(Long id);

    List<Users> findAllUsers();

    Users saveUser(Users user);

    void updateUser(Users user);

    void deleteUserById(Long id);
}
