package fr.studi.menuiserie.repository;

import fr.studi.menuiserie.pojo.Menuiserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuiserieRepository extends JpaRepository<Menuiserie,Long> {

}
