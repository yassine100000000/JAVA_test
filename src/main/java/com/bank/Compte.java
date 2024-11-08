package com.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
public class Compte implements JsonConverter{
    @Getter private String nomCompte, devise;
    @Getter private Date dateCreated, dateUpdated;
    @Getter List<Transaction> transactions = new ArrayList<>();
    @Getter Banque banque;

    public Compte(String nomCompte, String devise, Date dateCreated, Date dateUpdated, Banque banque){
        this.nomCompte = nomCompte;
        this.devise = devise;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.banque = banque;
    }

    @SuppressWarnings("unchecked")
    public void AddTransaction(String reference, String timeStamp,List<Compte> comptes){
        List<Compte> newComptes = new ArrayList<>();
        newComptes.add(this);
        newComptes.addAll(comptes);
        Transaction transaction = new Transaction(reference, timeStamp, newComptes);
    }



}