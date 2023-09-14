package fr.studi.menuiserie.service;

import fr.studi.menuiserie.pojo.Menuiserie;
import fr.studi.menuiserie.repository.MenuiserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuiserieService {

    @Autowired
    private MenuiserieRepository menuiserieRepository;

    public void createMenuiserie(Menuiserie menuiserie){
        this.menuiserieRepository.save(menuiserie);
    }
}
