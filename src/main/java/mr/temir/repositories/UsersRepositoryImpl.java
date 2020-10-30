package mr.temir.repositories;

import mr.temir.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepositoryImpl {

    @Autowired
    private UsersRepository usersRepository;

    private boolean existsById(Long id) {
        return usersRepository.existsById(id);
    }

    public Users findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public List<Users> findAll(int pageNumber, int rowPerPage) {
        List<Users> contacts = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("id").ascending());

        usersRepository.findAll(sortedByIdAsc).forEach(contacts::add);

        return contacts;
    }

    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public void update(Users user) {
        usersRepository.save(user);
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    public Long count() {
        return usersRepository.countUsers();
    }
}
