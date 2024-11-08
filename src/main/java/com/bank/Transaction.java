package com.bank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

public class Transaction implements JsonConverter{
    enum TypeTransaction{
        VIRIN,
        VIREST,
        VIRCKAK,
        VIRMULTA
    }
    @Getter private String timeStamp, reference;
    @Getter TypeTransaction typeTransaction;
    List<Compte> comptes = new ArrayList<>();

    public Transaction(String reference, String timeStamp, List<Compte> comptes){
        this.reference = reference ;
        this.timeStamp = timeStamp;
        this.comptes = comptes.subList(0, comptes.size()); 
        setTypeTransaction();
    }

    private void setTypeTransaction(){
        Set<String> countries = new HashSet<>();
        Set<String> ids = new HashSet<>();
        for(Compte compte : comptes){
            countries.add(compte.banque.getPays());
            ids.add(compte.banque.getId());
        }
        if(ids.size() == 1) typeTransaction = TypeTransaction.VIRIN;
        else if(countries.size() == 1) typeTransaction = TypeTransaction.VIREST;
        else if(countries.size() == 1 && ids.size() > 1) typeTransaction = TypeTransaction.VIRMULTA;
        else if(countries.size() > 1 && ids.size()>1) typeTransaction = TypeTransaction.VIRCKAK;
    }


}