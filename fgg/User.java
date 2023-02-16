package ma.projet.restorant.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "USER")
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom , tele ;
    private String email, password , code;
    private int etat;

    public User() {
    }
    
    
    
    public User(int id, String nom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
    }
    
    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public User(String nom,  String tele,  String email, String password) {
        this.nom = nom;
        
        this.tele = tele;
      
        this.email = email;
        this.password = password;
    }

    public User(int id, String nom,  String tele, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.tele = tele;
        this.email = email;
        this.password = password;
    }

   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

   

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.nom; //To change body of generated methods, choose Tools | Templates.
    }

    
}
