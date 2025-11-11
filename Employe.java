/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ORIGINAL SHOP
 */
public class Employe {
    private int id;
    private String nom;
    private String poste;

    public Employe() {}
    public Employe(String nom, String poste) {
        this.nom = nom;
        this.poste = poste;
    }
    public Employe(int id, String nom, String poste) {
        this(nom, poste);
        this.id = id;
    }
    // Getters/Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    
}
