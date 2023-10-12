package fr.studi.menuiserie.ws;

import fr.studi.menuiserie.pojo.Horaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.studi.menuiserie.service.HoraireService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = ApiRegistration.REST_HORAIRE)
public class HoraireWs {

    @Autowired
    private HoraireService horaireService;

    @GetMapping
    public List<Horaire> getAllhoraires(){
        return horaireService.getAllhoraires();
    }

    @PostMapping
    public void createHoraire(@RequestBody Horaire horaire){
        horaireService.createHoraire(horaire);
    }

    @PutMapping("/{id}")
    public void updateHoraire(@PathVariable("id") Long id,
                              @RequestBody Horaire horaire){
        horaireService.updateHoraire(id,horaire);
    }

    @DeleteMapping("/{id}")
    public void deleteHoraireById(@PathVariable("id") Long id){
        horaireService.deleteHoraireById(id);
    }

}
