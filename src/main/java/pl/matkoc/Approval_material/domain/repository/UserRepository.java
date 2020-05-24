package pl.matkoc.Approval_material.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matkoc.Approval_material.domain.model.Material;
import pl.matkoc.Approval_material.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
