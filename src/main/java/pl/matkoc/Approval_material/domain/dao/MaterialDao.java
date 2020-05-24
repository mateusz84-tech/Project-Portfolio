package pl.matkoc.Approval_material.domain.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.matkoc.Approval_material.domain.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class MaterialDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(Material material){
        entityManager.persist(material);
    }

    public Material readById(Long id){
        return entityManager.find(Material.class, id);
    }

    public void update(Material material){
        entityManager.merge(material);
    }

    public void delete(Material material){
        entityManager.remove(entityManager.contains(material) ?
                material : entityManager.merge(material));
    }
}
