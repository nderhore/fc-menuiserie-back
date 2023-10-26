package fr.studi.menuiserie.security.payload.repository;

import fr.studi.menuiserie.security.model.ERole;
import fr.studi.menuiserie.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
