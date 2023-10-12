package fr.studi.menuiserie.service;

import fr.studi.menuiserie.pojo.Horaire;
import fr.studi.menuiserie.repository.HoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraireService {

    @Autowired
    private HoraireRepository horaireRepository;

    public List<Horaire> getAllhoraires() {
        return this.horaireRepository.findAll();
    }

    public void deleteHoraireById(Long id) {
        this.horaireRepository.deleteById(id);
    }

    public void createHoraire(Horaire horaire){
        // on verifie qu'il y a qu'un seul horaire pour un jour donné
        Optional<Horaire> unHoraire = this.horaireRepository.findHoraireByJour(horaire.getJour());
        if (unHoraire.isPresent()){
            throw new RuntimeException("Un horaire existe deja pour ce jour");
        } else {
            this.horaireRepository.save(horaire);
        }
    }

    public Horaire getHoraireById(Long id){
        return this.horaireRepository.findById(id).orElse(null);
    }

    public void updateHoraire(Long id, Horaire horaire){
        Horaire oldHoraire = this.getHoraireById(id);
        if(oldHoraire != null){
            oldHoraire.setHeure_matin(horaire.getHeure_matin());
            oldHoraire.setHeure_apres_midi(horaire.getHeure_apres_midi());
            this.horaireRepository.save(oldHoraire);
        }
    }

}
