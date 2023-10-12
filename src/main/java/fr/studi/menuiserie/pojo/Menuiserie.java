package fr.studi.menuiserie.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Menuiserie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuiserie_id;

    private String nom;



}
