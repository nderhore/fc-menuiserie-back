package fr.studi.menuiserie.security.payload.repository;

import fr.studi.menuiserie.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //retrouver un utilisateur en base selon son mail
    Optional<User> findByUsername(String username);

    //renvoie vrai ou faux si une personne a deja l'username
    Boolean existsByUsername(String username);

    //retrouver tous les utilisateurs d'un role
    @Query(value = "SELECT u.* " +
            "FROM users u" +
            "JOIN user_roles ur ON ur.user_id = u.id" +
            "JOIN roles r ON r.id = ur.role_id" +
            " WHERE r.name = ?1",
            nativeQuery = true)
    List<User> findUserByRoles(String role);



}
