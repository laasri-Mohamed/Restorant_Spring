package ma.projet.restorant.entities;

public class Admin extends User {

    public Admin() {

    }

    public Admin(String nom, String email, String password) {
        super(nom,  email, password);
    }

    public Admin(String nom, String prenom, String tele, String adresse, String email, String password) {
        super(nom,  tele, email, password);
    }

    public Admin(int id, String nom, String email, String password) {
        super(id, nom, email, password);
    }

}