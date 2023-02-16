package ma.projet.restorant.entities;


public class Client extends User {

 
    public Client() {
    }

    public Client(String nom, String prenom, String tele, String adresse, String email, String password) {
        super(nom,  tele, email, password);
    }

    
}
