package pl.matkoc.Approval_material.domain.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.matkoc.Approval_material.domain.model.Inspector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class InspectorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(Inspector inspector){
        entityManager.persist(inspector);
    }

    public Inspector readById(Long id){
        return entityManager.find(Inspector.class, id);
    }

    public void update(Inspector inspector){
        entityManager.merge(inspector);
    }

    public void delete(Inspector inspector){
        entityManager.remove(entityManager.contains(inspector) ?
                inspector : entityManager.merge(inspector));
    }
}
