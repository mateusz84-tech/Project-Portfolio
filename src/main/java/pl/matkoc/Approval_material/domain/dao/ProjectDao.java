package pl.matkoc.Approval_material.domain.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.matkoc.Approval_material.domain.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(Project project){
        entityManager.persist(project);
    }

    public Project readById(Long id){
        return entityManager.find(Project.class, id);
    }

    public void update(Project project){
        entityManager.merge(project);
    }

    public void delete(Project project){
        entityManager.remove(entityManager.contains(project) ?
                project : entityManager.merge(project));
    }
}
