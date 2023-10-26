package fr.studi.menuiserie.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole nom;

    public Role(){

    }

    public Role(ERole nom){
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getNom() {
        return nom;
    }

    public void setNom(ERole nom) {
        this.nom = nom;
    }
}
