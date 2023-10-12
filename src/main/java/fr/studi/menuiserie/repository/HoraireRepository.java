package fr.studi.menuiserie.repository;

import fr.studi.menuiserie.pojo.Horaire;
import fr.studi.menuiserie.pojo.enumerate.Jour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HoraireRepository extends JpaRepository<Horaire,Long> {
    Optional<Horaire> findHoraireByJour(Jour jour);
}
