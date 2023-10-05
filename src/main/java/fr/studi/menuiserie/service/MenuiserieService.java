package fr.studi.menuiserie.service;

import fr.studi.menuiserie.pojo.Menuiserie;
import fr.studi.menuiserie.repository.MenuiserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MenuiserieService {

    @Autowired
    private MenuiserieRepository menuiserieRepository;

    public void createMenuiserie(Menuiserie menuiserie){
        this.menuiserieRepository.save(menuiserie);
    }

    public Menuiserie getMenuiserie() {
        Menuiserie maMenuiserie = null;
        List<Menuiserie> menuiserieList = this.menuiserieRepository.findAll();
        if(!menuiserieList.isEmpty()){
            maMenuiserie = menuiserieList.get(0);
        }
        return maMenuiserie;
    }


    public void updateMenuiserie(Menuiserie menuiserie) {
        //recuperation de la menuiserie de la db
        Menuiserie maMenuiserie = this.getMenuiserie();

        //modification de la menuiserie
        maMenuiserie.setAvis(menuiserie.getAvis());
        maMenuiserie.setNom(menuiserie.getNom());
        maMenuiserie.setHoraires(menuiserie.getHoraires());

        //on envoie en base la modification
        this.menuiserieRepository.save(maMenuiserie);

    }
}
