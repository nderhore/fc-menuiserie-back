package fr.studi.menuiserie.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,}",
    message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial.")
    private String password;

    @NotBlank
    @Email
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(){
        //vide par defaut
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
