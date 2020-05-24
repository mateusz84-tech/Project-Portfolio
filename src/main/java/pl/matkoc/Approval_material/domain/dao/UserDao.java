package pl.matkoc.Approval_material.domain.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.matkoc.Approval_material.domain.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(Material user){
        entityManager.persist(user);
    }

    public Material readById(Long id){
        return entityManager.find(Material.class, id);
    }

    public void update(Material user){
         entityManager.merge(user);
    }

    public void delete(Material user){
        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));
    }

}
