package mr.temir.repositories;

import mr.temir.model.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UsersRepository extends PagingAndSortingRepository<Users, Long>, JpaSpecificationExecutor<Users> {
    @Query("SELECT COUNT(u.id) FROM Users u")
    Long countUsers();
}
