package mr.temir.repositories;

import mr.temir.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Users findById(Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    @Transactional
    public List<Users> findAll() {
        TypedQuery<Users> q = entityManager.createQuery("from Users", Users.class);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Users save(Users user) {
        entityManager.persist(user);
        return entityManager.find(Users.class, user.getId());
    }

    @Override
    @Transactional
    public void update(Users user) {
        Users userToUpdate = findById(user.getId());

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Users userToRemove = findById(id);
        entityManager.remove(userToRemove);
    }
}
