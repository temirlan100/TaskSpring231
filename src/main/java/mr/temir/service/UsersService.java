package mr.temir.service;

import mr.temir.model.Users;

import java.util.List;

public interface UsersService {
    Users findUserById(Long id);

    List<Users> findAllUsers(int pageNumber, int rowPerPage);

    Users saveUser(Users user);

    void updateUser(Users user);

    void deleteUserById(Long id);

    Long countAllUsers();
}
