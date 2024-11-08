package com.bank;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
public class Client implements JsonConverter, Serializable{
    @Getter private String nomClient,nom,prenom,address,phone,email;
    @Getter List<Compte> comptes = new ArrayList<>();
    
    public Client(String nomClient, String nom, String prenom, String address, String phone, String email){
        this.nomClient = nomClient;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public void addCompte(String nomCompte, String devise, Date dateCreated, Date dateUpdated, Banque banque){
        Compte compte = new Compte(nomCompte,devise,dateCreated,dateUpdated, banque);
        comptes.add(compte);
    }


}