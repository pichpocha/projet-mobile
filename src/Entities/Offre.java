/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Bechir Hassine
 */
public class Offre {
    private int id_offre;
    private int id_user;
    private String Titre;
    private String Description;
    private String Emplacement;
    private float prix;
    private String image;
    
    
    public Offre() {
    }

    public Offre(int id_user, String Titre, String Description, String Emplacement, float prix,String image) {
        this.id_user = id_user;
        this.Titre = Titre;
        this.Description = Description;
        this.Emplacement = Emplacement;
        this.prix = prix;
        this.image=image;
       
    }

    public Offre(int id_offre, int id_user, String Titre, String Description, String Emplacement, float prix, String image) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.Titre = Titre;
        this.Description = Description;
        this.Emplacement = Emplacement;
        this.prix = prix;
        this.image = image;
    }

  

    public Offre(int aInt, int aInt0, String string, String string0, String string1, float aFloat) {
        
    }
   

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String Emplacement) {
        this.Emplacement = Emplacement;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
    
}
